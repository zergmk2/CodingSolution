import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * [349] Intersection of Two Arrays
 *
 * https://leetcode.com/problems/intersection-of-two-arrays/description/
 *
 * algorithms
 * Easy (49.00%)
 * Total Accepted:    161.9K
 * Total Submissions: 323.4K
 * Testcase Example:  '[1,2,2,1]\n[2,2]'
 *
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example 1:
 * 
 * 
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * 
 * 
 * Note:
 * 
 * 
 * Each element in the result must be unique.
 * The result can be in any order.
 * 
 * 
 * 
 * 
 */
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null)
        {
            return null;
        }

        if (nums1.length == 0 || nums2.length == 0)
        {
            return new int[0];
        }

        Set<Integer> resultSet = new HashSet<>();
        Set<Integer> commonSet = new HashSet<>();
        for (int num: nums1) {
            commonSet.add(num);
        }

        for (int num: nums2) {
            if (commonSet.contains(num)) {
                resultSet.add(num);
            }
        }

        int size = resultSet.size();
        int[] retArray = new int[size];
        int i = 0;
        for(int num : resultSet)
        {
            retArray[i] = num;
            i++;
        }
        return retArray;
    }
}
