/*
 * [13] Roman to Integer
 *
 * https://leetcode.com/problems/roman-to-integer/description/
 *
 * algorithms
 * Easy (49.28%)
 * Total Accepted:    271.8K
 * Total Submissions: 551.6K
 * Testcase Example:  '"III"'
 *
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D
 * and M.
 * 
 * 
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 
 * For example, two is written as II in Roman numeral, just two one's added
 * together. Twelve is written as, XII, which is simply X + II. The number
 * twenty seven is written as XXVII, which is XX + V + II.
 * 
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is
 * written as IV. Because the one is before the five we subtract it making
 * four. The same principle applies to the number nine, which is written as IX.
 * There are six instances where subtraction is used:
 * 
 * 
 * I can be placed before V (5) and X (10) to make 4 and 9. 
 * X can be placed before L (50) and C (100) to make 40 and 90. 
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * 
 * 
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be
 * within the range from 1 to 3999.
 * 
 * Example 1:
 * 
 * 
 * Input: "III"
 * Output: 3
 * 
 * Example 2:
 * 
 * 
 * Input: "IV"
 * Output: 4
 * 
 * Example 3:
 * 
 * 
 * Input: "IX"
 * Output: 9
 * 
 * Example 4:
 * 
 * 
 * Input: "LVIII"
 * Output: 58
 * Explanation: C = 100, L = 50, XXX = 30 and III = 3.
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * 
 */

enum RomanSymbol
{
    I('I', 1), V('V', 5), X('X', 10), L('L',50),
    C('C', 100), D('D', 500), M('M', 1000);
    private char symbol;
    private int value;

    private RomanSymbol(char symbol, int value)
    {
        this.symbol = symbol;
        this.value = value;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static int getValue(char symbol)
    {
        for (RomanSymbol s : RomanSymbol.values())
        {
            if (s.getSymbol() == symbol)
            {
                return s.getValue();
            }
        }
        return 0;
    }
}

class Solution {
   public int romanToInt(String s) {

       if (s == null || s.length() == 0)
       {
           return 0;
       }
       int sum = 0;
       for (int i = 0; i < s.length() ; )
       {
           if (isSpecialCase(s,i))
           {
               sum += RomanSymbol.getValue(s.charAt(i+1));
               sum -= RomanSymbol.getValue(s.charAt(i));
               i += 2;
           }
           else
           {
               sum += RomanSymbol.getValue(s.charAt(i));
               i++;
           }
       }
       return sum;
   }

/*
 *
 * I can be placed before V (5) and X (10) to make 4 and 9. 
 * X can be placed before L (50) and C (100) to make 40 and 90. 
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 */

   private boolean isSpecialCase(String s, int k)
   {
       if(k+1 < s.length())
       {
           if (s.charAt(k)== 'I') {
               if (s.charAt(k + 1) == 'V' || s.charAt(k + 1) == 'X')
               {
                   return true;
               }
           } else if (s.charAt(k)== 'X') {
               if (s.charAt(k + 1) == 'L' || s.charAt(k + 1) == 'C')
               {
                   return true;
               }
           } else if (s.charAt(k)== 'C') {
               if (s.charAt(k + 1) == 'D' || s.charAt(k + 1) == 'M')
               {
                   return true;
               }
           }
       }
       return false;
   }
}
