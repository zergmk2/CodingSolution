package codetest.LeetCode.DP;/*
 * [120] Triangle
 *
 * https://leetcode.com/problems/triangle/description/
 *
 * algorithms
 * Medium (36.86%)
 * Total Accepted:    155.1K
 * Total Submissions: 418.9K
 * Testcase Example:  '[[2],[3,4],[6,5,7],[4,1,8,3]]'
 *
 * Given a triangle, find the minimum path sum from top to bottom. Each step
 * you may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle
 * 
 * 
 * [
 * ⁠    [2],
 * ⁠   [3,4],
 * ⁠  [6,5,7],
 * ⁠ [4,1,8,3]
 * ]
 * 
 * 
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * Note:
 * 
 * Bonus point if you are able to do this using only O(n) extra space, where n
 * is the total number of rows in the triangle.
 * 
 */
import java.util.*;

public class MinimumTotalOfTriangle_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0)
        {
            return 0;
        }

        int n = triangle.size();
        int[][] dp = new int[n][n];

        dp[0][0] = triangle.get(0).get(0);
        int level = triangle.size();
        for (int i = 1; i < level; i++)
        {
            List<Integer> list = triangle.get(i);
            int size = list.size();
            for (int j = 0; j < size; j++)
            {
                if (j == 0)
                {
                    dp[i][j] = dp[i-1][0] + list.get(j);
                }
                else if (j == size -1 )
                {
                    dp[i][j] = dp[i-1][j-1] + list.get(j);
                }
                else
                {
                    dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + list.get(j);
                }
            }
        }

        int sum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++)
        {
            sum = Math.min(dp[n-1][i], sum);            
        }
        return sum;
    }
}