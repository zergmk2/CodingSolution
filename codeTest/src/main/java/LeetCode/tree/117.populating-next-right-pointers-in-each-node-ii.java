/*
 * [117] Populating Next Right Pointers in Each Node II
 *
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/description/
 *
 * algorithms
 * Medium (33.44%)
 * Total Accepted:    155.7K
 * Total Submissions: 465.8K
 * Testcase Example:  '{}'
 *
 * Given a binary tree
 * 
 * 
 * struct TreeLinkNode {
 * ⁠ TreeLinkNode *left;
 * ⁠ TreeLinkNode *right;
 * ⁠ TreeLinkNode *next;
 * }
 * 
 * 
 * Populate each next pointer to point to its next right node. If there is no
 * next right node, the next pointer should be set to NULL.
 * 
 * Initially, all next pointers are set to NULL.
 * 
 * Note:
 * 
 * 
 * You may only use constant extra space.
 * Recursive approach is fine, implicit stack space does not count as extra
 * space for this problem.
 * 
 * 
 * Example:
 * 
 * Given the following binary tree,
 * 
 * 
 * ⁠    1
 * ⁠  /  \
 * ⁠ 2    3
 * ⁠/ \    \
 * 4   5    7
 * 
 * 
 * After calling your function, the tree should look like:
 * 
 * 
 * ⁠    1 -> NULL
 * ⁠  /  \
 * ⁠ 2 -> 3 -> NULL
 * ⁠/ \    \
 * 4-> 5 -> 7 -> NULL
 * 
 * 
 */
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null)
        {
            return;
        }

        // find the first child and its root node in the same level
        TreeLinkNode parent = root;
        TreeLinkNode first = null;
        while (parent != null)  
        {
            if (parent.left != null)
            {
                first = parent.left;
                break;
            }
            else if (parent.right != null)
            {
                first = parent.right;
                break;
            }
            parent = parent.next;
        }

        if (first == null)
        {
            return;
        }
        else
        {
            // link all children with the same level of first 
            TreeLinkNode preNode = null;
            while(parent != null)
            {
                if (parent.left != null)
                {
                    if (preNode != null)
                    {
                        preNode.next = parent.left;
                    }

                    if (parent.right != null)
                    {
                        parent.left.next = parent.right;
                        preNode = parent.right;
                    }
                    else
                    {
                        preNode = parent.left;
                    }
                } 
                else if (parent.right != null)
                {
                    if (preNode != null)
                    {
                        preNode.next = parent.right;
                    }
                    preNode = parent.right;
                }
                parent = parent.next;
            }

            // link the next level;
            connect(first);
        }

        // TreeLinkNode node = root.next;
        // TreeLinkNode sibling = null;
        // while (node != null)
        // {
        //     if (node.left != null)
        //     {
        //         sibling = node.left;
        //         break;
        //     }
        //     else if (node.right != null)
        //     {
        //         sibling = node.right;
        //         break;
        //     }
        //     node = node.next;
        // }

        // if (root.right != null)
        // {
        //     if (root.left != null)
        //     {
        //         root.left.next = root.right;
        //     }

        //     if (sibling != null)
        //     {
        //         root.right.next = sibling;
        //     }
        // }
        
        // if (root.left != null && root.right == null)
        // {
        //     if (sibling != null)
        //     {
        //         root.left.next = sibling;
        //     }
        // }
    }
}
