package codetest.DataStructure.Tree;

public class BinarySearchTree
{
    private TreeNode root;

    public BinarySearchTree(int value)
    {
        this.root = new TreeNode(value);
    }

    public TreeNode search(int value)
    {
        return search(this.root, value);
    }

    private TreeNode search(TreeNode root, int value)
    {
        if (root == null || root.val == value)
        {
            return root;
        }

        if (root.val > value)
        {
           return search(root.left, value);
        }

        return search(root.right, value);
    }

    public TreeNode searchParent(int value)
    {
        return searchParent(this.root, value);
    }

    private TreeNode searchParent(TreeNode root, int value)
    {
        if (root == null)
        {
            return root;
        }

        if (root.left != null && root.left.val == value)
            return root;

        if (root.right != null && root.right.val == value)
            return root;

        if (root.val > value)
        {
            return searchParent(root.left, value);
        }

        return searchParent(root.right, value);
    }

    public void insert(int value)
    {
        insert(this.root, value);
    }

    private void insert(TreeNode root, int value)
    {
        if (root.val > value)
        {
            if (root.left != null)
            {
                insert(root.left, value);
            }
            else
            {
                root.left = new TreeNode(value);
            }
        }
        else if (root.val < value)
        {
            if (root.right != null)
            {
                insert(root.right, value);
            }
            else
            {
                root.right = new TreeNode(value);
            }
        }
    }

    public String inorder()  {
        StringBuilder sb = new StringBuilder();
        inorderRec(root, sb);
        return sb.substring(0, sb.length() - 2);
    }

    // A utility function to do inorder traversal of BST 
    private void inorderRec(TreeNode root, StringBuilder sb) {
        if (root != null) {
            inorderRec(root.left, sb);
            sb.append(root.val);
            sb.append("->");
            inorderRec(root.right, sb);
        }
    }

    private TreeNode findMinNode(TreeNode root)
    {
        while (root.left != null)
        {
            root = root.left;
        }
        return root;
    }

    public void delete(int deleteValue)
    {
        if (this.root.val == deleteValue)
        {
            if (this.root.right != null)
            {
                TreeNode minNode = findMinNode(this.root.right);
                this.root.val = minNode.val;
                delete(this.root.right, minNode.val);
            }
            else
            {
                this.root = this.root.left;
            }
        }
        else {
            delete(this.root, deleteValue);
        }
    }

    private void delete(TreeNode root, int deleteValue)
    {
        if (root == null)
            return;
        TreeNode parent = searchParent(root, deleteValue);
        if (parent == null)
        {
            return;
        }
        TreeNode delNode = null;
        if (parent.left != null && parent.left.val == deleteValue)
        {
            delNode = parent.left;
        }
        else
        {
            delNode = parent.right;
        }

        delete(parent, delNode);
    }

    private void delete(TreeNode parent, TreeNode delNode)
    {
        // case 1. delNode is a leaf node
        if (delNode.left == null && delNode.right == null)
        {
            if (parent.left != null && parent.left.val == delNode.val)
            {
                parent.left = null;
            }
            else
            {
                parent.right = null;
            }
        }
        else if (delNode.left != null && delNode.right == null) {
        // case 2. delNode has only left leaf node
            delNode.val = delNode.left.val;
            delNode.left = null;
        }
        else
        {
        // case 3. delNode has right leaf node or has two leaves nodes
            TreeNode minNode = findMinNode(delNode.right);
            this.root.val = minNode.val;
            delete(delNode.right, minNode.val);
        }
    }
}
