/*
 * [204] Count Primes
 *
 * https://leetcode.com/problems/count-primes/description/
 *
 * algorithms
 * Easy (27.36%)
 * Total Accepted:    191.3K
 * Total Submissions: 698.6K
 * Testcase Example:  '10'
 *
 * Count the number of prime numbers less than a non-negative number, n.
 * 
 * Example:
 * 
 * 
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 * 
 */
class Solution {
    public int countPrimes(int n) {
        boolean[] primesMap = new boolean[n];

        int primeCnt = 0;
        // prime start from 2
        for (int i = 2; i < n; i++)
        {
            if (!primesMap[i])
            {
                primeCnt++;
                for (int j = 1; j < n; j++)
                {
                    if ( i * j < n)
                    {
                        primesMap[i*j] = true;
                    }
                    else
                    {
                        break;
                    }
                }
            }
        }

        return primeCnt;
    }
}
