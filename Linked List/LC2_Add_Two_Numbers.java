/*Leetcode: 2. Add Two Numbers
Link: https://leetcode.com/problems/add-two-numbers/  */


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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        ListNode temp1=l1;
        ListNode temp2=l2;
        int c=0;
        ListNode ans=new ListNode();
        ListNode t=ans;
        while (temp1!=null || temp2!=null)
        {
            int sum=0;
            if (temp1!=null)
            {
                sum+=temp1.val;
            }
            if (temp2!=null)
            {
                sum+=temp2.val;
            }
            sum+=c;
            t.next=new ListNode();
            t=t.next;
            t.val=sum%10;
            c=sum/10;
            if (temp1!=null)
            {
                temp1=temp1.next;
            }
            if (temp2!=null)
            {
                temp2=temp2.next;
            }
        }    
        if (c!=0)
        {
            t.next=new ListNode(c);
        }
        return ans.next;
    }
}
