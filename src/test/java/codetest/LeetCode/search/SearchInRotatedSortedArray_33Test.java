package codetest.LeetCode.search;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SearchInRotatedSortedArray_33Test {

    @Test
    public void search() {
        /*
         * Input: nums = [4,5,6,7,0,1,2], target = 0
         * Output: 4
         *
         *
         * Example 2:
         *
         *  [12, 13, 14, 15, 16, 17, 0, 1, 2, 3, 4, 5, 6, 7 ,8, 9, 10, 11]
         * Input: nums = [4,5,6,7,0,1,2,3], target = 9
         * Output: -1
         *
         */

        SearchInRotatedSortedArray_33 test = new SearchInRotatedSortedArray_33();
        Assert.assertEquals(4, test.search(new int[] {4,5,6,7,0,1,2}, 0));
        Assert.assertEquals(-1, test.search(
                new int[] {12, 13, 14, 15, 16, 17, 0, 1, 2, 3, 4, 5, 6, 7 ,8, 9, 10, 11},
                9));
    }
}