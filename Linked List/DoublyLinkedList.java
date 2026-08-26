class Node
{
    public int data;
    public Node next;
    public Node back;
    public Node(int data,Node next,Node back) 
    {
        this.data=data;
        this.next=next;
        this.back=back;
    }
    public Node(int data)
    {
        this.data=data;
        next=null;
    }
    
}

public class DoublyLinkedList 
{
    public static Node arrayToDLinkedList(int[] a)
    {
        if (a==null || a.length==0)
        {
            return null;
        }
        Node head=new Node(a[0]);
        Node prev=head;
        for (int i=1;i<a.length;i++)
        {
            Node temp=new Node(a[i]);
            temp.back=prev;
            prev.next=temp;
            prev=temp;
        }
        return head;
    }    
    public static void traverseLinkedList(Node head)
    {
        Node temp=head;
        while (temp!=null)
        {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }   
    public static int lengthOfLinkedList(Node head)
    {
        int count=0;
        Node temp=head;
        while (temp!=null)
        {
            count++;
            temp=temp.next;
        }
        return count;
    }
    public static Node deleteAtHead(Node head)
    {
        if (head==null || head.next==null)
        {
            return null;
        }
        head.next.back=null;
        return head.next;
    }
    public static Node deleteAtTail(Node head)
    {
        if (head==null || head.next==null)
        {
            return null;
        }
        Node temp=head;
        while (temp.next!=null)
        {
            temp=temp.next;
        }
        temp.back.next=null;
        temp.back=null;
        return head;
    }
    public static Node deleteAtK(Node head,int k)
    {
        if (head==null || k<=0)
        {
            return head;
        }
        if (k==1)
        {
            if (head.next==null)
            {
                return null;
            }
            head.next.back=null;
            return head.next;
        }
        Node temp=head;
        for (int i=1;i<k && temp!=null;i++)
        {
            temp=temp.next;
        }
        if (temp==null)
        {
            return head;
        }
        if (temp.next==null)
        {
            temp.back.next=null;
            temp.back=null;
            return head;
        }
        temp.next.back=temp.back;
        temp.back.next=temp.next;
        temp.next=null;
        temp.back=null;
        return head;
    }
    public static Node deleteAtNode(Node head,int val)
    {
        if (head==null)
        {
            return head;
        }
        Node temp=head;
        while (temp!=null && temp.data!=val)
        {
            temp=temp.next;
        }
        if (temp==null)
        {
            return head;
        }
        if (temp.next==null)
        {
            temp.back.next=null;
            temp.back=null;
            return head;
        }
        temp.next.back=temp.back;
        temp.back.next=temp.next;
        temp.next=null;
        temp.back=null;
        return head;
    }
    public static Node insertAtHead(Node head,int val)
    {
        if (head==null)
        {
            return new Node(val);
        }
        Node newNode=new Node(val);
        newNode.next=head;
        head.back=newNode;
        return newNode;
    }
    public static void main(String[] args) 
    {
        int []a={10,20,30,40,50};
        Node head=arrayToDLinkedList(a);
        traverseLinkedList(head);
    }   
}
