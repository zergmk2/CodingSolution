/*
 * [46] Permutations
 *
 * https://leetcode.com/problems/permutations/description/
 *
 * algorithms
 * Medium (50.77%)
 * Total Accepted:    292.8K
 * Total Submissions: 576.2K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a collection of distinct integers, return all possible permutations.
 * 
 * Example:
 * 
 * 
 * Input: [1,2,3]
 * Output:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> permute(int[] nums)
    {
        List<List<Integer>> permuteList = new ArrayList<>();
        if (nums == null || nums.length == 0)
        {
            List<Integer> list = new ArrayList<>();
            permuteList.add(list);
            return permuteList;
        }

        if (nums.length == 1)
        {
            List<Integer> list = new ArrayList<>(1);
            list.add(nums[0]);
            permuteList.add(list);
            return permuteList;
        }

        Backtracking(permuteList, new ArrayList<Integer>(), nums);
        return permuteList;
    }

    private void Backtracking(List<List<Integer>> permuteList, List<Integer> list, int[] nums)
    {
        if (list.size() == nums.length)
        {
            permuteList.add(new ArrayList<>(list));
        }
        else
        {
            for (int i = 0; i < nums.length; i++)
            {
                if (list.contains(nums[i]))
                    continue;
                list.add(nums[i]);
                Backtracking(permuteList, list, nums);
                list.remove(list.size() - 1);
            }
        }
    }
}
