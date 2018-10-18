import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * [347] Top K Frequent Elements
 *
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 *
 * algorithms
 * Medium (50.59%)
 * Total Accepted:    124.9K
 * Total Submissions: 246.7K
 * Testcase Example:  '[1,1,1,2,2,3]\n2'
 *
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * Example 1:
 *
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 *
 *
 *
 * Example 2:
 *
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 *
 * Note:
 *
 *
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is
 * the array's size.
 *
 *
 */
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequentList = new HashMap<>();
        List<Integer> topKelements = new ArrayList<>();
        int maxfrequency = 0;
        for (int item : nums)
        {
            int fre = frequentList.getOrDefault(item, 0) + 1;
            if (fre > maxfrequency)
            {
                maxfrequency = fre;
            }
            frequentList.put(item, fre);
        }

        List<Integer>[] buckets = new ArrayList[maxfrequency + 1];

        for (int key : frequentList.keySet()) {
            if (buckets[frequentList.get(key)] == null) {
                buckets[frequentList.get(key)] = new ArrayList<>();
            }
            buckets[frequentList.get(key)].add(key);
        }

        for (int i = maxfrequency; i > 0; i--)
        {
            if(buckets[i] != null)
            {
                for (int num : buckets[i])
                {
                    topKelements.add(num);
                    k--;
                    if (k == 0)
                    {
                        return topKelements;
                    }
                }
            }
        }
        return topKelements;
    }
}
