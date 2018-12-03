/*
 * [725] Split Linked List in Parts
 *
 * https://leetcode.com/problems/split-linked-list-in-parts/description/
 *
 * algorithms
 * Medium (47.22%)
 * Total Accepted:    19.5K
 * Total Submissions: 40.8K
 * Testcase Example:  '[1,2,3,4]\n5'
 *
 * Given a (singly) linked list with head node root, write a function to split
 * the linked list into k consecutive linked list "parts".
 * 
 * The length of each part should be as equal as possible: no two parts should
 * have a size differing by more than 1.  This may lead to some parts being
 * null.
 * 
 * The parts should be in order of occurrence in the input list, and parts
 * occurring earlier should always have a size greater than or equal parts
 * occurring later.
 * 
 * Return a List of ListNode's representing the linked list parts that are
 * formed.
 * 
 * 
 * Examples
 * 1->2->3->4, k = 5 // 5 equal parts
 * [ [1],
 * [2],
 * [3],
 * [4],
 * null ]
 * 
 * Example 1:
 * 
 * Input: 
 * root = [1, 2, 3], k = 5
 * Output: [[1],[2],[3],[],[]]
 * Explanation:
 * The input and each element of the output are ListNodes, not arrays.
 * For example, the input root has root.val = 1, root.next.val = 2,
 * \root.next.next.val = 3, and root.next.next.next = null.
 * The first element output[0] has output[0].val = 1, output[0].next = null.
 * The last element output[4] is null, but it's string representation as a
 * ListNode is [].
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: 
 * root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
 * Output: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
 * Explanation:
 * The input has been split into consecutive parts with size difference at most
 * 1, and earlier parts are a larger size than the later parts.
 * 
 * 
 * 
 * Note:
 * The length of root will be in the range [0, 1000].
 * Each value of a node in the input will be an integer in the range [0, 999].
 * k will be an integer in the range [1, 50].
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
package codetest.LeetCode.LinkedList;
import codetest.DataStructure.ListNode;


public class SplitListToParts_725 {
    public ListNode[] splitListToParts(ListNode root, int k) {
        if (k == 0)
        {
            return new ListNode[0];
        }

        ListNode[] nodes = new ListNode[k];
        int n = getLength(root);

        int div = n / k;
        int mod = n % k;
        System.out.print("div : " + div);
        System.out.print("mod : " + mod);
        ListNode cur = root;
        int index = 0;
        if (mod > 0)
        {
            for (int i = 0; i < mod; i++)
            {
                ListNode newHead = cur;
                ListNode pre = null;
                int subListCnt = div + 1;
                while (subListCnt != 0 && root != null)
                {
                    pre = cur;
                    if (cur.next != null)
                        cur = cur.next;
                    subListCnt--;
                }
                pre.next = null;
                nodes[index++] = newHead;
            }
        }

        if (div > 0)
        {
            for (int i = 0; i < k - mod; i++)
            {
                ListNode newHead = cur;
                ListNode pre = null;
                int subListCnt = div;
                while (subListCnt != 0 && root != null)
                {
                    pre = cur;
                    if (cur.next != null)
                        cur = cur.next;
                    subListCnt--;
                }
                pre.next = null;
                nodes[index++] = newHead;
            }
        }

        return nodes;
    }

    private ListNode getSubLinkedList(ListNode root, int subListCnt)
    {
        ListNode head = root;
        ListNode pre = null;
        while (subListCnt != 0 || root != null)
        {
            pre = root;
            if (root.next != null)
                root = root.next;
            
        }
        pre.next = null;
        return head;
    }

    private int getLength(ListNode root)
    {
        ListNode head = root;

        int cnt = 0;
        while (head != null)
        {
            cnt++;
            head = head.next;
        }
        return cnt;
    }
}
