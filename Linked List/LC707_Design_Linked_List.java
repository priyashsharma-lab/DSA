/*Leetcode: 707. Design Linked List
Link: https://leetcode.com/problems/design-linked-list/ */


class ListNode 
{
    int val;
    ListNode next;
    ListNode(int x) 
    {
        val = x;
        next = null;
    }
}
class MyLinkedList 
{
    private ListNode head;
    private ListNode endNode;
    public MyLinkedList() 
    {
        head=null;   
        endNode=null; 
    }
    
    public int get(int index) 
    {
        if (head==null)
        {
            return -1;
        }
        if (index==0)
        {
            return head.val;
        }
        ListNode temp=head;
        for (int i=0;i<index && temp!=null;i++)
        {
            temp=temp.next;
        }
        if (temp==null)
        {
            return -1;
        }
        return temp.val;
    }
    
    public void addAtHead(int val) 
    {
        if (head==null)
        {
            head=new ListNode(val);
            endNode=head;
        }    
        else
        {
            ListNode temp=head;
            head=new ListNode(val);
            head.next=temp;
        }
    }
    
    public void addAtTail(int val) 
    {
        if (head==null)
        {
            head=new ListNode(val);
            endNode=head;
            return;
        }
        endNode.next=new ListNode(val);
        endNode=endNode.next;
    }
    
    public void addAtIndex(int index, int val) 
    {
        if (index==0)
        {
            addAtHead(val);
            return;
        }
        ListNode temp=head;
        for (int i=0;i<index-1 && temp!=null;i++)
        {
            temp=temp.next;
        }    
        if (temp!=null)
        {
            ListNode t=temp.next;
            temp.next=new ListNode(val);
            temp.next.next=t;
        }
        if (temp==endNode)
        {
            endNode=endNode.next;
        }
    }
    
    public void deleteAtIndex(int index) 
    {
        if (head==null)
        {
            return;
        }
        if (index==0 && head.next==null)
        {
            head=null;
            endNode=null;
            return;
        }    
        if (index==0)
        {
            head=head.next;
            return;
        }
        ListNode temp=head;
        for (int i=0;i<index-1 && temp!=null;i++)
        {
            temp=temp.next;
        }
        if (temp==null || temp.next==null)
        {
            return;
        }
        if (temp.next==endNode)
        {
            endNode=temp;
        }
        temp.next=temp.next.next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
