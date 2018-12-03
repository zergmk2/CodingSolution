package codetest.LeetCode.Stack;/*
 * [20] Valid Parentheses
 *
 * https://leetcode.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (34.78%)
 * Total Accepted:    425.9K
 * Total Submissions: 1.2M
 * Testcase Example:  '"()"'
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * 
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * 
 * 
 * Note that an empty string is also considered valid.
 * 
 * Example 1:
 * 
 * 
 * Input: "()"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "()[]{}"
 * Output: true
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "(]"
 * Output: false
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: "([)]"
 * Output: false
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: "{[]}"
 * Output: true
 * 
 * 
 */
import java.util.*;

public class ValidParentheses_20 {
    public boolean isValid(String s) {
        if (s == null || (s.length() % 2) == 1)
        {
            return false;
        }

        if (s.length() == 0)
        {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '(')
                stack.push(')');
            else if (s.charAt(i) == '{')
                stack.push('}');
            else if (s.charAt(i) == '[')
                stack.push(']');
            else if (!stack.empty() && stack.peek() == s.charAt(i))
                stack.pop();
            else
                return false;
        }       
        return stack.isEmpty();
    }
}
