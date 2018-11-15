/*
 * [782] Jewels and Stones
 *
 * https://leetcode.com/problems/jewels-and-stones/description/
 *
 * algorithms
 * Easy (81.64%)
 * Total Accepted:    128.9K
 * Total Submissions: 157.7K
 * Testcase Example:  '"aA"\n"aAAbbbb"'
 *
 * You're given strings J representing the types of stones that are jewels, and
 * S representing the stones you have.  Each character in S is a type of stone
 * you have.  You want to know how many of the stones you have are also
 * jewels.
 * 
 * The letters in J are guaranteed distinct, and all characters in J and S are
 * letters. Letters are case sensitive, so "a" is considered a different type
 * of stone from "A".
 * 
 * Example 1:
 * 
 * 
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: J = "z", S = "ZZ"
 * Output: 0
 * 
 * 
 * Note:
 * 
 * 
 * S and J will consist of letters and have length at most 50.
 * The characters in J are distinct.
 * 
 * 
 */
class Solution {
    public int numJewelsInStones(String J, String S) {
        if (J == null || J.length() == 0 || S == null || S.length() == 0)
        {
            return 0;
        }

        int[] jewels = new int[60];
        
        for (int i = 0; i < J.length(); i++)
        {
            jewels[J.charAt(i) - 'A']++;
        }

        int cnt = 0;
        for (int i = 0; i < S.length(); i++)
        {
            if (jewels[S.charAt(i) - 'A'] > 0)
            {
                cnt++;
            }
        }
        return cnt;
    }
}
