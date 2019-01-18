/*
 * [449] Serialize and Deserialize BST
 *
 * https://leetcode.com/problems/serialize-and-deserialize-bst/description/
 *
 * algorithms
 * Medium (43.07%)
 * Total Accepted:    43.1K
 * Total Submissions: 96.6K
 * Testcase Example:  '[2,1,3]'
 *
 * Serialization is the process of converting a data structure or object into a
 * sequence of bits so that it can be stored in a file or memory buffer, or
 * transmitted across a network connection link to be reconstructed later in
 * the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary search tree. There
 * is no restriction on how your serialization/deserialization algorithm should
 * work. You just need to ensure that a binary search tree can be serialized to
 * a string and this string can be deserialized to the original tree
 * structure.
 *
 *
 * The encoded string should be as compact as possible.
 *
 *
 *
 * Note: Do not use class member/global/static variables to store states. Your
 * serialize and deserialize algorithms should be stateless.
 *
 */

using System;
using System.Collections.Generic;
using System.Text;

/**
* Definition for a binary tree node.
* public class TreeNode {
*     public int val;
*     public TreeNode left;
*     public TreeNode right;
*     public TreeNode(int x) { val = x; }
* }
*/
namespace csharpSolution
{
    public class SerializeAndDeserializeBst
    {
        public string Temp;
        //Encodes a tree to a single string.
        public string serialize(TreeNode root)
        {
            if (root == null)
            {
                return string.Empty;
            }

            List<string> valList = new List<string>(100);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.Append(root.val + ",");
            Build_BST_Str(root, stringBuilder);
            return stringBuilder.ToString();
        }

        private void Build_BST_Str(TreeNode root, StringBuilder stringBuilder)
        {
            Queue<TreeNode> queue = new Queue<TreeNode>();
            queue.Enqueue(root);
            TreeNode nullNode = new TreeNode(0);
            while (queue.Count > 0)
            {
                int levelNodeCnt = queue.Count;

                bool hasValidNode = false;
                for (int i = 0; i < levelNodeCnt; i++)
                {

                    TreeNode node = queue.Dequeue();

                    if (node == nullNode)
                    {
                        stringBuilder.Append("N,N,");
                        queue.Enqueue(nullNode);
                        queue.Enqueue(nullNode);
                    }
                    else
                    {
                        if (node.left != null)
                        {
                            stringBuilder.Append(node.left.val + ",");
                            queue.Enqueue(node.left);
                            hasValidNode = true;

                        }
                        else
                        {
                            stringBuilder.Append("N,");
                            queue.Enqueue(nullNode);
                        }

                        if (node.right != null)
                        {
                            stringBuilder.Append(node.right.val + ",");
                            queue.Enqueue(node.right);
                            hasValidNode = true;

                        }
                        else
                        {
                            stringBuilder.Append("N,");
                            queue.Enqueue(nullNode);
                        }

                    }
                }

                if (!hasValidNode)
                {
                    break;
                }
            }
        }

        private void Build_BST_Str(TreeNode root, List<string> valList, int v)
        {
            while (valList.Count < v)
                valList.Add("N");

            if (v < valList.Count)
                valList[v] = root.val.ToString();
            else
                valList.Add(root.val.ToString());
            if (root.left != null)
            {
                Build_BST_Str(root.left, valList, v * 2 + 1);
            }

            if (root.right != null)
            {
                Build_BST_Str(root.right, valList, v * 2 + 2);
            }
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(string data)
        {
            if (data == null || data.Length == 0)
                return null;

            List<string> valList = new List<string>(data.Split(','));
            if (valList.Count == 0)
            {
                return null;
            }

            return build_BST(valList, 0);
        }

        private TreeNode build_BST(List<string> valList, int v)
        {
            if (v > valList.Count - 1)
            {
                return null;
            }

            if (valList[v].Equals("N", StringComparison.CurrentCultureIgnoreCase))
                return null;

            int val = int.Parse(valList[v]);
            TreeNode root = new TreeNode(val);
            root.left = build_BST(valList, v * 2 + 1);
            root.right = build_BST(valList,  v * 2 + 2);
            return root;
        }
    }

    // Your Codec object will be instantiated and called as such:
    // Codec codec = new Codec();
    // codec.deserialize(codec.serialize(root));
}
