/*
 * [216] Combination Sum III
 *
 * https://leetcode.com/problems/combination-sum-iii/description/
 *
 * algorithms
 * Medium (49.04%)
 * Total Accepted:    103K
 * Total Submissions: 209.8K
 * Testcase Example:  '3\n7'
 *
 * 
 * Find all possible combinations of k numbers that add up to a number n, given
 * that only numbers from 1 to 9 can be used and each combination should be a
 * unique set of numbers.
 * 
 * Note:
 * 
 * 
 * All numbers will be positive integers.
 * The solution set must not contain duplicate combinations.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: k = 3, n = 9
 * Output: [[1,2,6], [1,3,5], [2,3,4]]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] candidates = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<List<Integer>> combinationList = new ArrayList<>();
        if (k == 0 || n == 0)
        {
            return combinationList;
        }

        Backtracking(combinationList, new ArrayList<Integer>(), candidates, n, k, 0);
        return combinationList;
    }

    private void Backtracking(List<List<Integer>> combinationList, List<Integer> list, int[] candidates, int target, int length, int start)
    {
        if (target < 0 || length < 0)
        {
            return;
        }
        else if (target == 0 && length == 0)
        {
            combinationList.add(new ArrayList<>(list));
        }
        else
        {
            for (int i = start; i < candidates.length; i++)
            {
                list.add(candidates[i]);
                Backtracking(combinationList, list, candidates, target - candidates[i], length - 1, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
