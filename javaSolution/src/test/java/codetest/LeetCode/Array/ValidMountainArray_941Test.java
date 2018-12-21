package codetest.LeetCode.Array;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidMountainArray_941Test {

    //Input: [2,1]
    //Output: false
    //Example 2:

    //Input: [3,5,5]
    //Output: false
    //Example 3:

    //Input: [0,3,2,1]
    //Output: true
    @Test
    public void validMountainArray() {
        ValidMountainArray_941 validMountainArray = new ValidMountainArray_941();
        boolean test1 = validMountainArray.validMountainArray(new int[] {2, 1});
        Assert.assertEquals(test1,false);

        boolean test2 = validMountainArray.validMountainArray(new int[] {3, 5, 5});
        Assert.assertEquals(test2,false);

        boolean test3 = validMountainArray.validMountainArray(new int[] {0, 3, 2, 1});
        Assert.assertEquals(test3,true);
    }
}