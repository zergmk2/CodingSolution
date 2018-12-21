/*
 * [14] Longest Common Prefix
 *
 * https://leetcode.com/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (31.95%)
 * Total Accepted:    327.3K
 * Total Submissions: 1M
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * Write a function to find the longest common prefix string amongst an array
 * of strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * Example 1:
 * 
 * 
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * 
 * 
 * Note:
 * 
 * All given inputs are in lowercase letters a-z.
 * 
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
        {
            return "";
        }

        if (strs.length == 1)
        {
            return strs[0];
        }

        String longestPrefix = getCommonPrefix(strs[0], strs[1]);

        for (int i = 2; i < strs.length; i++)
        {
            if (longestPrefix.length() == 0)
            {
                return "";
            }
            longestPrefix = getCommonPrefix(longestPrefix, strs[i]);
        }
        return longestPrefix;
    }

    private String getCommonPrefix(String s1, String s2)
    {
        if (s1 == null || s2 == null)
        {
            return "";
        }

        if (s1.length() == 0 || s1.length() == 0)
        {
            return "";
        }

        int length = Math.min(s1.length(), s2.length());
        StringBuffer prefix = new StringBuffer(length);
        for(int i = 0; i < length; i++)
        {
            if (s1.charAt(i) == s2.charAt(i))
            {
                prefix.append(s1.charAt(i));
            }
            else
            {
                break;
            }
        }
        return prefix.toString();
    }

    public static void main(String[] args)
    {


    }
}
