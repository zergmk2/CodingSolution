/*
 * [169] Majority Element
 *
 * https://leetcode.com/problems/majority-element/description/
 *
 * algorithms
 * Easy (49.87%)
 * Total Accepted:    307.7K
 * Total Submissions: 617K
 * Testcase Example:  '[3,2,3]'
 *
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,2,3]
 * Output: 3
 * 
 * Example 2:
 * 
 * 
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 * 
 * 
 */

package codetest.LeetCode.Array;
import java.util.*;
public class MajorityElement_169 {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0)
        {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
        {
            if (map.containsKey(nums[i]))
            {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            else
            {
                map.put(nums[i], 1);
            }
        }

        int maxValue = 0;
        int index = 0;
        for(int key : map.keySet())
        {
            if (map.get(key) > maxValue)
            {
                index = key;
                maxValue = map.get(key);
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            entry.getKey();
            entry.getValue();
        }
        return index;
    }
}
