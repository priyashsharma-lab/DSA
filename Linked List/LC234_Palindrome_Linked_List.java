/*Leetcode: 234. Palindrome Linked List
Link: https://leetcode.com/problems/palindrome-linked-list/ */

// Stack approach (O(2n))
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
    public boolean isPalindrome(ListNode head) 
    {
        ListNode temp=head;
        Stack<Integer> st=new Stack<>();
        while (temp!=null)
        {
            st.push(temp.val);
            temp=temp.next;
        }    
        temp=head;
        while (temp!=null)
        {
            if (temp.val!=st.pop())
            {
                return false;
            }
            temp=temp.next;
        }
        return true;
    }
}

// Using 2 pointers 
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
    public static ListNode rev(ListNode head)
    {
        if (head==null || head.next==null)
        {
            return head;
        }
        ListNode l=null;
        ListNode r=head;
        while (r!=null)
        {
            ListNode temp=r.next;
            r.next=l;
            l=r;
            r=temp;
        }
        return l;
    }
    public boolean isPalindrome(ListNode head) 
    {
        if (head==null || head.next==null)
        {
            return true;
        }
        ListNode fast=head;
        ListNode slow=head;
        while (fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        
        ListNode revHead=rev(slow.next);
        ListNode l=head;
        ListNode r=revHead;
        while (r!=null)
        {
            if (l.val!=r.val)
            {
                return false;
            }
            l=l.next;
            r=r.next;
        }
        rev(revHead);
        return true;
    }
}