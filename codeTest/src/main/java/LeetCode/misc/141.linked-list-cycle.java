/*
 * [141] Linked List Cycle
 *
 * https://leetcode.com/problems/linked-list-cycle/description/
 *
 * algorithms
 * Easy (34.79%)
 * Total Accepted:    18997
 * Total Submissions: 41161
 * Testcase Example:  'null\nno cycle\n'
 *
 * Given a linked list, determine if it has a cycle in it.
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
        {
            return false;
        }

        ListNode walker = head;
        ListNode runner = head.next.next;
        while(walker.next != null && runner.next != null && runner.next.next != null)
        {
            if (walker == runner)
                return true;
            walker = walker.next;
            runner = runner.next.next;
        }
        return false;
    }
}
