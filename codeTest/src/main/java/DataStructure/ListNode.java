package DataStructure;

import javafx.scene.SubScene;

public class ListNode {
     private int val;
     public ListNode next;
     public ListNode(int x) { val = x; }

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
 }
