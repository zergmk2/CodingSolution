/*
 * [581] Shortest Unsorted Continuous Subarray
 *
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/
 *
 * algorithms
 * Easy (29.26%)
 * Total Accepted:    49.1K
 * Total Submissions: 168.1K
 * Testcase Example:  '[2,6,4,8,10,9,15]'
 *
 * Given an integer array, you need to find one continuous subarray that if you
 * only sort this subarray in ascending order, then the whole array will be
 * sorted in ascending order, too.
 *
 * You need to find the shortest such subarray and output its length.
 *
 * Example 1:
 *
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make
 * the whole array sorted in ascending order.
 *
 *
 *
 * Note:
 *
 * Then length of the input array is in range [1, 10,000].
 * The input array may contain duplicates, so ascending order here means .
 *
 *
 */

package codetest.LeetCode.Array;
import java.util.*;

public class FindUnsortedSubarray_581 {
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length == 0)
        {
            return 0;
        }

        int[] nums_bk = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums_bk);

        int cnt = 0;
        int start = -1, end = -1;
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] != nums_bk[i])
            {
                if (start == -1)
                {
                    start = i;
                }
                else
                {
                    end = i;
                }
            }
        }

        if (start != -1 && end != -1)
            return end - start + 1;
        else
            return 0;
    }
}
