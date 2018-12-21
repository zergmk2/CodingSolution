package codetest.LeetCode.BackTracking;

import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import static org.junit.Assert.*;

public class Permutations2_47Test {

    @Test
    public void permuteUnique() {
        Permutations2_47 tester = new Permutations2_47();
        List<List<Integer>> ret =  tester.permuteUnique(new int[] {1,1,2});
        System.out.println(ret);

        PriorityQueue<Integer> queue = new PriorityQueue<>(10);
        queue.add(5);
        queue.add(1);
        queue.add(2);
        queue.add(6);
        Integer val = null;
        while( (val = queue.poll()) != null) {
            System.out.println(val);
        }

    }
}