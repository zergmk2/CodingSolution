package codetest.LeetCode.BackTracking;
/*
 * [40] Combination Sum II
 *
 * https://leetcode.com/problems/combination-sum-ii/description/
 *
 * algorithms
 * Medium (38.29%)
 * Total Accepted:    179.1K
 * Total Submissions: 467.3K
 * Testcase Example:  '[10,1,2,7,6,1,5]\n8'
 *
 * Given a collection of candidate numbers (candidates) and a target number
 * (target), find all unique combinations in candidates where the candidate
 * numbers sums to target.
 * 
 * Each number in candidates may only be used once in the combination.
 * 
 * Note:
 * 
 * 
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 * ⁠ [1, 7],
 * ⁠ [1, 2, 5],
 * ⁠ [2, 6],
 * ⁠ [1, 1, 6]
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 * [1,2,2],
 * [5]
 * ]
 * 
 * 
 */
import java.util.*;
public class combinationSum2_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combinationList = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
        {
            return combinationList;
        }        
        Arrays.sort(candidates);
        Backtracking(combinationList, new ArrayList<Integer>(), candidates, target, 0);
        return combinationList;
    }

    private void Backtracking(List<List<Integer>> combinationList, List<Integer> list, int[] candidates, int target, int start)
    {
        if (target < 0)
        {
            return;
        }
        else if (target == 0)
        {
            combinationList.add(new ArrayList<>(list));
        }
        else
        {
            for (int i = start; i < candidates.length; i++)
            {
                if (i > start && candidates[i] == candidates[i - 1])
                {
                    continue;
                }
                list.add(candidates[i]);
                Backtracking(combinationList, list, candidates, target - candidates[i], i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
