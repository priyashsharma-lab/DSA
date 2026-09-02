/*Leetcode: 138. Copy List with Random Pointer
Link: https://leetcode.com/problems/copy-list-with-random-pointer/ */

//Using 2 hashmaps 
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) 
    {
        if (head==null)
        {
            return head;
        }
        Node temp=head;
        Node dummy=new Node(-1);
        Node tempD=dummy;
        HashMap<Integer,Node> ds=new HashMap<>();
        HashMap<Node,Integer> ts=new HashMap<>();
        int idx=0;
        while (temp!=null)
        {
            tempD.next=new Node(temp.val);
            tempD=tempD.next;
            ds.put(idx,tempD);
            ts.put(temp,idx);
            temp=temp.next;
            idx++;
        }
        temp=head;
        tempD=dummy.next;
        while (temp!=null)
        {
            if (temp.random==null)
            {
                tempD.random=null;
            }
            else
            {
                idx=ts.get(temp.random);
                tempD.random=ds.get(idx);
            }
            tempD=tempD.next;
            temp=temp.next;
        }
        return dummy.next;
    }
}

// using 1 hashmap
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) 
    {
        if (head==null)
        {
            return head;
        }
        Node temp=head;
        Node dummy=new Node(-1);
        Node tempD=dummy;
        HashMap<Node,Node> s=new HashMap<>();
        while (temp!=null)
        {
            tempD.next=new Node(temp.val);
            tempD=tempD.next;
            s.put(temp,tempD);
            temp=temp.next;
        }
        temp=head;
        tempD=dummy.next;
        while (temp!=null)
        {
            if (temp.random==null)
            {
                tempD.random=null;
            }
            else
            {
                tempD.random=s.get(temp.random);
            }
            tempD=tempD.next;
            temp=temp.next;
        }
        return dummy.next;
    }
}

// Without HashMap
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) 
    {
        if (head==null)
        {
            return head;
        }
        Node temp=head;
        Node dummy=new Node(-1);
        Node tempD=dummy;
        while (temp!=null)
        {
            Node t=temp.next;
            temp.next=new Node(temp.val);
            temp.next.next=t;
            temp=temp.next.next;
        }    
        temp=head;
        Node t=head.next;
        while (temp!=null)
        {
            if (temp.random==null)
            {
                t.random=null;
            }
            else
            {
                t.random=temp.random.next;
            }
            if (t.next!=null)
            {
                t=t.next.next;
            }
            temp=temp.next.next;
        }
        temp=head;
        tempD.next=head.next;
        tempD=tempD.next;
        while (temp!=null)
        {
            temp.next=temp.next.next; 

            if (tempD.next!=null)
            {
                tempD.next=tempD.next.next; 
            }

            temp=temp.next; 

            if (tempD.next!=null)
            {
                tempD=tempD.next;
            }
        }
        return dummy.next;
    }
}