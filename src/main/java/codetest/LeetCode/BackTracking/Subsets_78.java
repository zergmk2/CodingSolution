package codetest.LeetCode.BackTracking;

import java.util.ArrayList;
import java.util.List;

/*
 * [78] Subsets
 *
 * https://leetcode.com/problems/subsets/description/
 *
 * algorithms
 * Medium (47.76%)
 * Total Accepted:    287.4K
 * Total Submissions: 594.5K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a set of distinct integers, nums, return all possible subsets (the
 * power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * 
 * 
 * Input: nums = [1,2,3]
 * Output:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * 
 */
public class Subsets_78 {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> subsetList = new ArrayList<>();
            BackTracking(subsetList, new ArrayList<Integer>(), nums, 0);
            return subsetList;
        }

        private void BackTracking(List<List<Integer>> subsetList, List<Integer> list, int[] nums, int start)
        {
            subsetList.add(new ArrayList<>(list));
            for (int i = start; i < nums.length; i++)
            {
                list.add(nums[i]);
                BackTracking(subsetList, list, nums, i+1);
                list.remove(list.size() - 1);
            }
        }
}
