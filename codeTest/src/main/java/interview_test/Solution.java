import java.util.*;

public class Solution {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public int bstDistance(int[] values, int n,
                           int node1, int node2)
    {
        // WRITE YOUR CODE HERE
        if (values == null || values.length == 0 || values.length < n)
        {
            return -1;
        }

        if ((indexof(values, n, node1) == -1) || (indexof(values, n, node2) == -1))
        {
            return -1;
        }

        TreeNode root = buildBST(values, n);
        if (node1 > node2)
        {
            return distanceBetween2nodes(root, node2, node1);
        }
        else
        {
            return distanceBetween2nodes(root, node1, node2);
        }
    }

    private int indexof(int[] values, int n, int val)
    {
        for (int i = 0; i < n ; i++)
        {
            if (values[i] == val)
            {
                return i;
            }
        }

        return  -1;
    }

    private int distanceBetween2nodes(TreeNode root, int node1, int node2)
    {
        if (root == null)
        {
            return 0;
        }

        if (root.val > node1 && root.val > node2)
        {
            return distanceBetween2nodes(root.left, node1, node2);
        }

        if (root.val < node1 && root.val < node2)
        {
            return distanceBetween2nodes(root.right, node1, node2);
        }

        if (root.val >= node1 && root.val <= node2)
        {
            return distanceFromRoot(root, node1) + distanceFromRoot(root, node2);
        }

        return 0;
    }

    private int distanceFromRoot(TreeNode root, int node)
    {
        if (root.val == node)
        {
            return 0;
        }
        else if (root.val > node)
        {
            return 1 + distanceFromRoot(root.left, node);
        }

        return 1 + distanceFromRoot(root.right, node);

    }


    private TreeNode buildBST(int[] values, int n)
    {
        TreeNode root = new TreeNode(values[0]);
        for (int i = 1; i < n; i++)
        {
            insert(root, values[i]);
        }
        return root;
    }

    private void insert(TreeNode root, int val)
    {
        if (root.val < val)
        {
            if (root.right != null)
            {
                insert(root.right, val);
            }
            else
            {
                root.right = new TreeNode(val);
            }
        }
        else if (root.val > val)
        {
            if (root.left != null)
            {
                insert(root.left, val);
            }
            else
            {
                root.left = new TreeNode(val);
            }
        }
    }

    public List<String> subStringsKDist(String inputStr, int num)
    {
        List<String> list = new ArrayList<>();
        Set<String> retSet = new HashSet<>();

        if (inputStr == null || inputStr.length() == 0)
        {
            return list;
        }

        int size = inputStr.length();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i <= size - num; i++)
        {
            set.clear();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < num; j++)
            {
                char c = inputStr.charAt(i + j);
                if (!set.add(c))
                {
                    break;
                }
                sb.append(c);
            }

            if (sb.length() == num)
            {
                retSet.add(sb.toString());
            }
        }

        for(String s : retSet)
        {
            list.add(s);
        }

        return list;
    }



    public static void main(String[] args)
    {
        int[] values = new int[] {5, 6, 3, 1, 2, 4};
        int [] values1 = new int[]{};
        Solution s = new Solution();
        int a = s.bstDistance(values, 6, 1, 2);
    }
}
