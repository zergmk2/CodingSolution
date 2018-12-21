package codetest.LeetCode.Array;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TwoSum_1Test {

    @Test
    public void twoSum() {
        TwoSum_1 twoSum1 = new TwoSum_1();
        int[] expect = {1, 0};
        int[] actual = twoSum1.twoSum(new int[] {2,7,11,15}, 9);
        Assert.assertArrayEquals(expect, actual);
    }
}