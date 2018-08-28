import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * [406] Queue Reconstruction by Height
 *
 * https://leetcode.com/problems/queue-reconstruction-by-height/description/
 *
 * algorithms
 * Medium (56.83%)
 * Total Accepted:    54.4K
 * Total Submissions: 95.7K
 * Testcase Example:  '[[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]'
 *
 * Suppose you have a random list of people standing in a queue. Each person is
 * described by a pair of integers (h, k), where h is the height of the person
 * and k is the number of people in front of this person who have a height
 * greater than or equal to h. Write an algorithm to reconstruct the queue.
 * 
 * 
 * Note:
 * The number of people is less than 1,100.
 * 
 * 
 * 
 * 
 * Example
 * 
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * 
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * 
 * 
 */
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0)
        {
            return new int[][]{};
        }
        Arrays.sort(people, (people1, people2) -> (people1[0] == people2[0] ? people1[1] - people2[1] : people2[0] - people1[0]));

        List<int[]> queue = new ArrayList<>();

        for (int i = 0 ; i < people.length; i++)
        {
            queue.add(people[i][1], people[i]);
        }

        return queue.toArray(new int[queue.size()][]);
    }
}
