import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * [217] Contains Duplicate
 *
 * https://leetcode.com/problems/contains-duplicate/description/
 *
 * algorithms
 * Easy (48.83%)
 * Total Accepted:    257.1K
 * Total Submissions: 525.2K
 * Testcase Example:  '[1,2,3,1]'
 *
 * Given an array of integers, find if the array contains any duplicates.
 * 
 * Your function should return true if any value appears at least twice in the
 * array, and it should return false if every element is distinct.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,3,1]
 * Output: true
 * 
 * Example 2:
 * 
 * 
 * Input: [1,2,3,4]
 * Output: false
 * 
 * Example 3:
 * 
 * 
 * Input: [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {

        if (nums == null || nums.length == 0)
        {
            return false;
        }

        if (nums.length == 1)
            return false;

        Set<Integer> set = new HashSet<>();

        for (int num: nums) {
            if (!set.add(num))
                return true;
        }

        return false;
    }
}
