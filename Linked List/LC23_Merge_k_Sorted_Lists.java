/*Leetcode: 23. Merge k Sorted Lists
Link: https://leetcode.com/problems/merge-k-sorted-lists/ */

// Brute force TC - O(n^2) 
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
    public static ListNode merge(ListNode l1,ListNode l2)
    {
        ListNode t1=l1;
        ListNode t2=l2;
        ListNode dummy=new ListNode();
        ListNode tempD=dummy;
        while (t1!=null && t2!=null)
        {
            if (t1.val<=t2.val)
            {
                tempD.next=t1;
                t1=t1.next;
                tempD=tempD.next;
            }
            else
            {
                tempD.next=t2;
                t2=t2.next;
                tempD=tempD.next;
            }
        }
        if (t1==null)
        {
            tempD.next=t2;
        }
        else
        {
            tempD.next=t1;
        }
        return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists) 
    {
        if (lists.length==0)
        {
            return null;
        }
        if (lists.length==1 && lists[0]!=null)
        {
            return lists[0];
        }
        ListNode dummy=new ListNode();
        dummy.next=lists[0];
        for (int i=1;i<lists.length;i++)
        {
            dummy.next=merge(dummy.next,lists[i]);
        }
        return dummy.next;
    }
}

// Using Priority Queue 
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
    public ListNode mergeKLists(ListNode[] lists) 
    {
        if (lists.length==0)
        {
            return null;
        }
        if (lists.length==1 && lists[0]!=null)
        {
            return lists[0];
        }
        if (lists.length==1 && lists[0]==null)
        {
            return null;
        }
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));    
        ListNode dummy=new ListNode();
        ListNode tempD=dummy;
        for (int i=0;i<lists.length;i++)
        {
            if (lists[i]!=null)
            {
                pq.add(lists[i]);
            }
        }
        while (!pq.isEmpty())
        {
            tempD.next=pq.poll();
            tempD=tempD.next;
            if (tempD.next!=null)
            {
                pq.add(tempD.next);
            }
        }
        return dummy.next;
    }
}