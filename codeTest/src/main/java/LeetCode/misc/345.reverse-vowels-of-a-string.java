/*
 * [345] Reverse Vowels of a String
 *
 * https://leetcode.com/problems/reverse-vowels-of-a-string/description/
 *
 * algorithms
 * Easy (39.75%)
 * Total Accepted:    120K
 * Total Submissions: 301.9K
 * Testcase Example:  '"hello"'
 *
 * Write a function that takes a string as input and reverse only the vowels of
 * a string.
 * 
 * Example 1:
 * 
 * 
 * Input: "hello"
 * Output: "holle"
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "leetcode"
 * Output: "leotcede"
 * 
 * 
 * Note:
 * The vowels does not include the letter "y".
 * 
 * 
 * 
 */
class Solution {
    private boolean isVowel(char c)
    {
        if ((c == 'a') || (c == 'i') || (c == 'e') || (c == 'o') || (c == 'u') ||
        (c == 'A') || (c == 'I') || (c == 'E') || (c == 'O') || (c == 'U'))
        {
            return true;
        }
        return false;
    }
    public String reverseVowels(String s) {
        if (s.length() == 0 || s.length() == 1)
        {
            return s;
        }

        int l = 0;
        int r = s.length() - 1;
        StringBuilder builder = new StringBuilder(s);
        while (l <= r)
        {
//            if (l==r)
//            {
//                builder.insert(l+1, s.charAt(l));
//            }

            if (!isVowel(s.charAt(l)))
            {
                l++;
            }

            if (!isVowel(s.charAt(r)))
            {
                r--;
            }

            if (isVowel(s.charAt(l)) && isVowel(s.charAt(r)))
            {
                builder.setCharAt(l, s.charAt(r));
                builder.setCharAt(r, s.charAt(l));
                l++;
                r--;
            }
        }
        return builder.toString();
    }
}
