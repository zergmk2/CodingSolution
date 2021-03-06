/*
 * [448] Find All Numbers Disappeared in an Array
 *
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
 *
 * algorithms
 * Easy (51.58%)
 * Total Accepted:    117.3K
 * Total Submissions: 227K
 * Testcase Example:  '[4,3,2,7,8,2,3,1]'
 *
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some
 * elements appear twice and others appear once.
 * 
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * 
 * Could you do it without extra space and in O(n) runtime? You may assume the
 * returned list does not count as extra space.
 * 
 * Example:
 * 
 * Input:
 * [4,3,2,7,8,2,3,1]
 * 
 * Output:
 * [5,6]
 * 
 * 
 */

package codetest.LeetCode.Array;
import java.util.*;

public class FindDisappearedNumbers_448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();       
        for (int i = 0; i < nums.length; i++)
        {
            int index = Math.abs(nums[i]) - 1;

            if (nums[index] > 0)
            {
                nums[index] -= 2 * nums[index];
            }
        }

        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] > 0)
            {
                list.add(i + 1);
            }
        }

        return list;
    }
}