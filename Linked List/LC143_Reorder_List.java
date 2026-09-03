/*Leetcode: 143. Reorder List
Link: http://leetcode.com/problems/reorder-list/ */

//Using stack
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
    public void reorderList(ListNode head) 
    {
        if (head==null || head.next==null)
        {
            return;
        }
        Stack<ListNode> st=new Stack<>();
        ListNode dummy=new ListNode();
        ListNode tempD=dummy;
        ListNode temp=head;
        while (temp!=null)
        {
            st.push(temp);
            temp=temp.next;
        }    
        temp=head;
        tempD.next=temp;
        tempD=tempD.next;
        temp=temp.next;
        while (temp!=null)
        {
            ListNode t=st.pop();
            if (temp==t)
            {
                temp.next=null;
                break;
            }
            if (tempD==t)
            {
                tempD.next=null;
                break;
            }
            tempD.next=t;
            tempD.next.next=temp;
            tempD=temp;
            temp=temp.next;
        }
    }
}
// Withour Stack
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
    public void reorderList(ListNode head) 
    {
        if (head==null || head.next==null)
        {
            return;
        }
        ListNode slow=head;
        ListNode fast=head;
        while (fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode l=slow;
        ListNode r=slow.next;
        while (r!=null)
        {
            ListNode t=r.next;
            r.next=l;
            l=r;
            r=t;
        }

        ListNode temp=head;
        while (temp!=l)
        {
            ListNode t=temp.next;
            temp.next=l;
            temp=t;

            if (temp==l)
            {
                break;
            }

            t=l.next;
            l.next=temp;
            l=t;
        }
        temp.next=null;
    }
}