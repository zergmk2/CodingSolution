/*
 * [22] Generate Parentheses
 *
 * https://leetcode.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (50.79%)
 * Total Accepted:    264.4K
 * Total Submissions: 517K
 * Testcase Example:  '3'
 *
 * 
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * 
 * 
 * For example, given n = 3, a solution set is:
 * 
 * 
 * [
 * ⁠ "((()))",
 * ⁠ "(()())",
 * ⁠ "(())()",
 * ⁠ "()(())",
 * ⁠ "()()()"
 * ]
 * 
 */

package codetest.LeetCode.BackTracking;
import java.util.*;

public class GenerateParenthesis_22 {
    public List<String> generateParenthesis(int n) {
        Set<String> list = new HashSet<>();
        if (n == 0)
        {
            return new ArrayList<>();
        }

        Backtracking(list, new StringBuilder(), n);
        return new ArrayList(list);
    }

    private void Backtracking(Set<String> list, StringBuilder sb, int total)
    {
        int size = sb.length();
        for (int i = 0; i <= size; i++)
        {
            sb.insert(i, "()");
            if (total == 1)
            {
                list.add(sb.toString());
            }
            else if (total > 1)
            {
                Backtracking(list, sb, total - 1);
            }
            sb.delete(i, i + 2);
        }
    }
}
