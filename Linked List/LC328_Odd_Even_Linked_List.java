/*Leetcode: 328. Odd Even Linked List
Link: https://leetcode.com/problems/odd-even-linked-list/ */

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
    public ListNode oddEvenList(ListNode head) 
    {
        if (head == null || head.next == null)
        {
            return head;
        }
        ListNode x=head.next;
        ListNode o=head;
        ListNode e=head.next;
        while (o.next!=null && e.next!=null)
        {
            o.next=e.next;
            o=e.next;
            if (o.next!=null)
            {
                e.next=o.next;
                e=o.next;
            }
        }
        o.next=x;
        e.next=null;
        return head;
    }
}