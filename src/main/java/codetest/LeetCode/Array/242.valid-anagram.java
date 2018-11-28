/*
 * [242] Valid Anagram
 *
 * https://leetcode.com/problems/valid-anagram/description/
 *
 * algorithms
 * Easy (49.54%)
 * Total Accepted:    266.8K
 * Total Submissions: 538.4K
 * Testcase Example:  '"anagram"\n"nagaram"'
 *
 * Given two strings s and t , write a function to determine if t is an anagram
 * of s.
 * 
 * Example 1:
 * 
 * 
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "rat", t = "car"
 * Output: false
 * 
 * 
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * 
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your
 * solution to such case?
 * 
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() == 0 && t.length() == 0)
        {
            return true;
        }

        if (s.length() != t.length() || s.length() == 0 || t.length() == 0)
        {
            return false;
        }

        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++)
        {
            freq[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++)
        {
            freq[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++)
        {
            if (freq[i] != 0)
            {
                return false;
            }
        }

        return true;

    }
}
