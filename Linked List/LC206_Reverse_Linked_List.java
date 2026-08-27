/*Leetcode: 206. Reverse Linked List
Link: https://leetcode.com/problems/reverse-linked-list/ */

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
    public ListNode reverseList(ListNode head) 
    {
        if (head==null || head.next==null)
        {
            return head;
        }
        ListNode r=head.next;
        ListNode l=head;
        l.next=null;
        while (r!=null) 
        {
            ListNode temp1=r.next;
            ListNode temp2=r;
            r.next=l;
            r=temp1;
            l=temp2;
        }       
        return l;
    }
}

// Cleaner Solution 
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
    public ListNode reverseList(ListNode head) 
    {
        if (head==null || head.next==null)
        {
            return head;
        }
        ListNode r=head;
        ListNode l=null;
        while (r!=null) 
        {
            ListNode temp1=r.next;
            r.next=l;
            l=r;
            r=temp1;
        }       
        return l;
    }
}