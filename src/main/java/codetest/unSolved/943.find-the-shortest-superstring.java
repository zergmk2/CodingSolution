/*
 * [980] Find the Shortest Superstring
 *
 * https://leetcode.com/problems/find-the-shortest-superstring/description/
 *
 * algorithms
 * Hard (26.94%)
 * Total Accepted:    1.2K
 * Total Submissions: 4.2K
 * Testcase Example:  '["alex","loves","leetcode"]'
 *
 * Given an array A of strings, find any smallest string that contains each
 * string in A as a substring.
 * 
 * We may assume that no string in A is substring of another string in A.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: ["alex","loves","leetcode"]
 * Output: "alexlovesleetcode"
 * Explanation: All permutations of "alex","loves","leetcode" would also be
 * accepted.
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: ["catg","ctaagt","gcta","ttca","atgcatc"]
 * Output: "gctaagttcatgcatc"
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= A.length <= 12
 * 1 <= A[i].length <= 20
 * 
 * 
 * 
 * 
 * 
 */

//class Solution {
//    class TrieNode
//    {
//        public static TrieNode root = new TrieNode();
//        TrieNode[] children;
//        // isEndOfWord is true if the node
//        // represents end of a word
//        boolean isEndOfWord;
//        public TrieNode
//        {
//            children = new TrieNode[ALPHABET_SIZE];
//
//            // isEndOfWord is true if the node represents
//            // end of a word
//            boolean isEndOfWord;
//
//            TrieNode(){
//                isEndOfWord = false;
//                for (int i = 0; i < ALPHABET_SIZE; i++)
//                    children[i] = null;
//            }
//        };
//
//        public void insert(String key)
//        {
//            int level;
//            int length = key.length();
//            int index;
//
//            TrieNode pCrawl = root;
//
//            for (level = 0; level < length; level++)
//            {
//                index = key.charAt(level) - 'a';
//                if (pCrawl.children[index] == null)
//                    pCrawl.children[index] = new TrieNode();
//
//                pCrawl = pCrawl.children[index];
//            }
//
//            // mark last node as leaf
//            pCrawl.isEndOfWord = true;
//        }
//    }
//
//    TrieNode root;
//    public String shortestSuperstring(String[] A) {
//        if (A == null || A.length == 0)
//        {
//            return "";
//        }
//
//        for (String s : A)
//        {
//            Create
//        }
//    }
//}
