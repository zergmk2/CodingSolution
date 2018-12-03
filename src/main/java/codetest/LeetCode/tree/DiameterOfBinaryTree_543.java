package codetest.LeetCode.tree;/*
 * [543] Diameter of Binary Tree
 *
 * https://leetcode.com/problems/diameter-of-binary-tree/description/
 *
 * algorithms
 * Easy (45.24%)
 * Total Accepted:    92.7K
 * Total Submissions: 204.3K
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * 
 * Given a binary tree, you need to compute the length of the diameter of the
 * tree. The diameter of a binary tree is the length of the longest path
 * between any two nodes in a tree. This path may or may not pass through the
 * root.
 * 
 * 
 * 
 * Example:
 * Given a binary tree 
 * 
 * ⁠         1
 * ⁠        / \
 * ⁠       2   3
 * ⁠      / \     
 * ⁠     4   5    
 * 
 * 
 * 
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * 
 * 
 * Note:
 * The length of path between two nodes is represented by the number of edges
 * between them.
 * 
 */

import codetest.DataStructure.Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class DiameterOfBinaryTree_543 {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
        {
            return 0;
        }
        
        if (root.left == null && root.right == null)
        {
            return 0;
        }

        int maxlenght = Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));
        return Math.max(maxlenght, dfsHelper(root));
    }

    private int dfsHelper(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }

        if (root.left == null && root.right == null)
        {
            return 0;
        }
        int ret = 0;
        if (root.left != null)
            ret += findMaxLength(root.left) + 1; 

        if (root.right != null)
            ret += findMaxLength(root.right) + 1;

        return ret;
    }

    private int findMaxLength(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node = root;
        int maxLength = 0;
        queue.offer(root);
        while (!queue.isEmpty())
        {
            int size = queue.size();
            for (int i = 0; i < size; i++)
            {
                TreeNode n = queue.poll();
                if (n.left != null)
                    queue.offer(n.left);
                if (n.right != null)
                    queue.offer(n.right);
            }
            maxLength++;
        }
        return maxLength - 1;
    }
}
