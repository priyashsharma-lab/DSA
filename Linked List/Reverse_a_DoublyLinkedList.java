public class Reverse_a_DoublyLinkedList 
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
    public static Node reverseDLL(Node head)
    {
        if (head==null || head.next==null)
        {
            return head;
        }
        Node temp=head;
        while (temp!=null)
        {
            Node t=temp.next;
            temp.next=temp.back;
            temp.back=t;

            if (temp.back==null)
            {
                return temp;
            }
            temp=temp.back;
        }
        return head;
    }    
    public static void main(String[] args) 
    {
        int []a={10,20,30,40,50};
        Node head=arrayToDLinkedList(a);
        traverseLinkedList(head);
        System.out.println();
        head=reverseDLL(head);
        traverseLinkedList(head);
    }
}
