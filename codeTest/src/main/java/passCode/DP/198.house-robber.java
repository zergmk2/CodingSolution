/*
 * [198] House Robber
 *
 * https://leetcode.com/problems/house-robber/description/
 *
 * algorithms
 * Easy (40.39%)
 * Total Accepted:    247.8K
 * Total Submissions: 613.5K
 * Testcase Example:  '[1,2,3,1]'
 *
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping
 * you from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent
 * houses were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight
 * without alerting the police.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money =
 * 3).
 * Total amount you can rob = 1 + 3 = 4.
 * 
 * Example 2:
 * 
 * 
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house
 * 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 * 
 * 
 */
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
        {
            return 0;
        }

        if (nums.length == 1)
        {
            return nums[0];
        }

        if (nums.length == 2)
        {
            return Math.max(nums[0], nums[1]);
        }

        int[][] dp = new int[nums.length + 1][2];
        dp[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++)
        {
            dp[i][1] = dp[i-1][0] + nums[i];
            dp[i][0] = Math.max(dp[i-1][1], dp[i-1][0]);
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }
}
