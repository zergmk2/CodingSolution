
/*
 * [774] Maximum Depth of N-ary Tree
 *
 * https://leetcode.com/problems/maximum-depth-of-n-ary-tree/description/
 *
 * algorithms
 * Easy (61.72%)
 * Total Accepted:    16.4K
 * Total Submissions: 26.4K
 * Testcase Example:  '{"$id":"1","children":[{"$id":"2","children":[{"$id":"5","children":[],"val":5},{"$id":"6","children":[],"val":6}],"val":3},{"$id":"3","children":[],"val":2},{"$id":"4","children":[],"val":4}],"val":1}'
 *
 * Given a n-ary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the
 * root node down to the farthest leaf node.
 * 
 * For example, given a 3-ary tree:
 * 
 * 
 * 
 * 
 * 
 * 
 * We should return its max depth, which is 3.
 * 
 * 
 * 
 * Note:
 * 
 * 
 * The depth of the tree is at most 1000.
 * The total number of nodes is at most 5000.
 * 
 * 
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

import java.util.*;
class Solution {
    public int maxDepth(Node root) {
        if (root == null)
        {
            return 0;
        }

        int maxDepth = 0;
        for(Node child : root.children)
            maxDepth = Math.max(maxDepth, maxDepth(child));
        return maxDepth + 1;
        // return GetMaxDepth(root);   
    }

    private int GetMaxDepth(Node root)
    {
        int maxDepth = 1;
        Queue<Node> queue = new LinkedList<>();

        for (Node child : root.children)
        {
            queue.offer(child);
        }

        while (!queue.isEmpty())
        {
            maxDepth++;
            int size = queue.size();
            for (int i = 0; i < size; i++)
            {
                Node node = queue.poll();
                for (Node child : node.children)
                {
                    queue.offer(child);
                }
            }    
        }
        return maxDepth;
    }
}
