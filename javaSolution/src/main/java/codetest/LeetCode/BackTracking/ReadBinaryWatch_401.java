package codetest.LeetCode.BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * [401] Binary Watch
 *
 * https://leetcode.com/problems/binary-watch/description/
 *
 * algorithms
 * Easy (44.68%)
 * Total Accepted:    55K
 * Total Submissions: 123.1K
 * Testcase Example:  '0'
 *
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and
 * the 6 LEDs on the bottom represent the minutes (0-59).
 * Each LED represents a zero or one, with the least significant bit on the
 * right.
 * 
 * For example, the above binary watch reads "3:25".
 * 
 * Given a non-negative integer n which represents the number of LEDs that are
 * currently on, return all possible times the watch could represent.
 * 
 * Example:
 * Input: n = 1
 * Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04",
 * "0:08", "0:16", "0:32"]
 * 
 * 
 * Note:
 * 
 * The order of output does not matter.
 * The hour must not contain a leading zero, for example "01:00" is not valid,
 * it should be "1:00".
 * The minute must be consist of two digits and may contain a leading zero, for
 * example "10:2" is not valid, it should be "10:02".
 * 
 * 
 */
public class ReadBinaryWatch_401 {
    public List<String> readBinaryWatch(int num) {

        int[] hours = new int[] {1, 2, 4, 8};
        int[] minutes = new int[] {1, 2, 4, 8, 16, 32};
        List<String> list = new ArrayList<>();

        if (num > hours.length + minutes.length)
        {
            return list;
        }

        if (num == 0)
        {
            list.add("0:00");
            return list;
        }

        Map<Integer, List<Integer>> allPossibleHours = GetAllPossible(hours);
        Map<Integer, List<Integer>> allPossibleMinutes = GetAllPossible(minutes);


        for (int i = 0; i <= num; i++)
        {
            if (i <= hours.length && (num - i) <= minutes.length) {
                List<String> sublist = GetAllPossibleTime(allPossibleHours, allPossibleMinutes, i, num - i);
                list.addAll(sublist);
            }
        }

        return list;
    }

    private List<String> GetAllPossibleTime(Map<Integer, List<Integer>> allPossibleHours, Map<Integer, List<Integer>> allPossibleMinutes, int hoursCnt, int minutesCnt) {
        List<Integer> hoursList = allPossibleHours.get(hoursCnt);
        List<Integer> minutesList = allPossibleMinutes.get(minutesCnt);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < hoursList.size(); i++)
        {
            if (hoursList.get(i) > 11)
                continue;
            for (int j = 0; j < minutesList.size(); j++)
            {
                if (minutesList.get(j) > 59)
                {
                    continue;
                }
                list.add(String.format("%d:%02d", hoursList.get(i), minutesList.get(j)));
            }
        }
        return list;
    }

    private Map<Integer, List<Integer>> GetAllPossible(int[] nums) {
        Map<Integer, List<Integer>> allPossible = new HashMap<>();
        Backtracking(allPossible, 0, nums, 0, 0);
        return allPossible;
    }

    private void Backtracking(Map<Integer, List<Integer>> allPossible, int num, int[] nums, int start, int level) {
        if (!allPossible.containsKey(level)) {
            List<Integer> list = new ArrayList<>();
            list.add(num);
            allPossible.put(level, list);
        } else {
            allPossible.get(level).add(num);
        }

        for (int i = start; i < nums.length; i++) {
            num += nums[i];
            Backtracking(allPossible, num, nums, i + 1, level + 1);
            num -= nums[i];
        }
    }
}
