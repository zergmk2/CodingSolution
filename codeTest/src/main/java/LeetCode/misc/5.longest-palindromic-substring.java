package passCode;

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
class Solution {
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

//         System.out.println("maximumLength :" + maximumLength);
//         System.out.println("left :" + left);
//         System.out.println("right :" + right);
        if (maximumLength == 0)
            return s.substring(0, 1);
        else
            return s.substring(left, left + maximumLength);
    }

    public void findmaximumPalindrome(String s, int leftIndex, int rightIndex) {
        int cnt = 0;
        // System.out.println("=========================");
        // System.out.println("s :" + s);
        // System.out.println("leftIndex :" + leftIndex);
        // System.out.println("rightIndex :" + rightIndex);
        while (leftIndex >= 0 && rightIndex <= (s.length() - 1)) {
            if (s.charAt(leftIndex) == s.charAt(rightIndex)) {
                // System.out.println("s.charAt(leftIndex) :" + s.charAt(leftIndex));
                // System.out.println("s.charAt(rightIndex) :" + s.charAt(rightIndex));
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
        // System.out.println("cnt :" + cnt);
        leftIndex++;
        rightIndex--;
        int length = rightIndex - leftIndex + 1;
        if (cnt != 0 && maximumLength < length) {
            maximumLength = length;
            left = leftIndex;
            right = rightIndex;
        }

    }

//     public static void main(String[] args) throws IOException {

//             String ret = new passCode.Solution().longestPalindrome("aa");
//             System.out.println("answer :" + ret);
//     }
}


