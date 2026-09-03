/*Leetcode: 86. Partition List
Link: https://leetcode.com/problems/partition-list/ */

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
    public ListNode partition(ListNode head, int x) 
    {
        if (head==null || head.next==null)
        {
            return head;
        }
        ListNode less=new ListNode();
        ListNode more=new ListNode();
        ListNode t=more;
        ListNode u=less;
        ListNode temp=head;
        while (temp!=null)
        {
            if (temp.val<x)
            {
                less.next=temp;
                less=less.next;
            }
            else
            {
                more.next=temp;
                more=more.next;
            }
            temp=temp.next;
        }    
        less.next=t.next;
        more.next=null;
        return u.next;
    }
}