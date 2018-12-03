package codetest.LeetCode.Array;

//942. DI String Match
//Given a string S that only contains "I" (increase) or "D" (decrease), let N = S.length.

//Return any permutation A of [0, 1, ..., N] such that for all i = 0, ..., N-1:

//If S[i] == "I", then A[i] < A[i+1]
//If S[i] == "D", then A[i] > A[i+1]
 

//Example 1:

//Input: "IDID"
//Output: [0,4,1,3,2]
//Example 2:

//Input: "III"
//Output: [0,1,2,3]
//Example 3:

//Input: "DDI"
//Output: [3,2,0,1]
 

//Note:

//1 <= S.length <= 10000
//S only contains characters "I" or "D".

public class DiStringMatch_942 {
    public int[] diStringMatch(String S) {
        if (S.length() == 0)
        {
            return new int[0];
        }

        int[] ret = new int[S.length() + 1];

        int max = S.length();
        int min = 0;
        for (int i = 0; i < S.length(); i++)
        {
            if (S.charAt(i) == 'D')
            {
                ret[i] = max;
                max--;
            }
            else
            {
                ret[i] = min;
                min++;
            }
        }

        if (S.charAt(S.length() - 1) == 'D')
            ret[S.length()] = min;
        else
            ret[S.length()] = max;

        return ret;
    }
}
