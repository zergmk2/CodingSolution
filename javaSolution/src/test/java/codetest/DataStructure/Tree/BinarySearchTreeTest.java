package codetest.DataStructure.Tree;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTreeTest {

    @Test
    public void inorder() {
        BinarySearchTree tree = new BinarySearchTree(50);
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        String inorderStr = tree.inorder();
        System.out.println(inorderStr);
    }

    @Test
    public void delete() {
        BinarySearchTree tree = new BinarySearchTree(50);
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        String inorderStr = tree.inorder();
        System.out.println("Before delete:");
        System.out.println(inorderStr);

        tree.delete(20);
        System.out.println("After delete 20 :");
        inorderStr = tree.inorder();
        System.out.println(inorderStr);
        Assert.assertEquals("30->40->50->60->70->80", inorderStr);

        tree.delete(50);
        System.out.println("After delete 50 :");
        inorderStr = tree.inorder();
        System.out.println(inorderStr);

    }
}