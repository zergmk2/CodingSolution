/*
 * [77] Combinations
 *
 * https://leetcode.com/problems/combinations/description/
 *
 * algorithms
 * Medium (43.95%)
 * Total Accepted:    167.1K
 * Total Submissions: 380K
 * Testcase Example:  '4\n2'
 *
 * Given two integers n and k, return all possible combinations of k numbers
 * out of 1 ... n.
 * 
 * Example:
 * 
 * 
 * Input: n = 4, k = 2
 * Output:
 * [
 * ⁠ [2,4],
 * ⁠ [3,4],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ [1,3],
 * ⁠ [1,4],
 * ]
 * 
 * 
 */

 import java.util.*;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combineList = new ArrayList<>();
        if (n == 0 || k == 0 || k > n)
        {
            return combineList;
        }

        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
        {
            nums[i] = i + 1;
        }

        if (k == n)
        {
            List<Integer> list = new ArrayList<Integer>(n);
            for (int i = 0; i < n; i++)
            {
                list.add(i+1);
            }
            combineList.add(list);
            return combineList;
        }

        Backtracking(combineList, new ArrayList<Integer>(), nums, k, 0);

        return combineList;
    }

    private void Backtracking(List<List<Integer>> combineList, List<Integer> list, int[] nums, int length, int start)
    {
        if (length == 0)
        {
            combineList.add(new ArrayList<>(list));
        }
        else
        {
            for (int i = start; i < nums.length; i++)
            {
                list.add(nums[i]);
                Backtracking(combineList, list, nums, length - 1, i + 1);
                list.remove(list.size() - 1);
            }
        }

    }
}
