import java.util.ArrayList;
import java.util.List;

/*
 * [524] Longest Word in Dictionary through Deleting
 *
 * https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/description/
 *
 * algorithms
 * Medium (43.51%)
 * Total Accepted:    26.9K
 * Total Submissions: 61.7K
 * Testcase Example:  '"abpcplea"\n["ale","apple","monkey","plea"]'
 *
 * 
 * Given a string and a string dictionary, find the longest string in the
 * dictionary that can be formed by deleting some characters of the given
 * string. If there are more than one possible results, return the longest word
 * with the smallest lexicographical order. If there is no possible result,
 * return the empty string.
 * 
 * Example 1:
 * 
 * Input:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * 
 * Output: 
 * "apple"
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * s = "abpcplea", d = ["a","b","c"]
 * 
 * Output: 
 * "a"
 * 
 * 
 * 
 * Note:
 * 
 * All the strings in the input will only contain lower-case letters.
 * The size of the dictionary won't exceed 1,000.
 * The length of all the strings in the input won't exceed 1,000.
 * 
 * 
 */
class Solution {
    public String findLongestWord(String s, List<String> d) {
        if (s == null || s.length() == 0)
            return "";

        if (d == null && d.size() == 0)
            return "";

        String findingWord = "";
        for (String target : d)
        {
            if (s.length() < target.length())
                continue;

            if (findingWord.length() > target.length() || (findingWord.length() == target.length() && findingWord.compareTo(target) < 0))
            {
                continue;
            }

            if (canFindSubstring(s, target))
            {
                findingWord = target;
            }
        }

        return findingWord;
    }

    private boolean canFindSubstring(String s, String target)
    {
        int i = 0;
        int j = 0;
        while(i < s.length() && j < target.length())
        {

            if (s.charAt(i) == target.charAt(j))
            {
                i++;
                j++;
            }
            else
            {
                i++;
            }
        }

        if (j == target.length())
        {
            return true;
        }
        return false;
    }

    public static void main(String[] args)
    {

        Solution s = new Solution();
        List<String> d = new ArrayList<>();
        d.add("ettphsiunoglotjlccurlre");
        s.findLongestWord("mjmqqjrmzkvhxlyruonekhhofpzzslupzojfuoztvzmmqvmlhgqxehojfowtrinbatjujaxekbcydldglkbxsqbbnrkhfdnpfbuaktupfftiljwpgglkjqunvithzlzpgikixqeuimmtbiskemplcvljqgvlzvnqxgedxqnznddkiujwhdefziydtquoudzxstpjjitmiimbjfgfjikkjycwgnpdxpeppsturjwkgnifinccvqzwlbmgpdaodzptyrjjkbqmgdrftfbwgimsmjpknuqtijrsnwvtytqqvookinzmkkkrkgwafohflvuedssukjgipgmypakhlckvizmqvycvbxhlljzejcaijqnfgobuhuiahtmxfzoplmmjfxtggwwxliplntkfuxjcnzcqsaagahbbneugiocexcfpszzomumfqpaiydssmihdoewahoswhlnpctjmkyufsvjlrflfiktndubnymenlmpyrhjxfdcq", d);
    }
}
