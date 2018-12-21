/*
 * [21] Merge Two Sorted Lists
 *
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (42.66%)
 * Total Accepted:    389.6K
 * Total Submissions: 912.9K
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * Example:
 * 
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 * 
 * 
 */

import java.util.List;

//import DataStructure.ListNode;
 class ListNode {
     public int val;

     public ListNode next;

     public ListNode(int x) { val = x; }

     public ListNode()
     {

     }

     public int getVal() {
         return val;
     }

     public void setVal(int val) {
         this.val = val;
     }

     public void traverse()
     {
         ListNode l = this;
         while (l != null)
         {
             System.out.print(val);
             l = l.next;
             if (l != null)
             {
                 System.out.print("->");
             }
         }
     }

     public static ListNode deserialize(String l)
     {
         if (l.length() == 2)
             return null;
//         List<ListNode> ListArray = new ArrayList<>();
//         String lines[] = s.split("\\r?\\n");
//         for (String l : lines)
//         {
         String tmp = l.substring(1, l.length() - 1);
         String[] numbers = tmp.split(",");
         ListNode tail = null;
         ListNode head = null;
         if (numbers.length > 0) {
             for (int i = numbers.length - 1; i >= 0; i--) {
                 head = new ListNode(Integer.parseInt(numbers[i].trim()));
                 if (tail != null) {
                     head.next = tail;
                     tail = head;
                 } else {
                     tail = head;
                 }
             }
         }
//                ListArray.add(head);
//             }
//         }

         return head;
     }
 }
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null)
        {
            return null;
        }

        if (l1 == null)
        {
            return l2;
        }

        if (l2 == null)
        {
            return l1;
        }


        ListNode result = new ListNode();
        ListNode head = result;
        head.next = result;
        if (l1.getVal() < l2.getVal())
        {
            result.next = l1;
            result = result.next;
            l1 = l1.next;
        }
        else
        {
            result.next = l2;
            result = result.next;
            l2 = l2.next;
        }

        while (l1 != null && l2 != null)
        {
            if (l1.getVal() < l2.getVal())
            {
                result.next = l1;
                result = result.next;
                l1 = l1.next;
            }
            else
            {
                result.next = l2;
                result = result.next;
                l2 = l2.next;
            }
        }

        if (l1 != null)
            result.next = l1;
        else if (l2 != null)
            result.next = l2;

        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.deserialize("[1, 2, 4]");
        ListNode l2 = ListNode.deserialize("[1, 3, 4]");

        Solution s = new Solution();
        ListNode l = s.mergeTwoLists(l1, l2);
    }

}
