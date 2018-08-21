import java.util.Arrays;

/*
 * [167] Two Sum II - Input array is sorted
 *
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 *
 * algorithms
 * Easy (47.46%)
 * Total Accepted:    161.7K
 * Total Submissions: 340.5K
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * Given an array of integers that is already sorted in ascending order, find
 * two numbers such that they add up to a specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2.
 * 
 * Note:
 * 
 * 
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may
 * not use the same element twice.
 * 
 * 
 * Example:
 * 
 * 
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 * 
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length == 0)
        {
            return new int[] {0, 0};
        }

//        Arrays.sort(numbers);

        int l = 0;
        int r = numbers.length - 1;

        while (l < r)
        {
            if ((numbers[l] + numbers[r]) < target)
            {
                l++;
            }
            else if ((numbers[l] + numbers[r]) > target)
            {
                r--;
            }
            else if ((numbers[l] + numbers[r]) == target)
            {
                return new int[] {l+1, r+1};
            }
        }
        return new int[] {0, 0};
    }
}
