/*
 * [189] Rotate Array
 *
 * https://leetcode.com/problems/rotate-array/description/
 *
 * algorithms
 * Easy (26.93%)
 * Total Accepted:    218.3K
 * Total Submissions: 810.3K
 * Testcase Example:  '[1,2,3,4,5,6,7]\n3'
 *
 * Given an array, rotate the array to the right by k steps, where k is
 * non-negative.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation: 
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * 
 * 
 * Note:
 * 
 * 
 * Try to come up as many solutions as you can, there are at least 3 different
 * ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 * 
 * 
 */
class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0)
        {
            return;
        }

        if (k > nums.length)
            k = k - nums.length;

        for (int i = 0; i < k; i++)
        {
            ratateLastElement(nums);
        }
    }

    private void ratateLastElement(int[] nums)
    {
        int temp;
        for (int i = 0; i < nums.length - 1; i++)
        {
            temp = nums[i];
            nums[i] = nums[nums.length - 1];
            nums[nums.length - 1] = temp;
        }
    }

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0)
        {
            return;
        }

        k = k % nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end)
    {
        int temp;
        while (start < end)
        {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    public String test(int A, int B) {
        // greedy algorithum
        StringBuilder retValBuilder = new StringBuilder(A + B);
        while (A > 0 && B > 0)
        {
            if (A > B)
            {
                if (A - B == 1)
                {
                    retValBuilder.append("a");
                    A--;
                }

                if (A - B > 1)
                {
                    retValBuilder.append("aab");
                    A = A - 2;
                    B --;
                }
            }
            else if (B > A)
            {
                if (B - A == 1)
                {
                    retValBuilder.append("a");
                    B--;
                }

                if (B - A > 1)
                {
                    retValBuilder.append("bba");
                    B = B - 2;
                    A --;
                }
            }
            else
            {
                A--;
                B--;
                if (retValBuilder.length() == 0)
                {
                    retValBuilder.append("ba");
                }
                else if (retValBuilder.charAt(retValBuilder.length() - 1) == 'a')
                {
                    retValBuilder.append("ba");
                }
                else
                {
                    retValBuilder.append("ab");
                }
            }

        }

        return retValBuilder.toString();
    }

//    public String test(int[] T) {
        // write your code in Java SE 8
//        if (T == null || T.length == 0)
//        {
//            return "";
//        }
//
//        if ((T.length % 4) != 0)
//        {
//            return "";
//        }
//
//        int seasonDataLength = T.length / 4;
//
//        int[] seasonData = new int[seasonDataLength];
//        int highestAmplitudePerSeason = 0;
//        int result = 0;
//        String retVal = "";
//        int amplitude;
//        for (int i = 0; i < 4; i++)
//        {
//            int seasonStart = i * seasonDataLength;
//            for (int j = 0; j < seasonDataLength; j++)
//            {
//                seasonData[j] = T[seasonStart + j];
//            }
//            Arrays.sort(seasonData);
//            amplitude = Math.abs(seasonData[seasonDataLength - 1] - seasonData[0]);
//            if (amplitude > highestAmplitudePerSeason)
//            {
//                highestAmplitudePerSeason = amplitude;
//                result = i;
//            }
//        }
//
//        if (result == 0)
//        {
//            retVal = "WINTER";
//        }
//        else if (result == 1)
//        {
//            retVal = "SPRING";
//        }
//        else if (result == 2)
//        {
//            retVal = "SUMMER";
//        }
//        else if (result == 3)
//        {
//            retVal = "AUTUMN";
//        }
//        return retVal;
//    }


    public static void main(String args[])
    {
        Solution s = new Solution();
//        StringBuffer sb = new StringBuffer();
//        sb.append("ababa");
//        char c = sb.charAt(sb.length());
//        sb.to
//        String a = s.test(new int[] {2, 1, 1, 10, 2, 13, 3, -18});
//        String a = s.test(1, 4);
//        System.out.println(a);


    }
}
