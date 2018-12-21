import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * [5] Longest Palindromic Substring
 *
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (25.64%)
 * Total Accepted:    355K
 * Total Submissions: 1.4M
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
public class LongestPalindrome_5 {
    private int maximumLength = 0;
    private int left = 0, right = 0;

    
    public String longestPalindrome(String s) {
        System.out.println("input :" + s);
        if (s == null || s.length() == 0) {
            return "";
        }

        if (s.length() == 1)
        {
            return s;
        }
        
        if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1))
            {
                return s;
            }
            return s.substring(0,1);
        }


        for (int i = 0; i < s.length(); i++) {
            findmaximumPalindrome(s, i, i);
            findmaximumPalindrome(s, i, i + 1);
        }
        if (maximumLength == 0)
            return s.substring(0, 1);
        else
            return s.substring(left, left + maximumLength);
    }

    public void findmaximumPalindrome(String s, int leftIndex, int rightIndex) {
        int cnt = 0;
        while (leftIndex >= 0 && rightIndex <= (s.length() - 1)) {
            if (s.charAt(leftIndex) == s.charAt(rightIndex)) {
                if (leftIndex != rightIndex)
                {
                    cnt++;
                }
                leftIndex--;
                rightIndex++;
            } else {
                break;
            }
        }
        leftIndex++;
        rightIndex--;
        int length = rightIndex - leftIndex + 1;
        if (cnt != 0 && maximumLength < length) {
            maximumLength = length;
            left = leftIndex;
            right = rightIndex;
        }

    }
}


