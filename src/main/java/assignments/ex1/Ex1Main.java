package assignments.ex1;

import java.util.Scanner;

/**
 * Intro2CS, Ex1 - very basic "main template" Make sure your implementation of
 * this main performs as the Ex1Sol.jar solution implement all needed functions.
 *
 */
public class Ex1Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2 = "", quit = "quit";

        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");

            // Input number 1
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();
            if (num1.equals(quit)) {
                break;
            }

            System.out.printf("num1= %s is number: %b , value: %d\n", num1, Ex1.isNumber(num1), Ex1.number2Int(num1));

            if (!Ex1.isNumber(num1)) {
                System.out.printf("ERR: num1 is in the wrong format! (%s)\n", num1);
                continue;
            }

            // Input number 2
            System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
            num2 = sc.next();
            if (num2.equals(quit)) {
                break;
            }

            System.out.printf("num2= %s is number: %b , value: %d\n", num2, Ex1.isNumber(num2), Ex1.number2Int(num2));

            if (!Ex1.isNumber(num2)) {
                System.out.printf("ERR: num2 is in the wrong format! (%s)\n", num2);
                continue;
            }

            // Input base for output
            System.out.println("Enter a base for output: (a number [2,16]");
            int base = sc.nextInt();

            if (base < 2 || base > 16) {
                System.out.printf("ERR: base %d is not valid!\n", base);
                continue;
            }

            // Perform calculations
            int value1 = Ex1.number2Int(num1);
            int value2 = Ex1.number2Int(num2);

            String sum = Ex1.int2Number(value1 + value2, base);
            String product = Ex1.int2Number(value1 * value2, base);

            System.out.printf("%s + %s = %s\n", num1, num2, sum);
            System.out.printf("%s * %s = %s\n", num1, num2, product);

            // Find max number in the array
            String[] array = {num1, num2, sum, product};
            int maxIndex = Ex1.maxIndex(array);
            System.out.printf("Max number over %s is: %s\n", java.util.Arrays.toString(array), array[maxIndex]);
        }

        System.out.println("quitting now...");
    }
}
