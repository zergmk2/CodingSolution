/*
 * [838] Design Linked List
 *
 * https://leetcode.com/problems/design-linked-list/description/
 *
 * algorithms
 * Easy (14.29%)
 * Total Accepted:    4.3K
 * Total Submissions: 29.7K
 * Testcase Example:  '["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]\n[[],[1],[3],[1,2],[1],[1],[1]]'
 *
 * Design your implementation of the linked list. You can choose to use the
 * singly linked list or the doubly linked list. A node in a singly linked list
 * should have two attributes: val and next. val is the value of the current
 * node, and next is a pointer/reference to the next node. If you want to use
 * the doubly linked list, you will need one more attribute prev to indicate
 * the previous node in the linked list. Assume all nodes in the linked list
 * are 0-indexed.
 * 
 * Implement these functions in your linked list class:
 * 
 * 
 * get(index) : Get the value of the index-th node in the linked list. If the
 * index is invalid, return -1.
 * addAtHead(val) : Add a node of value val before the first element of the
 * linked list. After the insertion, the new node will be the first node of the
 * linked list.
 * addAtTail(val) : Append a node of value val to the last element of the
 * linked list.
 * addAtIndex(index, val) : Add a node of value val before the index-th node in
 * the linked list. If index equals to the length of linked list, the node will
 * be appended to the end of linked list. If index is greater than the length,
 * the node will not be inserted.
 * deleteAtIndex(index) : Delete the index-th node in the linked list, if the
 * index is valid.
 * 
 * 
 * Example:
 * 
 * 
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
 * linkedList.get(1);            // returns 2
 * linkedList.deleteAtIndex(1);  // now the linked list is 1->3
 * linkedList.get(1);            // returns 3
 * 
 * 
 * Note:
 * 
 * 
 * All values will be in the range of [1, 1000].
 * The number of operations will be in the range of [1, 1000].
 * Please do not use the built-in LinkedList library.
 * 
 */

class MyLinkedList {
    private static MyLinkedList prehead = new MyLinkedList();
    private static MyLinkedList tail;
    private static int size = 0;
    private int val;
    public MyLinkedList next;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        next = null;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index + 1 > size || index < 0) {
            return -1;
        }

        MyLinkedList indexnode = prehead.next;
        while (index > 0) {
            indexnode = indexnode.next;
            index--;
        }
        return indexnode.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        MyLinkedList newhead = new MyLinkedList();
        newhead.val = val;
        if (size == 0) {
            tail = newhead;
            prehead.next = newhead;
        } else {
            newhead.next = prehead.next;
            prehead.next = newhead;
        }
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        MyLinkedList newtail = new MyLinkedList();
        newtail.val = val;
        tail.next = newtail;
        tail = newtail;
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > size || index < 0) {
            return;
        }

        if (index == 0) {
            addAtHead(val);
            return;
        }

        if (index == size)
        {
            addAtTail(val);
            return;
        }

        MyLinkedList indexnode = prehead.next;
        while (index > 1) {
            indexnode = indexnode.next;
            index--;
        }

        MyLinkedList newnode = new MyLinkedList();
        newnode.val = val;

        newnode.next = indexnode.next;
        indexnode.next = newnode;
        size++;

    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index + 1 > size || index < 0) {
            return;
        }


        if (index == 0) {
            if (size == 1) {
                prehead.next = null;
                tail = null;
            } else {
                prehead.next = prehead.next.next;
            }
            size--;
            return;
        }

        MyLinkedList prenode = prehead.next;
        while (index > 1) {
            prenode = prenode.next;
            index--;
        }

        if (index + 1 == size) {
            tail = prenode;
            prenode.next = null;
        } else {
            MyLinkedList indexnext_node = prenode.next.next;
            prenode.next = indexnext_node;
        }
        size--;
    }

//    public static void main(String[] args)
//    {
//        MyLinkedList linkedList = new MyLinkedList();
//        linkedList.addAtHead(1);
//        linkedList.addAtIndex(1,2);
//        linkedList.get(1);
//        linkedList.get(0);
//        linkedList.get(2);
//    }
}
/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
