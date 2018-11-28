/*
 * [113] Path Sum II
 *
 * https://leetcode.com/problems/path-sum-ii/description/
 *
 * algorithms
 * Medium (37.12%)
 * Total Accepted:    194.8K
 * Total Submissions: 511.7K
 * Testcase Example:  '[5,4,8,11,null,13,4,7,2,null,null,5,1]\n22'
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Given the below binary tree and sum = 22,
 * 
 * 
 * ⁠     5
 * ⁠    / \
 * ⁠   4   8
 * ⁠  /   / \
 * ⁠ 11  13  4
 * ⁠/  \    / \
 * 7    2  5   1
 * 
 * 
 * Return:
 * 
 * 
 * [
 * ⁠  [5,4,11,2],
 * ⁠  [5,8,4,5]
 * ]
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
import java.util.*;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<Integer>(),root, sum);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, TreeNode root, int target)
    {
        if (root == null)
        {
            return;
        }

        if (target == root.val && root.left == null && root.right == null)
        {
            List<Integer> l = new ArrayList<>(list);
            l.add(root.val);
            result.add(l);
            return;
        }

        list.add(root.val);
        dfs(result, list, root.left, target - root.val);
        dfs(result, list, root.right, target - root.val);
        list.remove(list.size() - 1);
    }
}
