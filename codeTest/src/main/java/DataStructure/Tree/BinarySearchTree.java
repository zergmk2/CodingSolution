package DataStructure.Tree;
import java.util.*;

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

    public void inorder()  {
        inorderRec(root);
    }

    // A utility function to do inorder traversal of BST 
    private void inorderRec(TreeNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.val);
            inorderRec(root.right);
        }
    }


}
