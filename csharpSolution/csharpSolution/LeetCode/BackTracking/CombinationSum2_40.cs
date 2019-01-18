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
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace csharpSolution.LeetCode.BackTracking
{
    public class CombinationSum2_40
    {
        public IList<IList<int>> CombinationSum2(int[] candidates, int target)
        {
            if (candidates == null || candidates.Length == 0 || target == 0)
            {
                return null;
            }

            Dictionary<string, IList<int>> results = new Dictionary<string, IList<int>>();
            List<int> sum = new List<int>();
            Array.Sort(candidates);
            BackTrack(candidates,  results, sum, target, 0);
            return results.Values.ToList();
        }

        private void BackTrack(int[] candidates, Dictionary<string, IList<int>> results, List<int> sum, int target, int startNum)
        {
            if (target < 0)
                return;

            if (target == 0)
            {
                List<int> result = new List<int>(sum);
                result.Sort();
                var key = string.Join("",result);
                if (!results.ContainsKey(key))
                    results.Add(key, result);
                return;
            }

            for (int i = startNum; i < candidates.Length; i++)
            {
                if (i > startNum && candidates[i] == candidates[i - 1])
                {
                    continue;
                }
                sum.Add(candidates[i]);
                BackTrack(candidates, results, sum, target - candidates[i], i + 1);
                sum.RemoveAt(sum.Count - 1);
            }
        }
    }
}
