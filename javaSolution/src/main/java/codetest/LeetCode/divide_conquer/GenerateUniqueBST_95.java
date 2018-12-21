package codetest.LeetCode.divide_conquer;/*
 * [95] Unique Binary Search Trees II
 *
 * https://leetcode.com/problems/unique-binary-search-trees-ii/description/
 *
 * algorithms
 * Medium (33.54%)
 * Total Accepted:    118K
 * Total Submissions: 350.1K
 * Testcase Example:  '3'
 *
 * Given an integer n, generate all structurally unique BST's (binary search
 * trees) that store values 1 ... n.
 * 
 * Example:
 * 
 * 
 * Input: 3
 * Output:
 * [
 * [1,null,3,2],
 * [3,2,null,1],
 * [3,1,null,null,2],
 * [2,1,3],
 * [1,null,2,null,3]
 * ]
 * Explanation:
 * The above output corresponds to the 5 unique BST's shown below:
 * 
 * ⁠  1         3     3      2      1
 * ⁠   \       /     /      / \      \
 * ⁠    3     2     1      1   3      2
 * ⁠   /     /       \                 \
 * ⁠  2     1         2                 3
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

public class GenerateUniqueBST_95 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
        {
            return new ArrayList<>(0);
        }

        return generateBST(1, n);
    }

    private List<TreeNode> generateBST(int start, int end)
    {
        List<TreeNode> result = new ArrayList<>();
        if (start == end)
        {
            result.add(new TreeNode(start));
            return result;
        }

        if (start > end)
        {
            result.add(null);
            return result;
        }

        for (int i = start; i <= end; i++)
        {
            List<TreeNode> leftTrees = generateBST(start, i-1);
            List<TreeNode> rightTrees = generateBST(i+1, end);

            for (TreeNode leftTree: leftTrees)
            {
                for (TreeNode rightTree: rightTrees)
                {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    result.add(root);
                }
            }
        }

        return result;
    }
}
