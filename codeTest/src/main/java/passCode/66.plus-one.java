/*
 * [66] Plus One
 *
 * https://leetcode.com/problems/plus-one/description/
 *
 * algorithms
 * Easy (39.96%)
 * Total Accepted:    295.9K
 * Total Submissions: 740K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a non-empty array of digits representing a non-negative integer, plus
 * one to the integer.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list, and each element in the array contain a single digit.
 * 
 * You may assume the integer does not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * 
 * 
 */
class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0)
        {
            return new int[0];
        }

        int carry = 1;
        int sum = 0;
        for (int i = digits.length - 1; i >= 0; i--)
        {
            sum = (digits[i] + carry) % 10;
            carry = (digits[i] + carry) / 10;
            digits[i] = sum;
        }

        if (carry == 0)
        {
            return digits;
        }
        else
        {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = carry;
            for (int i = 1; i < newDigits.length; i++)
            {
                newDigits[i] = digits[i - 1];
            }
            return newDigits;
        }
    }
}
