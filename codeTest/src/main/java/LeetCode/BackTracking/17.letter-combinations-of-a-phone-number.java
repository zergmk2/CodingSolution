/*
 * [17] Letter Combinations of a Phone Number
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (37.79%)
 * Total Accepted:    302.5K
 * Total Submissions: 778.9K
 * Testcase Example:  '"23"'
 *
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * Note:
 * 
 * Although the above answer is in lexicographical order, your answer could be
 * in any order you want.
 * 
 */

import java.util.*;
class Solution {
    private char[][] charSet = {
        {}, // 0
        {}, // 1
        {'a', 'b', 'c'}, // 2
        {'d', 'e', 'f'}, // 3
        {'g', 'h', 'i'}, // 4
        {'j', 'k', 'l'}, // 5
        {'m', 'n', 'o'}, // 6
        {'p', 'q', 'r', 's'}, // 7
        {'t', 'u', 'v'}, // 8
        {'w', 'x', 'y', 'z'}, // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits == null || digits.length() == 0)
        {
            return list;
        }

        BackTracking(list, new StringBuilder(), digits, 0);
        return list;
    }

    private void BackTracking(List<String> list, StringBuilder sb, String digits, int target)
    {
        if (sb.length() == digits.length())
        {
            list.add(sb.toString());
            return;
        }

        int number = digits.charAt(target) - '0';
        //System.out.print("[ " + number);
        for(int j = 0; j < charSet[number].length; j++)
        {
            //System.out.print("( " + charSet[number][j]);
            sb.append(charSet[number][j]);
            BackTracking(list, sb, digits, target + 1);
            sb.deleteCharAt(sb.length() - 1);
            //System.out.print(" )");
        }
        //System.out.println(" ]");
    }

}
