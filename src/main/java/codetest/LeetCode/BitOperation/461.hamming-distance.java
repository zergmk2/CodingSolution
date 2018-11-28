/*
 * [461] Hamming Distance
 *
 * https://leetcode.com/problems/hamming-distance/description/
 *
 * algorithms
 * Easy (69.46%)
 * Total Accepted:    197.4K
 * Total Submissions: 284K
 * Testcase Example:  '1\n4'
 *
 * The Hamming distance between two integers is the number of positions at
 * which the corresponding bits are different.
 * 
 * Given two integers x and y, calculate the Hamming distance.
 * 
 * Note:
 * 0 ≤ x, y < 231.
 * 
 * 
 * Example:
 * 
 * Input: x = 1, y = 4
 * 
 * Output: 2
 * 
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ⁠      ↑   ↑
 * 
 * The above arrows point to positions where the corresponding bits are
 * different.
 * 
 * 
 */
class Solution {
    public int hammingDistance(int x, int y) {
        int cnt = 0;
        while (x != 0 || y != 0)
        {
            int a = x & 0x1;
            int b = y & 0x1;
            if (a != b)
            {
                cnt++;
            }
            x = x >> 1;
            y = y >> 1;
        }
        return cnt;
    }
}
