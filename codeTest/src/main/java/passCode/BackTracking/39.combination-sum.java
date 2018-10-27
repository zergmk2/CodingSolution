import java.util.*;

/*
 * [39] Combination Sum
 *
 * https://leetcode.com/problems/combination-sum/description/
 *
 * algorithms
 * Medium (43.69%)
 * Total Accepted:    263.8K
 * Total Submissions: 596.3K
 * Testcase Example:  '[2,3,6,7]\n7'
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a
 * target number (target), find all unique combinations in candidates where the
 * candidate numbers sums to target.
 * 
 * The same repeated number may be chosen from candidates unlimited number of
 * times.
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
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * ⁠ [7],
 * ⁠ [2,2,3]
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 * 
 * 
 */
class Solution {
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        List<List<Integer>> combinationList = new ArrayList<>();
//        Set<List<Integer>> combinationSet = new HashSet<>();
//        Arrays.sort(candidates);
//        if (candidates == null || candidates.length == 0)
//        {
//            return combinationList;
//        }
//
//        Backtracking(combinationSet, new ArrayList<Integer>(), candidates, target);
//        return new ArrayList<>(combinationSet);
//    }
//
//    private void Backtracking(Set<List<Integer>> combinationSet, ArrayList<Integer> integers, int[] candidates, int target) {
//
//        if (target == 0)
//        {
//            List<Integer> combination = new ArrayList<>(integers);
//            Collections.sort(combination);
//            combinationSet.add(combination);
//            return;
//        }
//
//        if (target < 0)
//        {
//            return;
//        }
//
//        for (int i = 0; i < candidates.length; i++)
//        {
//            integers.add(candidates[i]);
//            Backtracking(combinationSet, integers, candidates, target - candidates[i]);
//            integers.remove(integers.size() - 1);
//        }
//    }


    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        int[] candidates = {2,3,6,7};
        s.combinationSum(candidates, 7);
    }
}
