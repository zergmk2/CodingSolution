/*
 * [438] Find All Anagrams in a String
 *
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 *
 * algorithms
 * Easy (34.74%)
 * Total Accepted:    89.3K
 * Total Submissions: 255.3K
 * Testcase Example:  '"cbaebabacd"\n"abc"'
 *
 * Given a string s and a non-empty string p, find all the start indices of p's
 * anagrams in s.
 * 
 * Strings consists of lowercase English letters only and the length of both
 * strings s and p will not be larger than 20,100.
 * 
 * The order of output does not matter.
 * 
 * Example 1:
 * 
 * Input:
 * s: "cbaebabacd" p: "abc"
 * 
 * Output:
 * [0, 6]
 * 
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of
 * "abc".
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * s: "abab" p: "ab"
 * 
 * Output:
 * [0, 1, 2]
 * 
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 * 
 * 
 */

 import java.util.*;
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || p == null || s.length() == 0 || p.length() == 0 || s.length() < p.length())
        {
            return list;
        }

        int m = s.length();
        int n = p.length();
        int end = m - n + 1;
        for (int i = 0; i < end; i++)
        {
            String substring = s.substring(i, i + n);
            if (isAnagrams(substring, p))
            {
                list.add(i);
            }
        }

        return list;
    }

    private boolean isAnagrams(String a, String b)
    {
        int[] charlist = new int[26];
        for (int i = 0; i < a.length(); i++)
        {
            charlist[a.charAt(i) - 'a']++;
            charlist[b.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++)
        {
            if (charlist[i] != 0)
            {
                return false;
            }
        }

        return true;
    }
}
