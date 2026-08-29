/*Leetcode: 141. Linked List Cycle
Link: https://leetcode.com/problems/linked-list-cycle/ */


// USing HashSet TC- O(nlogn) SC- O(n)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class LC141_Linked_List_Cycle {
    public boolean hasCycle(ListNode head) 
    {
        HashSet<ListNode> s=new HashSet<>();
        ListNode temp=head;
        while (temp!=null)
        {
            if (s.contains(temp))
            {
                return true;
            }
            s.add(temp);
            temp=temp.next;
        }    
        return false;
    }
}


// Using fast and slow pointers
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    public boolean hasCycle(ListNode head) 
    {
        if (head==null || head.next==null)
        {
            return false;
        }    
        if (head.next==head)
        {
            return true;
        }
        ListNode fast=head;
        ListNode slow=head;
        while (fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if (fast==slow)
            {
                return true;
            }
        }
        return false;
    }
}