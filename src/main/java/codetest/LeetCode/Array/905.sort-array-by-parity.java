/*
 * [941] Sort Array By Parity
 *
 * https://leetcode.com/problems/sort-array-by-parity/description/
 *
 * algorithms
 * Easy (70.64%)
 * Total Accepted:    30.5K
 * Total Submissions: 43.1K
 * Testcase Example:  '[3,1,2,4]'
 *
 * Given an array A of non-negative integers, return an array consisting of all
 * the even elements of A, followed by all the odd elements of A.
 * 
 * You may return any answer array that satisfies this condition.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 * 
 * 
 * 
 */
class Solution {
    public int[] sortArrayByParity(int[] A) {
        if (A == null || A.length <= 1)
        {
            return A;
        }

        int evenIndex = A.length - 1;

        for (int i = 0; i < evenIndex;)
        {
            if (!isOdd(A[i]))
            {
                i++;       
            }
            else
            {
                swap(A, i, evenIndex);
                evenIndex--;
            }
        }
        return A;
    }

    private void swap(int[] A, int i, int j)
    {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    private boolean isOdd(int number)
    {
        return number % 2 == 1;
    }
}
