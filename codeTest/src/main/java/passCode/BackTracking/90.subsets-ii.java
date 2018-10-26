import java.util.*;

/*
 * [90] Subsets II
 *
 * https://leetcode.com/problems/subsets-ii/description/
 *
 * algorithms
 * Medium (39.79%)
 * Total Accepted:    170.6K
 * Total Submissions: 425.8K
 * Testcase Example:  '[1,2,2]'
 *
 * Given a collection of integers that might contain duplicates, nums, return
 * all possible subsets (the power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * 
 * 
 * Input: [1,2,2]
 * Output:
 * [
 * ⁠ [2],
 * ⁠ [1],
 * ⁠ [1,2,2],
 * ⁠ [2,2],
 * ⁠ [1,2],
 * ⁠ []
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> subsetList = new HashSet<>();
        BackTracking(subsetList, new ArrayList<Integer>(), nums, 0);
        return new ArrayList<>(subsetList);
    }

    private void BackTracking(Set<List<Integer>> subsetList, ArrayList<Integer> list, int[] nums, int start) {
        List<Integer> newList = new ArrayList<>(list);
        Collections.sort(newList);
        subsetList.add(newList);
        for(int i = start; i < nums.length; i++)
        {
            list.add(nums[i]);
            BackTracking(subsetList, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
