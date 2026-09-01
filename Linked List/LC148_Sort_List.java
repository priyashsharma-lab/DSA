/*Leetcode: 148. Sort List
Link: https://leetcode.com/problems/sort-list/ */

//Using merge sort
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
    public static ListNode merge(ListNode lhead,ListNode rhead)
    {
        ListNode l=lhead;
        ListNode r=rhead;
        ListNode dummy=new ListNode();
        ListNode tempD=dummy;
        while (l!=null && r!=null)
        {
            if (l.val<=r.val)
            {
                tempD.next=l;
                l=l.next;
                tempD=tempD.next;
            }
            else
            {
                tempD.next=r;
                r=r.next;
                tempD=tempD.next;
            }
        }
        while (l!=null)
        {
            tempD.next=l;
            l=l.next;
            tempD=tempD.next;
        }
        while (r!=null)
        {
            tempD.next=r;
            r=r.next;
            tempD=tempD.next;
        }
        return dummy.next;
    }
    public static ListNode mergeSort(ListNode head)
    {
        if (head==null || head.next==null)
        {
            return head;
        }
        ListNode fast=head.next;
        ListNode slow=head;
        while (fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode lhead=head;
        ListNode rhead=slow.next;
        slow.next=null;
        lhead=mergeSort(lhead);
        rhead=mergeSort(rhead);
        return merge(lhead,rhead);
    }
    public ListNode sortList(ListNode head) 
    {
        return mergeSort(head);    
    }
}
