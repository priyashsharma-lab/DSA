/*Leetcode: 160. Intersection of Two Linked Lists
Link: https://leetcode.com/problems/intersection-of-two-linked-lists/ */

// Brute Force
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) 
    {
        ListNode i=headA;
        while (i!=null)
        {
            ListNode j=headB;   
            while (j!=null)
            {
                if (i==j)
                {
                    return i;
                }
                j=j.next;
            }
            i=i.next;
        }
        return null;
    }
}

// Using HashSet 
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) 
    {
        HashSet<ListNode> s=new HashSet<>();
        ListNode temp=headA;
        while (temp!=null)
        {
            s.add(temp);
            temp=temp.next;
        }    
        temp=headB;
        while (temp!=null)
        {
            if (s.contains(temp))
            {
                return temp;
            }
            temp=temp.next;
        }
        return null;
    }
}

// TC- O(3n) and SC- O(1) solution without hashset
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) 
    {
        ListNode tA=headA;
        ListNode tB=headB;
        int cA=0;
        int cB=0;
        while (tA!=null && tB!=null)
        {
            cA++;
            cB++;
            tA=tA.next;
            tB=tB.next;
        }    
        while (tA!=null)
        {
            cA++;
            tA=tA.next;
        }
        while (tB!=null)
        {
            cB++;
            tB=tB.next;
        }

        tA=headA;
        tB=headB;
        if (cA>cB)
        {
            for (int i=1;i<=cA-cB;i++)
            {
                tA=tA.next;
            }
        }
        else
        {
            for (int i=1;i<=cB-cA;i++)
            {
                tB=tB.next;
            }
        }
        while (tA!=null && tB!=null)
        {
            if (tA==tB)
            {
                return tA;
            }
            tA=tA.next;
            tB=tB.next;
        }
        return null;
    }
}

//Most Optimal Solution 
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode tA = headA;
        ListNode tB = headB;

        while (tA != tB) {
            
            if (tA == null)
                tA = headB;
            else
                tA = tA.next;

            if (tB == null)
                tB = headA;
            else
                tB = tB.next;
        }

        return tA;
    }
}