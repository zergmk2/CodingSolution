package codetest.LeetCode.Array;/*
 * [119] Pascal's Triangle II
 *
 * https://leetcode.com/problems/pascals-triangle-ii/description/
 *
 * algorithms
 * Easy (40.51%)
 * Total Accepted:    169K
 * Total Submissions: 416.8K
 * Testcase Example:  '3'
 *
 * Given a non-negative index k where k ≤ 33, return the kth index row of the
 * Pascal's triangle.
 * 
 * Note that the row index starts from 0.
 * 
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it.
 * 
 * Example:
 * 
 * 
 * Input: 3
 * Output: [1,3,3,1]
 * 
 * 
 * Follow up:
 * 
 * Could you optimize your algorithm to use only O(k) extra space?
 * 
 */

import java.util.*;

public class PascalsTriangle2_119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ret = new ArrayList<>(rowIndex + 1);
        if (rowIndex == 0)
        {
            ret.add(1);
            return ret;
        }
        else if (rowIndex == 1)
        {
            ret.add(1);
            ret.add(1);
            return ret;
        }

        int[][] triangle = new int[rowIndex + 1][ rowIndex + 1];
        triangle[0][0] = 1;
        triangle[1][0] = triangle[1][1] = 1;
        for (int i = 2; i < rowIndex; i++)
        {
            for (int j = 0; j <= i; j++)
            {
                if (j == 0 || j == i)
                {
                    triangle[i][j] = 1;
                }
                else
                {
                    triangle[i][j] = triangle[i - 1][j - 1] +  triangle[i - 1][j];
                }
            }
        }

        for (int j = 0; j <= rowIndex; j++)
        {
            if (j == 0 || j == rowIndex + 1)
            {
                ret.add(1);
            }
            else
            {
                ret.add(triangle[rowIndex - 1][j-1] +  triangle[rowIndex - 1][j]);
            }
        }

        return ret;
    }
}
