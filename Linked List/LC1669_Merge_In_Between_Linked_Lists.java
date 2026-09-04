/*Leetcode: 1669. Merge In Between Linked Lists
Link: https://leetcode.com/problems/merge-in-between-linked-lists/ */

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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) 
    {
        ListNode tempA=list1;
        ListNode tempB=list1;
        while (tempA!=null && tempB!=null && b>=0)
        {
            if (a>1)
            {
                tempA=tempA.next;
                a--;
            }
            if (b>=0)
            {
                tempB=tempB.next;
                b--;
            }
        }    
        tempA.next=list2;
        while (tempA.next!=null)
        {
            tempA=tempA.next;
        }
        tempA.next=tempB;
        return list1;
    }
}

// Same approach different code 
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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) 
    {
        ListNode tempA=list1;
        int i=b-a+1;
        while (tempA!=null && a>1)
        {
            tempA=tempA.next;
            a--;
        }    
        ListNode tempB=tempA.next;;
        tempA.next=list2;
        tempA=tempA.next;
        while (tempA.next!=null || i>0)
        {
            if (tempB!=null && i>0)
            {
                tempB=tempB.next;
                i--;
            }
            if (tempA.next!=null)
            {
                tempA=tempA.next;
            }
        }
        tempA.next=tempB;
        return list1;
    }
}