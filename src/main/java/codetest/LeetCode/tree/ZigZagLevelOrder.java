package codetest.LeetCode.tree;

import codetest.DataStructure.Tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


// import DataStructure.TreeNode;

/*
 * [103] Binary Tree Zigzag Level Order Traversal
 *
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 *
 * algorithms
 * Medium (38.09%)
 * Total Accepted:    167.9K
 * Total Submissions: 433.4K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes'
 * values. (ie, from left to right, then right to left for the next level and
 * alternate between).
 * 
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 
 * return its zigzag level order traversal as:
 * 
 * [
 * ⁠ [3],
 * ⁠ [20,9],
 * ⁠ [15,7]
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
public class ZigZagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigZagList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null)
        {
            return zigZagList;
        }        

        queue.offer(root);
        boolean toggle = true;
        while(!queue.isEmpty())
        {
            int size = queue.size();
            List<Integer> list = new ArrayList<>(size);
            for(int i = 0; i < size; i++)
            {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            if (toggle)
                zigZagList.add(list);
            else
            {
                Collections.reverse(list);
                zigZagList.add(list);
            }
            toggle = !toggle;
        }
        return zigZagList;
    }
}
