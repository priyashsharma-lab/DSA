/*Leetcode: 25. Reverse Nodes in k-Group
Link: https://leetcode.com/problems/reverse-nodes-in-k-group/ */

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
    public static ListNode kthNode(ListNode head,int k)
    {
        ListNode temp=head;
        int c=1;
        while (temp!=null && c<k)
        {
            c++;
            temp=temp.next;
        }
        return temp;
    }
    public static ListNode rev(ListNode head,int k)
    {
        ListNode l=null;
        ListNode r=head;
        for (int i=1;i<=k;i++)
        {
            ListNode t=r.next;
            r.next=l;
            l=r;
            r=t;
        }
        return l;
    }
    public ListNode reverseKGroup(ListNode head, int k) 
    {
        ListNode kNode=kthNode(head,k);
        ListNode t=kNode.next;
        ListNode temp=head;
        ListNode dummy=new ListNode(-1,null);
        ListNode tempD=dummy;
        while (kNode!=null)
        {
            t=kNode.next;
            tempD.next=rev(temp,k);
            tempD=temp;
            temp=t;
            kNode=kthNode(temp,k);
        }
        tempD.next=temp;
        return dummy.next;
    }
}