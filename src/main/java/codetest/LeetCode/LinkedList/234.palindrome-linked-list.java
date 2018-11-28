/*
 * [234] Palindrome Linked List
 *
 * https://leetcode.com/problems/palindrome-linked-list/description/
 *
 * algorithms
 * Easy (34.12%)
 * Total Accepted:    204.1K
 * Total Submissions: 592.2K
 * Testcase Example:  '[1,2]'
 *
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * Example 1:
 * 
 * 
 * Input: 1->2
 * Output: false
 * 
 * Example 2:
 * 
 * 
 * Input: 1->2->2->1
 * Output: true
 * 
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
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


// Input: 1->2->3->4->4->3->2->1
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null)
        {
            return true;
        }
        int cnt = 0;
        ListNode head1 = head;
        ListNode head2 = null;
        while(head1 != null)
        {
            ListNode tmp = new ListNode(head1.val);
            if (head2 != null)
            {
                tmp.next = head2;
            }
            head2 = tmp;
            head1 = head1.next;
        }

        while (head != null)
        {
            if (head.val != head2.val)
            {
                return false;
            }
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }


}
