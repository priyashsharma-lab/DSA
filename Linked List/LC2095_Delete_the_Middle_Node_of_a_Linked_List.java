/*Leetcode: 2095. Delete the Middle Node of a Linked List
Link: https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/ */

// Using slowPrev node 
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
    public ListNode deleteMiddle(ListNode head) 
    {
        if (head==null || head.next==null)
        {
            return null;
        }
        ListNode fast=head;
        ListNode slow=head;
        ListNode slowPrev=null;
        while (fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            slowPrev=slow;
            slow=slow.next;
        }
        slowPrev.next=slow.next;
        slow.next=null;
        return head;    
    }
}

// Optimized code without using extra node
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
    public ListNode deleteMiddle(ListNode head) 
    {
        if (head==null || head.next==null)
        {
            return null;
        }
        ListNode slow=head;
        ListNode fast=head;
        fast=fast.next.next;
        while (fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return head;    
    }
}
