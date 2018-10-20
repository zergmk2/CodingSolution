/*
 * [101] Symmetric Tree
 *
 * https://leetcode.com/problems/symmetric-tree/description/
 *
 * algorithms
 * Easy (41.41%)
 * Total Accepted:    305.5K
 * Total Submissions: 735.2K
 * Testcase Example:  '[1,2,2,3,4,4,3]'
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric
 * around its center).
 * 
 * 
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   2
 * ⁠/ \ / \
 * 3  4 4  3
 * 
 * 
 * 
 * But the following [1,2,2,null,3,null,3]  is not:
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   2
 * ⁠  \   \
 * ⁠  3    3
 * 
 * 
 * 
 * 
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 * 
 */

//import DataStructure.TreeNode;

//import DataStructure.TreeNode;

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

    // Non-recursive Solution
//    public boolean isSymmetric(TreeNode root) {
//        if (root == null)
//            return true;
//
//        if (root.left == null && root.right == null)
//        {
//            return true;
//        }
//
//        if (root.left == null || root.right == null)
//        {
//            return false;
//        }
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root.left);
//        stack.push(root.right);
//
//        while (!stack.empty())
//        {
//            TreeNode left = stack.pop();
//            TreeNode right = stack.pop();
//
//            if (left == null && right == null)
//            {
//                continue;
//            }
//
//            if (left == null || right == null || left.val != right.val)
//            {
//                return false;
//            }
//
//            stack.push(left.left);
//            stack.push(right.right);
//            stack.push(left.right);
//            stack.push(right.left);
//        }
//        return true;
//    }

    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetricRecursive(root.left, root.right);
    }

    private boolean isSymmetricRecursive(TreeNode left, TreeNode right) {
        if (left == null && right == null)
        {
            return true;
        }

        if (left == null || right == null || left.val != right.val)
        {
            return false;
        }

        return isSymmetricRecursive(left.left, right.right) && isSymmetricRecursive(left.right , right.left);
    }


    public static void main(String[] args)
    {
        Solution s = new Solution();
        TreeNode root = new TreeNode(0);
        s.isSymmetric(root);
    }
}
