package codetest.LeetCode.greedyMethod;/*
 * [659] Split Array into Consecutive Subsequences
 *
 * https://leetcode.com/problems/split-array-into-consecutive-subsequences/description/
 *
 * algorithms
 * Medium (38.07%)
 * Total Accepted:    14.1K
 * Total Submissions: 37K
 * Testcase Example:  '[1,2,3,3,4,5]'
 *
 * You are given an integer array sorted in ascending order (may contain
 * duplicates), you need to split them into several subsequences, where each
 * subsequences consist of at least 3 consecutive integers. Return whether you
 * can make such a split.
 * 
 * Example 1:
 * 
 * Input: [1,2,3,3,4,5]
 * Output: True
 * Explanation:
 * You can split them into two consecutive subsequences : 
 * 1, 2, 3
 * 3, 4, 5
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: [1,2,3,3,4,4,5,5]
 * Output: True
 * Explanation:
 * You can split them into Two consecutive subsequences : 
 * 1, 2, 3, 4, 5
 * 3, 4, 5
 * 
 * 
 * 
 * Example 3:
 * 
 * Input: [1,2,3,4,4,5]
 * Output: False
 * 
 * 
 * 
 * Note:
 * 
 * The length of the input is in range of [1, 10000]
 * 
 * 
 */

import java.util.*;
public class CanSplitConsecutiveSubset_659 {
    public boolean isPossible(int[] nums) {
        if (nums == null || nums.length < 3)
        {
            return false;
        }
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> need = new HashMap<>();
        for (int num : nums)
        {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int num : nums)
        {
            if (freq.getOrDefault(num, 0) == 0)
                continue;

            int nextCnt = need.getOrDefault(num + 1, 0);
            int curCnt = need.getOrDefault(num, 0);

            if (curCnt > 0)
            {
                need.put(num, curCnt - 1);
                need.put(num + 1, nextCnt + 1);
            }
            else if (freq.getOrDefault(num + 1, 0) > 0 && freq.getOrDefault(num + 2, 0) > 0)
            {
                freq.put(num + 1, freq.getOrDefault(num + 1, 0) - 1);
                freq.put(num + 2, freq.getOrDefault(num + 2, 0) - 1);
                need.put(num + 3, need.getOrDefault(num + 3, 0) + 1);
            }
            else
            {
                return false;
            }
            freq.put(num, freq.getOrDefault(num, 0) - 1);
        }

        return true;
    }
}
