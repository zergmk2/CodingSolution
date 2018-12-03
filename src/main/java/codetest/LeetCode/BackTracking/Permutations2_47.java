package codetest.LeetCode.BackTracking;/*
 * [47] Permutations II
 *
 * https://leetcode.com/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (37.35%)
 * Total Accepted:    196K
 * Total Submissions: 524.4K
 * Testcase Example:  '[1,1,2]'
 *
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 * 
 * Example:
 * 
 * 
 * Input: [1,1,2]
 * Output:
 * [
 * ⁠ [1,1,2],
 * ⁠ [1,2,1],
 * ⁠ [2,1,1]
 * ]
 * 
 * 
 */
import java.util.*;
public class Permutations2_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> permuteList = new ArrayList<>();
        Set<List<Integer>> permuteSet = new HashSet<>();
        if (nums == null || nums.length == 0)
        {
            return permuteList;
        }

        if (nums.length == 1)
        {
            List<Integer> list = new ArrayList<Integer>();
            list.add(nums[0]);
            permuteList.add(list);
            return permuteList;
        }
        Arrays.sort(nums);
        Backtracking(permuteList, new ArrayList<Integer>(), nums, new boolean[nums.length]);
        return permuteList;
    }

    private void Backtracking(List<List<Integer>> permuteSet, List<Integer> list, int[] nums, boolean[] visited)
    {
        if (list.size() == nums.length)
        {
            permuteSet.add(new ArrayList<>(list));
        }
        else
        {
            for (int i = 0; i < nums.length; i++)
            {
                if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i-1]))
                {
                    continue;
                }
                list.add(nums[i]);
                visited[i] = true;
                Backtracking(permuteSet, list, nums, visited);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
