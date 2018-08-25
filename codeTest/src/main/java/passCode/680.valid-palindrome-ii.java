/*
 * [680] Valid Palindrome II
 *
 * https://leetcode.com/problems/valid-palindrome-ii/description/
 *
 * algorithms
 * Easy (32.40%)
 * Total Accepted:    39.2K
 * Total Submissions: 120.8K
 * Testcase Example:  '"aba"'
 *
 * 
 * Given a non-empty string s, you may delete at most one character.  Judge
 * whether you can make it a palindrome.
 * 
 * 
 * Example 1:
 * 
 * Input: "aba"
 * Output: True
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * 
 * 
 * 
 * Note:
 * 
 * The string will only contain lowercase characters a-z.
 * The maximum length of the string is 50000.
 * 
 * 
 */
class Solution {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0)
        {
            return false;
        }

        int l = 0;
        int r = s.length() - 1;
        int cnt = 0;
        while(l < r)
        {
            if (s.charAt(l) == s.charAt(r))
            {
                l++;
                r--;
            }
            else
            {
                return isPalindrome(s.substring(l + 1, r + 1)) || isPalindrome(s.substring(l, r));
            }
        }
        return true;
    }

    private boolean isPalindrome(String s)
    {
        int l = 0;
        int r = s.length() - 1;
        while (l < r)
        {
            if (s.charAt(l) != s.charAt(r))
            {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        String text = "ebcbbececabbacecbbcbe";
        String tmp = text.substring(0,5);
        s.validPalindrome(text);
    }
}
