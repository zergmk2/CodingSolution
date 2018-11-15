/*
 * [538] Convert BST to Greater Tree
 *
 * https://leetcode.com/problems/convert-bst-to-greater-tree/description/
 *
 * algorithms
 * Easy (48.93%)
 * Total Accepted:    59.2K
 * Total Submissions: 120.9K
 * Testcase Example:  '[5,2,13]'
 *
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that
 * every key of the original BST is changed to the original key plus sum of all
 * keys greater than the original key in BST.
 * 
 * 
 * Example:
 * 
 * Input: The root of a Binary Search Tree like this:
 * ⁠             5
 * ⁠           /   \
 * ⁠          2     13
 * 
 * Output: The root of a Greater Tree like this:
 * ⁠            18
 * ⁠           /   \
 * ⁠         20     13
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
class Solution {
    private static int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null)
        {
            return null;
        }
 
        dfsHelper(root);
        sum = 0;
        return root;
    }

    private void dfsHelper(TreeNode root)
    {
        if (root == null)
        {
            return;
        }
 
        dfsHelper(root.right);
        root.val += sum;
        sum = root.val;   
        dfsHelper(root.left);
    }
}
