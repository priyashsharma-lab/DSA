/*Leetcode: 237. Delete Node in a Linked List
Link: https://leetcode.com/problems/delete-node-in-a-linked-list/ */


// TC - O(k) where k is the number of nodes after node
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) 
    {
        ListNode prev=node;
        while (node.next!=null)  
        {
            node.val=node.next.val;
            prev=node;
            node=node.next;
        }
        prev.next=null;
    }
}

// O(1) sol 
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) 
    {
        node.val=node.next.val;
        node.next=node.next.next;
    }
}