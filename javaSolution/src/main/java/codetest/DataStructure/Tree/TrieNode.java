package codetest.DataStructure.Tree;

import codetest.Utils.*;
public class TrieNode {
    public TrieNode[] children = new TrieNode[ConstantUtil.TrieNodeChildrenSize];
    public boolean isEnd;
    public boolean isContinue;

    public TrieNode()
    {
        isEnd = false;
        for (int i = 0; i < ConstantUtil.TrieNodeChildrenSize; i++)
        {
            children[i] = null;
        }
    }
}
