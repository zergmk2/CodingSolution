package test;

import DataStructure.Tree.BinarySearchTree;


class BinarySearchTreeTest {
    public void BinarySearchTreeUnitTest()
    {
        BinarySearchTree tree = new BinarySearchTree(50);
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        tree.inorder();
    }
}