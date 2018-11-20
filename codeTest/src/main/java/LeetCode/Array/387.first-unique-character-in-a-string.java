/*
 * [387] First Unique Character in a String
 *
 * https://leetcode.com/problems/first-unique-character-in-a-string/description/
 *
 * algorithms
 * Easy (47.88%)
 * Total Accepted:    188.1K
 * Total Submissions: 392.9K
 * Testcase Example:  '"leetcode"'
 *
 * 
 * Given a string, find the first non-repeating character in it and return it's
 * index. If it doesn't exist, return -1.
 * 
 * Examples:
 * 
 * s = "leetcode"
 * return 0.
 * 
 * s = "loveleetcode",
 * return 2.
 * 
 * 
 * 
 * 
 * Note: You may assume the string contain only lowercase letters.
 * 
 */
import java.util.*;

class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0)
        {
            return -1;
        }

        int[] indexMap = new int[27];
        boolean[] dupliced = new boolean[27];

        Arrays.fill(indexMap, Integer.MAX_VALUE);

        for (int i = 0; i < s.length(); i++)
        {
            if (indexMap[s.charAt(i) - 'a'] == Integer.MAX_VALUE)
            {
                indexMap[s.charAt(i) - 'a'] = i;
            }
            else
            {
                dupliced[s.charAt(i) - 'a'] = true;
            }
        }

        int firstIndex = Integer.MAX_VALUE;
        for (int i = 0; i < 27; i++)
        {
            if (!dupliced[i])
                firstIndex = Math.min(firstIndex, indexMap[i]);
        }
        if (firstIndex == Integer.MAX_VALUE)
            return -1;
        else
            return firstIndex;
    }
}
