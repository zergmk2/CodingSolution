/*
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (36.68%)
 * Total Accepted:    172.3K
 * Total Submissions: 463.9K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * 
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * 
 * Return the following binary tree:
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 */
//import DataStructure.TreeNode;

import java.util.Arrays;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0)
        {
            return null;
        }

        if (preorder.length == 1 && inorder.length == 1)
        {
            return new TreeNode(inorder[0]);
        }

        int rootVal = preorder[0];

        int root_index = 0;
        for (; root_index < inorder.length; root_index++)
        {
            if (inorder[root_index] == rootVal)
            {
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);

        // Only right tree
        if (root_index == 0)
        {
            int[] inorder_r = Arrays.copyOfRange(inorder, root_index + 1, preorder.length );
            int[] preOrder_r = Arrays.copyOfRange(preorder, 1, preorder.length);
            root.right = buildTree(preOrder_r, inorder_r);
        }
        // Only left tree
        else if (root_index == inorder.length - 1)
        {
            int[] inorder_l = Arrays.copyOfRange(inorder, 0, root_index);
            int[] preOrder_l = Arrays.copyOfRange(preorder, 1, preorder.length);
            root.left = buildTree(preOrder_l, inorder_l);
        }
        // left and right tree
        else if (root_index < inorder.length - 1 && root_index > 0)
        {
            int[] inorder_l = Arrays.copyOfRange(inorder, 0, root_index);
            int[] inorder_r = Arrays.copyOfRange(inorder, root_index + 1, preorder.length );

            int[] preorder_l = Arrays.copyOfRange(preorder, 1, root_index + 1);
            int[] preorder_r = Arrays.copyOfRange(preorder, root_index + 1, preorder.length);
            root.right = buildTree(preorder_r, inorder_r);
            root.left = buildTree(preorder_l, inorder_l);
        }
        return root;
    }

    public static void main(String[] args)
    {
        int[] preorder = new int[] {3, 9, 20, 15, 7};
        int[] inorder = new int[] {9,3,15,20,7};
        Solution s = new Solution();
        s.buildTree(preorder, inorder);
    }
}
