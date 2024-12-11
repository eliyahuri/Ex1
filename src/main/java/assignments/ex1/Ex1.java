package assignments.ex1;

/**
 * This class represents a simple solution for Ex1. As defined here:
 * https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and
 * calculator. In general, we will use Strings as numbers over basis of binary
 * till Hexa. [2-16], 10-16 are represented by A,B,..G. The general
 * representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base),
 * “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”. The following are NOT in the
 * format (not a valid number): “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”,
 * “3 b4”, “GbG”, "", null, You should implement the following static functions:
 */
public class Ex1 {

    /**
     * Convert the given number (num) to a decimal representation (as int). It
     * the given number is not in a valid format returns -1.
     *
     * @param num a String representing a number in basis [2,16]
     * @return
     */
    public static int number2Int(String s) {
        if (s == null || s.isEmpty()) {
            return -1; // Return -1 for null or empty strings
        }
    
        try {
            // If the string contains a base indicator like "b2", handle it appropriately
            if (s.contains("b")) {
                String[] parts = s.split("b");
                int base = Integer.parseInt(parts[1]); // Get the base
                return Integer.parseInt(parts[0], base); // Parse the number with the base
            }
            // Otherwise, parse it as a standard decimal number
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            // Return -1 for any invalid number
            return -1;
        }
    }
    

    
    /**
     * This static function checks if the given String (g) is in a valid
     * "number" format.
     *
     * @param a a String representing a number
     * @return true if the given String is in a number format
     */
    public static boolean isNumber(String a) {
        if (a == null || a.isEmpty()) {
            return false;
        }
    
        // Check for leading spaces
        if (Character.isWhitespace(a.charAt(0))) {
            return false;
        }
    
        if (!a.contains("b")) {
            // Check if it's a valid standalone number
            for (char c : a.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }
            return true;
        }
    
        String[] parts = a.split("b");
        if (parts.length != 2) {
            return false;
        }
    
        String numberPart = parts[0];
        String basePart = parts[1];
    
        if (numberPart.isEmpty() || basePart.isEmpty()) {
            return false;
        }
    
        // Validate base
        int base;
        try {
            base = Character.isDigit(basePart.charAt(0))
                ? Integer.parseInt(basePart)
                : basePart.charAt(0) - 'A' + 10;
        } catch (NumberFormatException e) {
            return false;
        }
    
        if (base < 2 || base > 16) {
            return false;
        }
    
        // Validate number part
        for (char c : numberPart.toCharArray()) {
            int value = Character.isDigit(c) ? c - '0' : c - 'A' + 10;
            if (value >= base) {
                return false;
            }
        }
    
        return true;
    }
    
    

    /**
     * Calculate the number representation (in basis base) of the given natural
     * number (represented as an integer). If num<0 or base is not in [2,16] the
     * function should return "" (the empty String). @param num the natural
     * number (include 0). @param base
     *
     * t
     * he basis [2,16] @return a String representing a number (in base) equals
     * to num, or an empty String (in case of wrong input).
     */
    public static String int2Number(int num, int base) {
        if (num < 0 || base < 2 || base > 16) {
            return "";
        }
        if (num == 0) {
            return "0b" + base; // Handle the case for 0 explicitly
        }
        StringBuilder result = new StringBuilder();
        while (num > 0) {
            int remainder = num % base;
            result.append(remainder < 10 ? (char) (remainder + '0') : (char) (remainder - 10 + 'A'));
            num /= base;
        }
        return result.reverse().toString() + "b" + base;
    }
    

    /**
     * Checks if the two numbers have the same value.
     *
     * @param n1 first number
     * @param n2 second number
     * @return true iff the two numbers have the same values.
     */
    public static boolean equals(String n1, String n2) {
        return number2Int(n1) == number2Int(n2);
    }

    /**
     * This static function search for the array index with the largest number
     * (in value). In case there are more than one maximum - returns the first
     * index. Note: you can assume that the array is not null and is not empty,
     * yet it may contain null or none-valid numbers (with value -1).
     *
     * @param arr an array of numbers
     * @return the index in the array in with the largest number (in value).
     *
     */
    public static int maxIndex(String[] arr) {
        int maxIndex = -1;
        Integer maxValue = null;
    
        for (int i = 0; i < arr.length; i++) {
            int value = number2Int(arr[i]);
            // Skip invalid values (e.g., number2Int returns -1 for invalid numbers)
            if (value == -1 && !arr[i].equals("-1")) {
                continue;
            }
            // Update maxIndex and maxValue if we find a new maximum
            if (maxValue == null || value > maxValue) {
                maxValue = value;
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    
    
}
