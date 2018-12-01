package codetest.Algorithum.sort;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MergeSortTest {

    @Test
    public void sort() {
        MergeSort mergeSort = new MergeSort();
        int[] array = new int[] { 3, 4, 6, 5, 9, 8, 1};
        int[] expectArray = new int[] { 1, 3, 4, 5, 6, 8, 9};
        mergeSort.sort(array);
        Assert.assertArrayEquals(array, expectArray);
    }
}