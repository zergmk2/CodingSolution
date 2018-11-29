package codetest.DataStructure.Tree;


public class Trie
{
    TrieNode root;

    public Trie()
    {
        root = new TrieNode();
    }

    public void insert(String str)
    {
        TrieNode cur = root;
        int level = str.length();
        int index = 0;
        for (int i = 0; i < level; i++)
        {
            index = str.charAt(i) - 'a';

            if (cur.children[index] == null)
            {
                cur.children[index] = new TrieNode();
            }

            cur = cur.children[index];
        }

        cur.isEnd = true;
    }

    public boolean search(String str)
    {
        TrieNode cur = root;
        int level = str.length();
        int index = 0;
        for (int i = 0; i < level; i++)
        {
            index = str.charAt(i) - 'a';

            if (cur.children[index] == null)
            {
                return false;
            }

            cur = cur.children[index];
        }

        if (cur == null || cur.isEnd == false)
            return false;
        else
            return true;
    }
}
