/*Leetcode: 21. Merge Two Sorted Lists
Link: https://leetcode.com/problems/merge-two-sorted-lists/*/


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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) 
    {
        if (list1==null && list2==null)
        {
            return null;
        }
        if (list1==null)
        {
            return list2;
        }
        if (list2==null)
        {
            return list1;
        }
        ListNode t1=list1;    
        ListNode t2=list2;    
        ListNode dummy=new ListNode(-1,null);
        ListNode temp=dummy;
        while (t1!=null && t2!=null)
        {
            if (t1.val<=t2.val)
            {  
                temp.next=t1;
                temp=temp.next;
                t1=t1.next;
            }
            else
            {
                temp.next=t2;
                temp=temp.next;
                t2=t2.next;
            }
        }
        if (t1==null)
        {
            temp.next=t2;
        }
        if (t2==null)
        {
            temp.next=t1;
        }
        return dummy.next;
    }
}
