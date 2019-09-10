package se.redmind.liastart.binarysearch;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class BinarySearchTest {

    private Class binarySearchClass;
    private BinarySearch search;

    public BinarySearchTest(Class binarySearchClass) {
        this.binarySearchClass = binarySearchClass;
    }

    @Before
    public void setUp() throws Exception {
        search = (BinarySearch) binarySearchClass.newInstance();
    }


    @Test
    public void test() {
        assertEquals(-1, chop(3, new int[]{}));
        assertEquals(-1, chop(3, new int[]{1}));
        assertEquals(0, chop(1, new int[]{1}));

        assertEquals(0, chop(1, new int[]{1, 3, 5}));
        assertEquals(1, chop(3, new int[]{1, 3, 5}));
        assertEquals(2, chop(5, new int[]{1, 3, 5}));
        assertEquals(-1, chop(0, new int[]{1, 3, 5}));
        assertEquals(-1, chop(2, new int[]{1, 3, 5}));
        assertEquals(-1, chop(4, new int[]{1, 3, 5}));
        assertEquals(-1, chop(6, new int[]{1, 3, 5}));

        assertEquals(0, chop(1, new int[]{1, 3, 5, 7}));
        assertEquals(1, chop(3, new int[]{1, 3, 5, 7}));
        assertEquals(2, chop(5, new int[]{1, 3, 5, 7}));
        assertEquals(3, chop(7, new int[]{1, 3, 5, 7}));
        assertEquals(-1, chop(0, new int[]{1, 3, 5, 7}));
        assertEquals(-1, chop(2, new int[]{1, 3, 5, 7}));
        assertEquals(-1, chop(4, new int[]{1, 3, 5, 7}));
        assertEquals(-1, chop(6, new int[]{1, 3, 5, 7}));
        assertEquals(-1, chop(8, new int[]{1, 3, 5, 7}));
    }

    private int chop(int key, int[] values) {
        return search.chop(key, values);
    }

    @Parameterized.Parameters
    public static Collection data() {
        Object[][] classes = new Object[][]{
                {BinarySearchImplementation1.class},
                {BinarySearchImplementation2.class},
                {BinarySearchImplementation3.class}
        };
        return Arrays.asList(classes);
    }

}
