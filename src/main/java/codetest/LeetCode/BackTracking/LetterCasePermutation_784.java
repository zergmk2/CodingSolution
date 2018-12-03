package codetest.LeetCode.BackTracking;

import java.util.ArrayList;
import java.util.List;

/*
 * [800] Letter Case Permutation
 *
 * https://leetcode.com/problems/letter-case-permutation/description/
 *
 * algorithms
 * Easy (53.39%)
 * Total Accepted:    27.9K
 * Total Submissions: 52.1K
 * Testcase Example:  '"a1b2"'
 *
 * Given a string S, we can transform every letter individually to be lowercase
 * or uppercase to create another string.  Return a list of all possible
 * strings we could create.
 * 
 * 
 * Examples:
 * Input: S = "a1b2"
 * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 * 
 * Input: S = "3z4"
 * Output: ["3z4", "3Z4"]
 * 
 * Input: S = "12345"
 * Output: ["12345"]
 * 
 * 
 * Note:
 * 
 * 
 * S will be a string with length between 1 and 12.
 * S will consist only of letters or digits.
 * 
 * 
 */
public class LetterCasePermutation_784 {
    public List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList<>();
        Backtracking(list, new StringBuilder(S), S, 0);
        return list;
    }

    private void Backtracking(List<String> list, StringBuilder stringBuilder, String s, int start) {
        list.add(stringBuilder.toString());

        for (int i = start; i < s.length(); i++)
        {
            if (!Character.isDigit((stringBuilder.charAt(i))))
            {
                char oldChar = stringBuilder.charAt(i);
                char newChar;

                if (oldChar >= 'a')
                {
                   newChar = Character.toUpperCase(oldChar);
                }
                else
                {
                   newChar = Character.toLowerCase(oldChar);
                }

                stringBuilder.deleteCharAt(i);
                stringBuilder.insert(i, newChar);
                Backtracking(list, stringBuilder, s, i + 1);
                stringBuilder.deleteCharAt(i);
                stringBuilder.insert(i, oldChar);
            }
        }
    }
}
