/*Leetcode: 92. Reverse Linked List II
Link: https://leetcode.com/problems/reverse-linked-list-ii/ */

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
    public static ListNode[] rev(ListNode head,int n)
    {
        ListNode l=head;
        ListNode r=head.next;
        l.next=null;
        ListNode t=null;
        for (int i=0;i<n;i++)
        {
            t=r.next;
            r.next=l;
            l=r;
            r=t;
        }
        return new ListNode[]{l,t};
    }
    public ListNode reverseBetween(ListNode head, int left, int right) 
    {
        if (head==null || head.next==null)
        {
            return head;
        }
        if (left==right)
        {
            return head;
        }
        ListNode temp=head;
        if (left==1)
        {
            ListNode[] revData=rev(temp,right-left);
            head.next=revData[1];
            head=revData[0];
            return head;
        }
        for (int i=1;i<left-1;i++)
        {
            temp=temp.next;
        }    
        ListNode last=temp.next;
        ListNode[] revData=rev(temp.next,right-left);
        temp.next=revData[0];
        last.next=revData[1];
        return head;
    }
}
