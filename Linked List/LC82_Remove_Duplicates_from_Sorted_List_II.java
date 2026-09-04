/*Leetcode: 82. Remove Duplicates from Sorted List II
Link: https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/ */

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
    public ListNode deleteDuplicates(ListNode head) 
    {
        if (head==null || head.next==null)
        {
            return head;
        }
        ListNode l=head;
        ListNode r=head.next;
        ListNode dummy=new ListNode();
        ListNode tempD=dummy;
        while (r!=null)
        {
            if (l.val==r.val)
            {
                while (r!=null && l.val==r.val)
                {
                    r=r.next;
                }
                l=r;
            }
            else
            {
                tempD.next=l;
                tempD=tempD.next;
                l=r;
            }
            if (r!=null)
            {
                r=r.next;
            }
        }
        if (l!=null)
        {
            tempD.next=l;
        }
        else
        {
            tempD.next=null;
        }
        return dummy.next;
    }
}
