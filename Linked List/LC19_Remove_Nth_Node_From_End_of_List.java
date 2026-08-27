/*Leetcode: 19. Remove Nth Node From End of List
Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/ */

// Using dummy node
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
    public ListNode removeNthFromEnd(ListNode head, int n) 
    {
        if (head==null || (head.next==null && n==1))
        {
            return null;
        }
        ListNode dummy=new ListNode(0,head);
        ListNode fast=dummy;
        for (int i=1;i<=n && fast.next!=null;i++)
        {
            fast=fast.next;
        }    
        ListNode slow=dummy;
        while (fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next;
        }
        // if (slow.next==head)
        // {
        //     return slow.next.next;
        // } just return dummy.next
        slow.next=slow.next.next;
        // return head;
        return dummy.next;
    }
}

// Cleaner code 

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
    public ListNode removeNthFromEnd(ListNode head, int n) 
    {
        if (head==null || (head.next==null && n==1))
        {
            return null;
        }
        ListNode fast=head;
        for (int i=0;i<n;i++)
        {
            fast=fast.next;
        }    
        if (fast==null)
        {
            return head.next;
        }
        ListNode slow=head;
        while (fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;
        return head;
    }
}

// Recursive Approach
public class Solution
{
    public static Node reverseLinkedList(Node head)
    {
        if (head == null || head.next == null) {
            return head;
        }

        Node newHead = reverseLinkedList(head.next);
        Node front = head.next;

        front.next = head;
        head.next = null;

        return newHead;
    }
}