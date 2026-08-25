class Node
{
    public int data;
    public Node next;

    public Node(int data,Node next) 
    {
        this.data=data;
        this.next=next;
    }
    public Node(int data)
    {
        this.data=data;
        next=null;
    }
    
}
public class BasicLinkedListOperations
{
    public static Node arrayToLinkedList(int[] a)
    {
        Node head=new Node(a[0]);
        Node endNode=head;
        for (int i=1;i<a.length;i++)
        {
            Node temp=new Node(a[i]);
            endNode.next=temp;
            endNode=temp;
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
    public static boolean checkIfPresent(Node head,int key)
    {
        Node temp=head;
        while (temp!=null)
        {
            if (temp.data==key)
            {
                return true;
            }
            temp=temp.next;
        }
        return false;
    }
    public static Node deleteAtHead(Node head)
    {
        if (head==null)
        {
            System.out.println("List is empty");
            return null;
        }
        return head.next;
    }
    public static Node deleteAtTail(Node head)
    {
        if (head==null || head.next==null)
        {
            return null;
        }
        Node temp=head;
        while (temp.next.next!=null)
        {
            temp=temp.next;
        }
        temp.next=null;
        return head;
    }
    public static Node deleteAtK(Node head,int k)
    {
        if (head==null)
        {
            return null;
        }
        if (k==1)
        {
            return head.next;
        }
        Node temp=head;
        Node prev=null;
        for (int i=1;i<k && temp!=null;i++)
        {
            prev=temp;
            temp=temp.next;
        }
        if (temp==null)
        {
            return head;
        }
        prev.next=prev.next.next;
        temp=null; // not necessary after the method is completed temp will be destroyed and then the value it points
        return head;
    }
    public static Node deleteByValue(Node head,int val)
    {
        if (head==null)
        {
            return null;
        }
        if (head.data==val)
        {
            return head.next;
        }
        Node temp=head;
        Node prev=null;
        while (temp!=null && temp.data!=val)
        {
            prev=temp;
            temp=temp.next;
        }
        if (temp==null)
        {
            return head;
        }
        prev.next=prev.next.next;
        temp=null; // not necessary after the method is completed temp will be destroyed and then the value it points
        return head;
    }
    public static Node insertAtHead(Node head,int val)
    {
        if (head==null)
        {
            return new Node(val);
        }
        Node temp=new Node(val);
        temp.next=head;
        return temp;
    }
    public static Node insertAtTail(Node head,int val)
    {
        if (head==null)
        {
            return new Node(val);
        }
        Node temp=head;
        while (temp.next!=null)
        {
            temp=temp.next;
        }
        temp.next=new Node(val);
        return head;
    }
    public static Node insertAtK(Node head,int val,int k)
    {
        if (head==null)
        {
            if (k==1)
            {
                return new Node(val);
            }
            else
            {
                return head;
            }
        }
        if (k==1)
        {
            return new Node(val,head);
        }
        Node temp=head;
        for (int i=1;i<k-1 && temp!=null;i++)
        {
            temp=temp.next;
        }
        if (temp==null)
        {
            return head;
        }
        Node t=temp.next;
        temp.next=new Node(val);
        temp.next.next=t;
        return head;
    }
    public static Node insertBeforeVal(Node head,int val,int newVal)
    {
        if (head==null)
        {
            return head;
        }
        if (head.data==val)
        {
            return new Node(newVal,head);
        }
        Node temp=head;
        while (temp!=null && temp.next!=null && temp.next.data!=val)
        {
            temp=temp.next;
        }
        if (temp==null)
        {
            return head;
        }
        Node t=temp.next;
        temp.next=new Node(newVal);
        temp.next.next=t;
        return head;
    }
    public static void main(String[] args) 
    {
        int []a={10,20,30,40,50};
        Node head=arrayToLinkedList(a);
        traverseLinkedList(head);
        System.out.println();    
        System.out.println(lengthOfLinkedList(head));
        System.out.println(checkIfPresent(head, 10));
        traverseLinkedList(deleteAtHead(head));
        System.out.println();
        traverseLinkedList(deleteAtTail(head));
        System.out.println();
        traverseLinkedList(deleteAtK(head, 3));
        System.out.println();
        traverseLinkedList(deleteByValue(head, 40));
        System.out.println();
        traverseLinkedList(deleteAtK(head, 6));

        System.out.println();
        traverseLinkedList(insertAtHead(head, 100));
        System.out.println();
        traverseLinkedList(insertAtTail(head, 100));
        System.out.println();
        traverseLinkedList(insertAtK(head, 99,2));
        System.out.println();
        traverseLinkedList(insertBeforeVal(head, 100, -1));
        System.out.println();
        traverseLinkedList(insertAtK(head,10000, 9));
        System.out.println();
        traverseLinkedList(insertAtK(head, 22, 6));
    }
}