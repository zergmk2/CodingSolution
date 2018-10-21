/*
 * [53] Maximum Subarray
 *
 * https://leetcode.com/problems/maximum-subarray/description/
 *
 * algorithms
 * Easy (41.25%)
 * Total Accepted:    386.1K
 * Total Submissions: 930.8K
 * Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
 *
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum.
 * 
 * Example:
 * 
 * 
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * 
 * 
 * Follow up:
 * 
 * If you have figured out the O(n) solution, try coding another solution using
 * the divide and conquer approach, which is more subtle.
 * 
 */
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
        {
            return 0;
        }

        if (nums.length == 1)
        {
            return nums[0];
        }

        int max_sofar = Integer.MIN_VALUE;
        int max_end_now = 0;

        for (int i = 0; i < nums.length; i++)
        {
            max_end_now += nums[i];
            max_sofar = Math.max(max_sofar, max_end_now);
            if (max_end_now < 0)
            {
                max_end_now = 0;
            }
        }
        return max_sofar;
    }
}
