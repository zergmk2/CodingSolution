package codetest.LeetCode.BackTracking;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Permutations2_47Test {

    @Test
    public void permuteUnique() {
        Permutations2_47 tester = new Permutations2_47();
        List<List<Integer>> ret =  tester.permuteUnique(new int[] {1,1,2});
        System.out.println(ret);
    }
}