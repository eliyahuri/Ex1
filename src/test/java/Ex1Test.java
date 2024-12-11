import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import assignments.ex1.Ex1;

/**
 * This JUnit class represents a comprehensive test suite for Ex1.
 */
public class Ex1Test {

    @Test
    void number2IntTest() {
        // Valid cases
        assertEquals(11, Ex1.number2Int("1011b2"));
        assertEquals(-1, Ex1.number2Int("A"));
        assertEquals(255, Ex1.number2Int("FFb16"));
        assertEquals(0, Ex1.number2Int("0b10"));

        // Invalid cases
        assertEquals(-1, Ex1.number2Int(""));
        assertEquals(-1, Ex1.number2Int(null));
        assertEquals(-1, Ex1.number2Int("b2"));
        assertEquals(-1, Ex1.number2Int("123b17"));
        assertEquals(-1, Ex1.number2Int("1b1"));
        assertEquals(-1, Ex1.number2Int("GHIb16"));
        assertEquals(-1, Ex1.number2Int("1 b10"));
    }

    @Test
    void isNumberTest() {
        // Valid cases
        String[] validNumbers = {
            "1", "1b2", "01b2", "123bA", "ABbG", "0bA",
            "10b2", "FAb16", "00b16", "9b10", "FFFFb16",
            "101010b2", "77b8", "0b2", "100b4"
        };
        for (String num : validNumbers) {
            assertTrue(Ex1.isNumber(num), "Expected valid: " + num);
        }

        // Invalid cases
        String[] invalidNumbers = {
            "b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2",
            "A", "1bb2", "b", "12!b10", "1 b10",
            "123b", "123bb10", "FFFFb0", "123b17",
            "GHIb16", "-1b10", "+123b10", "1b-2", "1b+2",
            "1b", "b16", "999b8", "ZZZb36",
            "12b37", "1b1", "1 0b2", "12b12 ", " 1b12"
        };
        for (String num : invalidNumbers) {
            assertFalse(Ex1.isNumber(num), "Expected invalid: " + num);
        }
    }

    @Test
    void int2NumberTest() {
        // Valid cases
        assertEquals("1010b2", Ex1.int2Number(10, 2));
        assertEquals("12b8", Ex1.int2Number(10, 8));
        assertEquals("Ab16", Ex1.int2Number(10, 16));
        assertEquals("101b3", Ex1.int2Number(10, 3));

        // Edge cases
        assertEquals("0b2", Ex1.int2Number(0, 2));
        assertEquals("1b2", Ex1.int2Number(1, 2));
        assertEquals("1b8", Ex1.int2Number(1, 8));
        assertEquals("1b16", Ex1.int2Number(1, 16));

        // Invalid cases
        assertEquals("", Ex1.int2Number(-10, 2));
        assertEquals("", Ex1.int2Number(10, 1));
        assertEquals("", Ex1.int2Number(10, 17));

        // Large numbers
        assertEquals("1111111111111111111111111111111b2", Ex1.int2Number(Integer.MAX_VALUE, 2));
        assertEquals("7FFFFFFFb16", Ex1.int2Number(Integer.MAX_VALUE, 16));
    }

    @Test
    void equalsTest() {
        // Equal cases
        assertTrue(Ex1.equals("1011b2", "11"));
        assertTrue(Ex1.equals("A", "Ab10"));
        assertTrue(Ex1.equals("FFb16", "255"));

        // Unequal cases
        assertFalse(Ex1.equals("1011b2", "10"));
        assertFalse(Ex1.equals("A", "B"));
        assertFalse(Ex1.equals("FFb16", "256"));

        // Invalid cases
        assertFalse(Ex1.equals("", "11"));
        assertFalse(Ex1.equals("1011b2", ""));
        assertFalse(Ex1.equals(null, "11"));
        assertFalse(Ex1.equals("1011b2", null));
    }

    @Test
    void maxIndexTest() {
        // Valid cases
        String[] arr1 = {"101b2", "A", "FFb16", "1010b2"};
        assertEquals(2, Ex1.maxIndex(arr1));

        String[] arr2 = {"123bA", "FFFFb16", "0b10", "FAb16"};
        assertEquals(1, Ex1.maxIndex(arr2));

        // Array with invalid numbers
        String[] arr3 = {"101b2", "invalid", "FFb16", null};
        assertEquals(2, Ex1.maxIndex(arr3));

        // Array with equal max values
        String[] arr4 = {"FFb16", "255", "0b10"};
        assertEquals(0, Ex1.maxIndex(arr4));

        // All invalid numbers
        String[] arr5 = {"invalid", null, "not_a_number"};
        assertEquals(-1, Ex1.maxIndex(arr5));
    }
}
