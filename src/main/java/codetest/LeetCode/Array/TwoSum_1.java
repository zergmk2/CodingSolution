package codetest.LeetCode.Array;
/*
 * [1] Two Sum
 *
 * https://leetcode.com/problems/two-sum/description/
 *
 * algorithms
 * Easy (38.77%)
 * Total Accepted:    1.2M
 * Total Submissions: 3.1M
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * Example:
 * 
 * 
 * Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * 
 * 
 * 
 * 
 */

import java.util.*;
public class TwoSum_1 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0)
        {
            return new int[0];
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
        {
            int left = target - nums[i];
            if (map.containsKey(nums[i]))
            {
                return new int[] {i, map.get(nums[i])};
            }
            else
            {
                map.put(left, i);
            }
        }

        return new int[0];
    }
}
