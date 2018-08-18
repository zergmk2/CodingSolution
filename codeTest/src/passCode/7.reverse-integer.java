import javafx.util.converter.IntegerStringConverter;

import java.util.ArrayList;

/*
 * [7] Reverse Integer
 *
 * https://leetcode.com/problems/reverse-integer/description/
 *
 * algorithms
 * Easy (24.39%)
 * Total Accepted:    456.5K
 * Total Submissions: 1.9M
 * Testcase Example:  '123'
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 * 
 * Example 1:
 * 
 * 
 * Input: 123
 * Output: 321
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: -123
 * Output: -321
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: 120
 * Output: 21
 * 
 * 
 * Note:
 * Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of
 * this problem, assume that your function returns 0 when the reversed integer
 * overflows.
 * 
 */
class Solution {
    private int[] validRange = {-231, 230};
    public int reverse1(int x) {
        String number = Integer.toString(x);

        // out of the integer range
//        if( ( x < 0 && number.length() > 4 ) ||
//                (x > 0 && number.length() > 3))
//        {
//            return 0;
//        }


        StringBuilder reversedNumber = new StringBuilder();
        int l;
        if (x < 0)
        {
            l = 1;
            reversedNumber.append(number.charAt(0));
        }
        else
        {
            l = 0;
        }


        for (int h = number.length() - 1;  h >= l; h--)
        {
            if (number.charAt(h) != 0)
                reversedNumber.append(number.charAt(h));
        }

        number = reversedNumber.toString();
        try {
            int a = Integer.parseInt(number);
            return a;
        } catch (NumberFormatException ex)
        {
            return 0;
        }
    }


    public int reverse(int x) {
        int result = 0;

        while (x != 0)
        {
            int newresult = result * 10 + x % 10;
            if ((newresult - (x % 10)) / 10 != result)
            {
                return 0;
            }
            result = newresult;
            x = x / 10;
        }

        return result;
    }

    public static void main(String[] args)
    {
        Solution a = new Solution();
        int x = a.reverse(1534236469);
        System.out.println(x);
        x = a.reverse(-123);
        System.out.println(x);
        x = a.reverse(-120);
        System.out.println(x);
    }
}
