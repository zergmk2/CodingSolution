/*
 * [633] Sum of Square Numbers
 *
 * https://leetcode.com/problems/sum-of-square-numbers/description/
 *
 * algorithms
 * Easy (32.46%)
 * Total Accepted:    29.2K
 * Total Submissions: 89.9K
 * Testcase Example:  '5'
 *
 * 
 * Given a non-negative integer c, your task is to decide whether there're two
 * integers a and b such that a2 + b2 = c.
 * 
 * 
 * Example 1:
 * 
 * Input: 5
 * Output: True
 * Explanation: 1 * 1 + 2 * 2 = 5
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: 3
 * Output: False
 * 
 * 
 * 
 */
class Solution {
    public boolean judgeSquareSum(int c) {
        int l = 0;
        int r = (int)Math.sqrt(c) ;

        while (l <= r)
        {
            if ( l*l + r*r < c)
            {
                l++;
            }
            else if (l*l + r*r > c)
            {
                r--;
            }
            else if (l*l + r*r == c)
            {
                return true;
            }
        }
        return false;
    }
}
