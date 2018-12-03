package codetest.LeetCode.tree;

/*
 * [572] Subtree of Another Tree
 *
 * https://leetcode.com/problems/subtree-of-another-tree/description/
 *
 * algorithms
 * Easy (40.41%)
 * Total Accepted:    72.3K
 * Total Submissions: 178.7K
 * Testcase Example:  '[3,4,5,1,2]\n[4,1,2]'
 *
 * 
 * Given two non-empty binary trees s and t, check whether tree t has exactly
 * the same structure and node values with a subtree of s. A subtree of s is a
 * tree consists of a node in s and all of this node's descendants. The tree s
 * could also be considered as a subtree of itself.
 * 
 * 
 * Example 1:
 * 
 * Given tree s:
 * 
 * ⁠    3
 * ⁠   / \
 * ⁠  4   5
 * ⁠ / \
 * ⁠1   2
 * 
 * Given tree t:
 * 
 * ⁠  4 
 * ⁠ / \
 * ⁠1   2
 * 
 * Return true, because t has the same structure and node values with a subtree
 * of s.
 * 
 * 
 * Example 2:
 * 
 * Given tree s:
 * 
 * ⁠    3
 * ⁠   / \
 * ⁠  4   5
 * ⁠ / \
 * ⁠1   2
 * ⁠   /
 * ⁠  0
 * 
 * Given tree t:
 * 
 * ⁠  4
 * ⁠ / \
 * ⁠1   2
 * 
 * Return false.
 * 
 */

import codetest.DataStructure.Tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SubtreeOfAnotherTree_572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null)
        {
            return true;
        }

        if (s == null || t == null)
        {
            return false;
        }

        return isSubtree(s.left, t) || isSubtree(s.right, t) || isSubtreeHelper(s, t);
    }

    private boolean isSubtreeHelper(TreeNode s, TreeNode t)
    {
        if (s == null && t == null)
        {
            return true;
        }

        if (s == null || t == null)
        {
            return false;
        }

        return isSubtreeHelper(s.left, t.left) && (s.val == t.val) && isSubtreeHelper(s.right, t.right);
    }
}
