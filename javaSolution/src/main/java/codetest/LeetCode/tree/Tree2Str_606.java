package codetest.LeetCode.tree;

/*
 * [606] Construct String from Binary Tree
 *
 * https://leetcode.com/problems/construct-string-from-binary-tree/description/
 *
 * algorithms
 * Easy (50.51%)
 * Total Accepted:    47.4K
 * Total Submissions: 93.9K
 * Testcase Example:  '[1,2,3,4]'
 *
 * You need to construct a string consists of parenthesis and integers from a
 * binary tree with the preorder traversing way.
 * 
 * The null node needs to be represented by empty parenthesis pair "()". And
 * you need to omit all the empty parenthesis pairs that don't affect the
 * one-to-one mapping relationship between the string and the original binary
 * tree.
 * 
 * Example 1:
 * 
 * Input: Binary tree: [1,2,3,4]
 * ⁠      1
 * ⁠    /   \
 * ⁠   2     3
 * ⁠  /    
 * ⁠ 4     
 * 
 * Output: "1(2(4))(3)"
 * Explanation: Originallay it needs to be "1(2(4)())(3()())", but you need to
 * omit all the unnecessary empty parenthesis pairs. And it will be
 * "1(2(4))(3)".
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: Binary tree: [1,2,3,null,4]
 * ⁠      1
 * ⁠    /   \
 * ⁠   2     3
 * ⁠    \  
 * ⁠     4 
 * 
 * Output: "1(2()(4))(3)"
 * Explanation: Almost the same as the first example, except we can't omit the
 * first parenthesis pair to break the one-to-one mapping relationship between
 * the input and the output.
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
public class Tree2Str_606 {
    StringBuilder sb = new StringBuilder();
    public String tree2str(TreeNode t) {
        inOrder(t);
        return sb.toString();
    }

    private void inOrder(TreeNode t)
    {
        if (t == null)
        {
            return;
        }

        sb.append(t.val);


        if (t.left == null && t.right == null)
        {
            return;
        }

        if (t.left != null)
        {
            sb.append('(');
            tree2str(t.left);
            sb.append(')');
        }
        else
        {
            sb.append("()");
        }

        if (t.right != null)
        {
            sb.append('(');
            tree2str(t.right);
            sb.append(')');
        }
    }
}
