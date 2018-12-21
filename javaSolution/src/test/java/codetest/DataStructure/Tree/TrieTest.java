package codetest.DataStructure.Tree;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrieTest {

    @Test
    public void search() {

        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their"};
        String output[] = {"Not present in trie", "Present in trie"};

        Trie root = new Trie();

        // Construct trie
        int i;
        for (i = 0; i < keys.length ; i++)
            root.insert(keys[i]);

        Assert.assertEquals(root.search("the"), true);
        Assert.assertEquals(root.search("these"), false);
        Assert.assertEquals(root.search("their"), true);
        Assert.assertEquals(root.search("thaw"), false);

        if(root.search("the") == true)
            System.out.println("the --- " + output[1]);
        else System.out.println("the --- " + output[0]);

        if(root.search("these") == true)
            System.out.println("these --- " + output[1]);
        else System.out.println("these --- " + output[0]);

        if(root.search("their") == true)
            System.out.println("their --- " + output[1]);
        else System.out.println("their --- " + output[0]);

        if(root.search("thaw") == true)
            System.out.println("thaw --- " + output[1]);
        else System.out.println("thaw --- " + output[0]);
    }
}