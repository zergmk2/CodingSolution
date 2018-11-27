import DataStructure.ListNode;
import DataStructure.Tree.BinarySearchTree;
import commonAlgorithum.sort.HeapSort;

public class Tester {
    public static void main(String[] args) {
        System.out.println("===========");
        int[] nums = new int[] {-2, 0, 3, -5, 2, -1};
//        NumArray n = new NumArray(nums);
//        n.sumRange(0,2);
//        n.sumRange(2,5);
//        n.sumRange(0,5);
//        Solution s = new Solution();
//        ListNode node = new ListNode(1);
//        ListNode root = node;
//        node.next = new ListNode(2);
//        node = node.next;
//        node.next = new ListNode(3);
//        node = node.next;
//        node.next = new ListNode(4);

////        s.splitListToParts(root, 5);
//        HeapSort heap = new HeapSort(nums, false);
//        heap.sort();
//        int[] sortedNums = heap.getHeapArray();

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
