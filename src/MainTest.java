import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.AssertJUnit.*;
import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

public class MainTest {
    @Test
    public void testIsPrimeNumberTrue() {
        assertTrue(Main.IsPrimeNumber(2));
        assertTrue(Main.IsPrimeNumber(3));
        assertTrue(Main.IsPrimeNumber(5));
        assertTrue(Main.IsPrimeNumber(7));

    }
    @Test
    public void testIsPrimeNumberFalse() {
        assertFalse(Main.IsPrimeNumber(9));
        assertFalse(Main.IsPrimeNumber(12));
        assertFalse(Main.IsPrimeNumber(15));

    }
    @Test
    public void testPrimeMaxZero() {
        assertEquals(Main.findMax(new int[]{1,3},new int[]{2,17}),17);
        assertEquals(Main.findMax(new int[]{1,2},new int[]{5,19}),19);
        assertEquals(Main.findMax(new int[]{1,4},new int[]{2,97}),97);
        assertArrayEquals(Main.findZeroCounts(new int[]{2,3,5,7,197}),new int[]{1,0,1,0,4});


    }
    @Test
    public void testPrimeArray() {
        int N = 100;
        ArrayList<Integer> maxList = new ArrayList<>();
        maxList.add(67);
        maxList.add(73);
        maxList.add(97);
        int[] zeroCountArr = Main.findZeroCounts(Main.findPrimeNumbers(Main.generateSomeArray(N)));
        assertEquals(Main.showMax(Main.findMax(Main.findPrimeNumbers(Main.generateSomeArray(N)),zeroCountArr),
                Main.findPrimeNumbers(Main.generateSomeArray(N)),zeroCountArr),maxList);
    }
}
