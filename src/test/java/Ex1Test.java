import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import assignments.ex1.Ex1Main;


public class Ex1Test {

    @Test
    public void testIsEven() {
        Ex1Main main = new Ex1Main();
        assertTrue(main.isEven(2),"2 is even");
        assertFalse(main.isEven(3));
    }
}
