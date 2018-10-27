import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * [451] Sort Characters By Frequency
 *
 * https://leetcode.com/problems/sort-characters-by-frequency/description/
 *
 * algorithms
 * Medium (52.53%)
 * Total Accepted:    62.8K
 * Total Submissions: 119.3K
 * Testcase Example:  '"tree"'
 *
 * Given a string, sort it in decreasing order based on the frequency of
 * characters.
 * 
 * Example 1:
 * 
 * Input:
 * "tree"
 * 
 * Output:
 * "eert"
 * 
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid
 * answer.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * "cccaaa"
 * 
 * Output:
 * "cccaaa"
 * 
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * 
 * 
 * 
 * Example 3:
 * 
 * Input:
 * "Aabb"
 * 
 * Output:
 * "bbAa"
 * 
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 * 
 * 
 */
class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> frequents = new HashMap<>();
        int maxfreq = 0;
        for (int i = 0; i < s.length(); i++)
        {
            int feq = frequents.getOrDefault(s.charAt(i), 0 ) + 1;
            if (feq > maxfreq)
                maxfreq = feq;
            frequents.put(s.charAt(i), feq);
        }

        System.out.println(maxfreq);

        List<Character>[] buckets = new ArrayList[maxfreq + 1];
        for (char c : frequents.keySet())
        {
            if (buckets[frequents.get(c)] == null)
            {
                buckets[frequents.get(c)] = new ArrayList<>();
            }
            buckets[frequents.get(c)].add(c);
        }

        StringBuilder ret = new StringBuilder();
        for (int i = maxfreq; i > 0; i--)
        {
            if (buckets[i] != null)
            {
                for (char c : buckets[i])
                {
                    for (int j = 0; j < i; j++)
                    {
                        ret.append(c);
                    }
                }
            }
        }

        return ret.toString();
    }
}
