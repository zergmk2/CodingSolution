/*
 * [91] Decode Ways
 *
 * https://leetcode.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (21.12%)
 * Total Accepted:    210.4K
 * Total Submissions: 993.7K
 * Testcase Example:  '"12"'
 *
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * 
 * Given a non-empty string containing only digits, determine the total number
 * of ways to decode it.
 * 
 * Example 1:
 * 
 * 
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2
 * 6).
 * 
 */
import java.util.*;

class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
        {
            return 0;
        }

        int[] memory = new int[s.length() + 1];

        Arrays.fill(memory, 0);
        memory[0] = 1;

        if (s.charAt(0) - '0' > 0)
            memory[1] = 1;
        else
            memory[1] = 0;

        for (int i = 2; i <= s.length(); i++)
        {
            int singleNumber = Integer.parseInt(s.substring(i - 1, i));
            int doubleNumber = Integer.parseInt(s.substring(i - 2, i));
            if (singleNumber > 0 && singleNumber <= 9)
            {
                memory[i] += memory[i-1];
            }

            if (doubleNumber >= 10 && doubleNumber <= 26)
            {
                memory[i] += memory[i-2];
            }
        }

        return memory[s.length()];
    }
}
