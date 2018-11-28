/*
 * [48] Rotate Image
 *
 * https://leetcode.com/problems/rotate-image/description/
 *
 * algorithms
 * Medium (44.10%)
 * Total Accepted:    192.6K
 * Total Submissions: 434.3K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * You are given an n x n 2D matrix representing an image.
 * 
 * Rotate the image by 90 degrees (clockwise).
 * 
 * Note:
 * 
 * You have to rotate the image in-place, which means you have to modify the
 * input 2D matrix directly. DO NOT allocate another 2D matrix and do the
 * rotation.
 * 
 * Example 1:
 * 
 * 
 * Given input matrix = 
 * [
 * ⁠ [1,2,3],
 * ⁠ [4,5,6],
 * ⁠ [7,8,9]
 * ],
 * 
 * rotate the input matrix in-place such that it becomes:
 * [
 * ⁠ [7,4,1],
 * ⁠ [8,5,2],
 * ⁠ [9,6,3]
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Given input matrix =
 * [
 * ⁠ [ 5, 1, 9,11],
 * ⁠ [ 2, 4, 8,10],
 * ⁠ [13, 3, 6, 7],
 * ⁠ [15,14,12,16]
 * ], 
 * 
 * rotate the input matrix in-place such that it becomes:
 * [
 * ⁠ [15,13, 2, 5],
 * ⁠ [14, 3, 4, 1],
 * ⁠ [12, 6, 8, 9],
 * ⁠ [16, 7,10,11]
 * ]
 * 
 * 
 */
class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
        {
            return;
        }

        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        if (rowLength != colLength)
            return;

        int startIndex = 0;
        while (rowLength > 1 && colLength > 1)
        {

//            rotate(matrix, startIndex, rowLength, colLength);
            rowLength -= 2;
            colLength -= 2;
        }
    }

//    public int solution(int[] A) {
//        // write your code in Java SE 8
//        if (A == null || A.length == 0)
//        {
//            return 0;
//        }
//
//        LinkedList<Integer> list = new LinkedList<>();
//        for (int num : A)
//        {
//            list.add(num);
//        }
//
//        int cnt = 0;
//        for (int i = 0; i < list.size(); i++)
//        {
//            LinkedList<Integer> list2 = new LinkedList();
//            list2 = (LinkedList)list.clone();
//            list2.remove(i);
//            if (isNonDecreasing(list2))
//            {
//                cnt++;
//            }
//        }
//
//        return cnt;
//    }
//
//    private boolean isNonDecreasing(LinkedList<Integer> list)
//    {
//        int pre = list.get(0);
//        for (int i = 1; i < list.size(); i++)
//        {
//            if (pre > list.get(i))
//            {
//                return false;
//            }
//            pre = list.get(i);
//        }
//        return true;
//    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        if (A == null || A.length == 0) {
            return 0;
        }

        int max = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] > max) {
                max = A[i];
            }
        }

        int totalStroke = 0;
        for (int i = 1; i < max; i++)
        {
            totalStroke += FindConsequenceCnt(A, i);
        }
        if (totalStroke > 1000000000)
        {
            return -1;
        }

        return totalStroke;
    }

    private int FindConsequenceCnt(int[] A, int number)
    {
        int cnt = 0;
        boolean isConsequence = false;
        for (int i = 0 ; i < A.length; i++)
        {
            if (A[i] >= number)
            {
                if (!isConsequence) {
                    cnt++;
                    isConsequence = true;
                }
            }
            else
            {
                isConsequence = false;
            }

        }

        return cnt;
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        int[] A = {3, 4, 5, 4};
        s.solution(A);
    }
}
