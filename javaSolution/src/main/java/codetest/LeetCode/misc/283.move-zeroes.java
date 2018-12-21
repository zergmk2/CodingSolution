/*
 * [283] Move Zeroes
 *
 * https://leetcode.com/problems/move-zeroes/description/
 *
 * algorithms
 * Easy (52.17%)
 * Total Accepted:    352.4K
 * Total Submissions: 672.1K
 * Testcase Example:  '[0,1,0,3,12]'
 *
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * 
 * Example:
 * 
 * 
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * 
 * Note:
 * 
 * 
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * 
 * 
 */
class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0)
        {
            return;
        }
        int index = 0;

        for (int num: nums) {
            if (num != 0)
            {
                nums[index] = num;
                index++;
            }
        }

        for (int i = index; i < nums.length; i++)
        {
            nums[i] = 0;
        }
    }
}
