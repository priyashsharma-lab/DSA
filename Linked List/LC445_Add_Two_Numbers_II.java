/*Leetcode: 445. Add Two Numbers II
Link: https://leetcode.com/problems/add-two-numbers-ii/ */

// By reversing the list and using old logic
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public static ListNode rev(ListNode head)
    {
        ListNode l=null;
        ListNode r=head;
        while (r!=null)
        {
            ListNode t=r.next;
            r.next=l;
            l=r;
            r=t;
        }
        return l;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        l1=rev(l1);
        l2=rev(l2);
        ListNode t1=l1;
        ListNode t2=l2;
        ListNode dummy=new ListNode();
        ListNode tempD=dummy;
        int c=0;
        while (t1!=null || t2!=null)
        {
            int n1=(t1!=null)?t1.val:0;
            int n2=(t2!=null)?t2.val:0;
            tempD.next=new ListNode((n1+n2+c)%10);
            c=(n1+n2+c)/10;
            tempD=tempD.next;
            
            t1=t1!=null?t1.next:null;
            t2=t2!=null?t2.next:null;
        }
        if (c>0)
        {
            tempD.next=new ListNode(c);
        }
        dummy.next=rev(dummy.next);
        // rev(l1);
        // rev(l2);
        return dummy.next;
    }
}

// Can Also be done using stack