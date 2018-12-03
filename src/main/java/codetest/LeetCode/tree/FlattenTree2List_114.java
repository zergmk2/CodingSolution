package codetest.LeetCode.tree;

/*
 * [114] Flatten Binary Tree to Linked List
 *
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
 *
 * algorithms
 * Medium (38.12%)
 * Total Accepted:    198.7K
 * Total Submissions: 504.5K
 * Testcase Example:  '[1,2,5,3,4,null,6]'
 *
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * For example, given the following tree:
 * 
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   5
 * ⁠/ \   \
 * 3   4   6
 * 
 * 
 * The flattened tree should look like:
 * 
 * 
 * 1
 * ⁠\
 * ⁠ 2
 * ⁠  \
 * ⁠   3
 * ⁠    \
 * ⁠     4
 * ⁠      \
 * ⁠       5
 * ⁠        \
 * ⁠         6
 * 
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

public class FlattenTree2List_114 {
    public void flatten(TreeNode root) {
        if (root == null)
        {
            return;
        }

        if (root.right != null)
        {
            flatten(root.right);
        }

        if (root.left != null)
        {
            flatten(root.left);
        }

        TreeNode node = root.right;
        if ( root.left != null)
        {
            TreeNode right = root.left;
            while(true)
            {
                if (right.right != null)
                    right = right.right;
                else
                    break;
            }
            root.right = root.left;
            right.right = node;
            root.left = null;
        }
    }
}
