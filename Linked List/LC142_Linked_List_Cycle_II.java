/*Leetcode: 142. Linked List Cycle II
Link: https://leetcode.com/problems/linked-list-cycle-ii/ */

// Using HashSet TC- O(nlogn) SC- O(n)
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
class LC142_Linked_List_Cycle_II {
    public ListNode detectCycle(ListNode head) 
    {
        HashSet<ListNode> s=new HashSet<>();
        ListNode temp=head;
        while (temp!=null)
        {
            if (s.contains(temp))
            {
                return temp;
            }
            s.add(temp);
            temp=temp.next;
        }    
        return null;    
    }
}


// Using slow and fast pointers
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
    public ListNode detectCycle(ListNode head) 
    {
        if (head==null || head.next==null)
        {
            return null;
        }    
        if (head.next==head)
        {
            return head;
        }
        ListNode fast=head;
        ListNode slow=head;
        while (fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if (fast==slow)
            {
                slow=head;
                while (slow!=fast)
                {
                    slow=slow.next;
                    fast=fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}