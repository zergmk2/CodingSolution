//Given an array A of integers, return true if and only if it is a valid mountain array.

//Recall that A is a mountain array if and only if:

//A.length >= 3
//There exists some i with 0 < i < A.length - 1 such that:
//A[0] < A[1] < ... A[i-1] < A[i]
//A[i] > A[i+1] > ... > A[B.length - 1]
 

//Example 1:

//Input: [2,1]
//Output: false
//Example 2:

//Input: [3,5,5]
//Output: false
//Example 3:

//Input: [0,3,2,1]
//Output: true
//
class Solution {
    public boolean validMountainArray(int[] A) {
        if (A == null || A.length < 3)
        {
            return false;
        }

        int mountPoint = 0;

        for (int i = 1; i < A.length; i++)
        {
            if (A[i-1] < A[i])
            {
                mountPoint = i;
            }
            else
            {
                break;
            }
        }

        if (mountPoint >= A.length - 1 || mountPoint == 0)
        {
            return false;
        }


        for (int i = mountPoint; i < A.length - 1; i++)
        {
            if (A[i] > A[i+1])
            {
                mountPoint = i;
            }
            else
            {
                return false;
            }
        }

        return true;
    }
}
