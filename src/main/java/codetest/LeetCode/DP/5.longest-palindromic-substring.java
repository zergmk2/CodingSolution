/*
 * [5] Longest Palindromic Substring
 *
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (25.63%)
 * Total Accepted:    403K
 * Total Submissions: 1.6M
 * Testcase Example:  '"babad"'
 *
 * Given a string s, find the longest palindromic substring in s. You may
 * assume that the maximum length of s is 1000.
 * 
 * Example 1:
 * 
 * 
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "cbbd"
 * Output: "bb"
 * 
 * 
 */
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
        {
            return "";
        }

        int left = 0, right = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int lenthSofar = 0;
        for (int i = n - 1; i >= 0; i--)
        {
            for (int j = i; j < n; j++)
            {
                if (s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i+1][j-1]))
                {
                    dp[i][j] = true;

                    if ((j - i  + 1) > lenthSofar)
                    {
                        left = i; right = j;
                        lenthSofar = j - i + 1;
                    }
                }               
            }
        }

        return s.substring(left, right + 1);
    }
}
