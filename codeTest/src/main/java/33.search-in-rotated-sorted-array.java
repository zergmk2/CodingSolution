/*
 * [33] Search in Rotated Sorted Array
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (32.04%)
 * Total Accepted:    327.5K
 * Total Submissions: 1M
 * Testcase Example:  '[4,5,6,7,0,1,2]\n0'
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * 
 * 
 * Example 2:
 * 
 *  [12, 13, 14, 15, 16, 17, 0, 1, 2, 3, 4, 5, 6, 7 ,8, 9, 10, 11]
 * Input: nums = [4,5,6,7,0,1,2,3], target = 9
 * Output: -1
 * 
 */
class Solution {
    public int search(int[] nums, int target)
    {
        if (nums == null || nums.length == 0)
        {
            return 0;
        }
        return binaryHelper(nums, 0, nums.length - 1, target);
    }


    public int binaryHelper(int nums[], int l, int r, int target)
    {
        if (nums[0] < nums[nums.length - 1])
        {
            // no rotation
            return binarySearch(nums, 0, nums.length - 1, target);
        }
        else
        {
            int mid = nums.length / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[mid] > target) 
            {
                return search(nums, target);
            }
            else
            {
                return binarySearch(nums, 0, )
            }
        }
    }

    public int binarySearch(int nums[], int l, int r, int target)
    {
        int mid = l + (r - l) / 2;
        while (l <= r)
        {
            if (nums[mid] == target)
                return mid;
            System.out.println("left = " + l);
            System.out.println("right = " + r);
            if (nums[mid] > target)
            {
                r = mid - 1;
            }
            else
            {
                l = mid + 1;
            }
            mid = l + (r - l) / 2;
        }
        return -1;
    }
}
