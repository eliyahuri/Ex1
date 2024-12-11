
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import assignments.ex1.Ex1;

/**
 * This JUnit class represents a very partial test class for Ex1. Make sure you
 * complete all the needed JUnits
 */
public class Ex1Test {

    @Test
    void computeNumberTest() {
        String sEmpty = "";
        assertEquals(Ex1.number2Int(sEmpty), -1);
        String s2 = "1011b2";
        int v = Ex1.number2Int(s2);
        assertEquals(v, 11);
        String s10 = "1011bA";
        v = Ex1.number2Int(s10);
        s2 = Ex1.int2Number(v, 2);
        int v2 = Ex1.number2Int(s2);
        assertEquals(v, v2);
        assertTrue(Ex1.equals(s10, s2));

    }

    @Test
    void isBasisNumberTest() {
        String[] good = {
            "1", "1b2", "01b2", "123bA", "ABbG", "0bA",
            "10b2", "FAb16", "00b16", "9b10", "FFFFb16",
            "1b2", "101010b2", "77b8", "0b2",
            "100b4" // Testing the upper limits of valid bases
        };

        for (int i = 0; i < good.length; i = i + 1) {
            boolean ok = Ex1.isNumber(good[i]);
            assertTrue(ok, "checking valid case: " + good[i]);
        }

        String[] not_good = {
            "b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2",
            "A", "1bb2", "b", "12!b10", "1 b10",
            "123b", "123bb10", "FFFFb0", "123b17",
            "GHIb16", "-1b10", "+123b10", "1b-2", "1b+2",
            "1b", "b16", "999b8", "ZZZb36",
            "12b37", "1b1", "1 0b2", "12b12 ", " 1b12"
        };

        for (int i = 0; i < not_good.length; i = i + 1) {
            boolean not_ok = Ex1.isNumber(not_good[i]);
            assertFalse(not_ok, "checking invalid case: " + not_good[i]);
        }
    }

    @Test
    void int2NumberTest() {
        // Test valid conversions
        assertEquals("1010b2", Ex1.int2Number(10, 2));
        assertEquals("12b8", Ex1.int2Number(10, 8));
        assertEquals("Ab16", Ex1.int2Number(10, 16));
        assertEquals("101b3", Ex1.int2Number(10, 3));

        // Test edge cases
        assertEquals("0b2", Ex1.int2Number(0, 2));
        assertEquals("1b2", Ex1.int2Number(1, 2));
        assertEquals("1b8", Ex1.int2Number(1, 8));
        assertEquals("1b16", Ex1.int2Number(1, 16));

        // Test invalid inputs
        assertEquals("", Ex1.int2Number(-10, 2));
        assertEquals("", Ex1.int2Number(10, 1));
        assertEquals("", Ex1.int2Number(10, 17));

        // Test boundary bases
        assertEquals("1101b2", Ex1.int2Number(13, 2));
        assertEquals("Db16", Ex1.int2Number(13, 16));

        // Test large numbers
        assertEquals("1111111111111111111111111111111b2", Ex1.int2Number(Integer.MAX_VALUE, 2));
        assertEquals("7FFFFFFFb16", Ex1.int2Number(Integer.MAX_VALUE, 16));
    }

    @Test
    void maxIndexTest() {
        // implement this test
    }

    // Add additional test functions - test as much as you can.
}
