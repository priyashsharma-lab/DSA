/*Leetcode: 61. Rotate List
Link: https://leetcode.com/problems/rotate-list/ */


// Brute Force TC- O(n^2) SC- O(1)
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
    public ListNode rotateRight(ListNode head, int k) 
    {
        if (head==null || head.next==null || k==0) 
        {
            return head;
        }
        ListNode temp=head;
        int n=0;
        while (temp!=null)
        {
            n++;
            temp=temp.next;
        }
        for (int i=1;i<=k%n;i++)
        {
            temp=head;
            while (temp.next.next!=null)
            {
                temp=temp.next;
            }
            temp.next.next=head;
            head=temp.next;
            temp.next=null;
        }    
        return head;
    }
}

//Efficient soln TC-O(2n) SC-O(1)
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
    public ListNode rotateRight(ListNode head, int k) 
    {
        if (head==null || head.next==null || k==0) 
        {
            return head;
        }
        ListNode temp1=head;
        int n=1;
        while (temp1.next!=null)
        {
            n++;
            temp1=temp1.next;
        }
        if (k%n==0)
        {
            return head;
        }
        ListNode temp2=head;
        for (int i=1;i<n-(k%n);i++)
        {
            temp2=temp2.next;
        }
        temp1.next=head;
        head=temp2.next;
        temp2.next=null;
        return head;
    }
}
