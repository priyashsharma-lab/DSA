/*Leetcode: 430. Flatten a Multilevel Doubly Linked List
Link: https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list */

// Using stack to store previous nodes TC- O(n) SC- O(n)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) 
    {
        if (head==null)
        {
            return head;
        }
        Stack<Node> st=new Stack<>();
        Node temp=head;
        Node dummy=new Node();
        Node tempD=dummy;
        while (temp!=null)
        {
            tempD.next=temp;
            temp.prev=tempD;
            tempD=tempD.next;
            if (temp.child!=null)
            {
                if (temp.next!=null)
                {
                    st.push(temp.next);
                }
                Node t=temp.child;
                temp.child=null;
                temp=t;
                continue;
            }
            if (temp.next==null && !st.empty())
            {
                temp=st.pop();
                continue;
            }
            temp=temp.next;
        }
        head.prev=null;
        return head;
    }
}

// with custom Stack TC- O(n) SC- O(n or k or 1) (Confusion) using prev of nodes which have child node , we have implemented our own stack 
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) 
    {
        if (head==null)
        {
            return head;
        }
        Node temp=head;
        Node dummy=new Node();
        Node stackDummy=new Node();
        Node tempS=stackDummy;
        Node tempD=dummy;
        while (temp!=null)
        {
            tempD.next=temp;
            temp.prev=tempD;
            tempD=tempD.next;
            if (temp.child!=null)
            {
                if (temp.next!=null)
                {
                    temp.next.prev=tempS;
                    tempS=temp.next;
                }
                Node t=temp.child;
                temp.child=null;
                temp=t;
                continue;
            }
            if (temp.next==null && tempS!=stackDummy)
            {
                temp=tempS;
                tempS=tempS.prev;
                continue;
            }
            temp=temp.next;
        }
        head.prev=null;
        return head;
    }
}

// Without stack TC ~ O(n^2) SC- O(1) 
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) 
    {
        if (head==null)
        {
            return head;
        }
        Node temp=head;
        boolean n=false;
        while (temp!=null)
        {
            if (temp.child!=null)
            {
                Node t=null;
                if (temp.next!=null)
                {
                    t=temp.next;
                }
                temp.next=temp.child;
                temp.next.prev=temp;
                Node d=temp.child;
                temp.child=null;
                temp=d;
                while (temp.next!=null)
                {
                    temp=temp.next;
                }
                if (t==null)
                {
                    temp=d;
                }
                else
                {
                    t.prev=temp;
                    temp.next=t;
                    temp=d;
                }
                continue;
            }
            temp=temp.next;
        }    
        return head;
    }
}