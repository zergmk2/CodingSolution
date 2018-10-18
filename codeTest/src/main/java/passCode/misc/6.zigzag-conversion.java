/*
 * [6] ZigZag Conversion
 *
 * https://leetcode.com/problems/zigzag-conversion/description/
 *
 * algorithms
 * Medium (28.61%)
 * Total Accepted:    239.4K
 * Total Submissions: 836.8K
 * Testcase Example:  '"PAYPALISHIRING"\n3'
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 * 
 * 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * 
 * Write the code that will take a string and make this conversion given a
 * number of rows:
 * 
 * 
 * string convert(string s, int numRows);
 * 
 * Example 1:
 * 
 * 
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * 
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 
 */
class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows == 0)
        {
            return "";
        }

        if (numRows == 1)
        {
            return s;
        }

        StringBuilder[] zigZagStringBuilder = new StringBuilder[numRows];
        for (int i = 0; i < zigZagStringBuilder.length; i++) {
            zigZagStringBuilder[i] = new StringBuilder();
        }
        int index = 0;
        while (index < s.length()) {
            for (int i = 0; i < numRows && index < s.length(); i++, index++) {
                zigZagStringBuilder[i].append(s.charAt(index));
            }

            for (int j = numRows - 2; j > 0 && index < s.length(); j--, index++)
            {
                zigZagStringBuilder[j].append(s.charAt(index));
            }
        }

        StringBuilder convertResultBuilder = new StringBuilder(s.length());
        for(StringBuilder build : zigZagStringBuilder) {
            convertResultBuilder.append(build.toString());
        }
        return convertResultBuilder.toString();
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        String ret = s.convert("PAYPALISHIRING", 3);
        System.out.println(ret);
    }
}
