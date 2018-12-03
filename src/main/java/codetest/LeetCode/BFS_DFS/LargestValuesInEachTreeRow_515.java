package codetest.LeetCode.BFS_DFS;/*
 * [515] Find Largest Value in Each Tree Row
 *
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/
 *
 * algorithms
 * Medium (56.33%)
 * Total Accepted:    50.9K
 * Total Submissions: 90.3K
 * Testcase Example:  '[1,3,2,5,3,null,9]'
 *
 * You need to find the largest value in each row of a binary tree.
 * 
 * Example:
 * 
 * Input: 
 * 
 * ⁠         1
 * ⁠        / \
 * ⁠       3   2
 * ⁠      / \   \  
 * ⁠     5   3   9 
 * 
 * Output: [1, 3, 9]
 * 
 * 
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import codetest.DataStructure.Tree.TreeNode;

import java.util.*;

public class LargestValuesInEachTreeRow_515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null)
        {
            return list;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty())
        {
            int size = queue.size();
            int maxVal = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++)
            {
                TreeNode n = queue.poll();
                maxVal = Math.max(maxVal, n.val);
                if (n.left != null)
                {
                    queue.offer(n.left);
                }
                
                if (n.right != null)
                {
                    queue.offer(n.right);
                }
            }
            list.add(maxVal);
        }
        return list; 
    }
}
