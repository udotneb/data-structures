import org.junit.Test;
import static org.junit.Assert.*;

public class QuickSortTest {
    @Test
    public void IntegerTest() {
        Integer[] x = new Integer[]{9,1,6,2,3,4,7,8,5};
        QuickSort.sort(x);
        assertArrayEquals(x, new Integer[]{1,2,3,4,5,6,7,8,9});

        Integer[] y = new Integer[]{};
        QuickSort.sort(y);
        assertArrayEquals(y, new Integer[]{});

        Integer[] z = new Integer[]{-3,0,2,1,-2};
        QuickSort.sort(z);
        assertArrayEquals(z, new Integer[]{-3,-2,0,1,2});
    }

    @Test
    public void StringTest() {
        String[] y = new String[]{"a","apple", "ape", "ab"};
        QuickSort.sort(y);
        assertArrayEquals(y, new String[]{"a", "ab", "ape", "apple"});
    }
}
