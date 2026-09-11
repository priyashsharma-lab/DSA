class Node
{
    public Node next;
    public int data;

    public Node() 
    {
        next=null;
        data=0;
    }
    public Node(int data) 
    {
        next=null;
        this.data=data;
    }
    
}
class Stack
{
    private Node top;
    private int size;
    public Stack() 
    {
        top=null;
        size=0;
    }
    public void push(int val)
    {
        Node temp=top;
        top=new Node(val);
        top.next=temp;
        size++;
    }
    public int pop()
    {
        if (isEmpty())
        {
            System.out.println("Stack Underflow");
            return -1;
        }
        int d=top.data;
        top=top.next;
        size--;
        return d;
    }
    public boolean isEmpty()
    {
        return top == null;
    }
    public int peek()
    {
        if (isEmpty())
        {
            System.out.println("Stack Underflow");
            return -1;
        }
        return top.data;
    }
    public int getSize()
    {
        return size;
    }
}
class Queue
{
    private Node front;
    private Node rear;
    private int size;

    public Queue() 
    {
        front=null;
        rear=null;
        size=0;
    }
    public void enqueue(int val)
    {
        if (isEmpty())
        {
            front=new Node(val);
            rear=front;
        }
        else
        {
            rear.next=new Node(val);
            rear=rear.next;
        }
        size++;
    }
    public int dequeue()
    {
        if (isEmpty())
        {
            System.out.println("Queue is empty");
            return -1;
        }
        int d=front.data;
        front=front.next;
        size--;
        if (front == null)
        {
            rear = null;
        }
        return d;
    }
    public boolean isEmpty()
    {
        return front == null && rear == null;
    }
    public int getSize()
    {
        return size;
    }
    public int getFront()
    {
        if (isEmpty())
        {
            System.out.println("Queue is empty");
            return -1;
        }
        return front.data;
    }
    public int getRear()
    {
        if (isEmpty())
        {
            System.out.println("Queue is empty");
            return -1;
        }
        return rear.data;
    }
    
}
public class Stack_queue_implementation 
{
    public static void main(String[] args) 
    {
        Stack st=new Stack();
        st.push(10);    
        st.push(20);    
        st.push(30);
        System.out.println(st.getSize());
        System.out.println(st.peek());    
        System.out.println(st.pop());
        System.out.println(st.peek());    
        System.out.println(st.pop());
        System.out.println(st.peek());    
        System.out.println(st.pop());
        System.out.println(st.peek());    
        System.out.println(st.pop());

        Queue q=new Queue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        System.out.println(q.getFront());
        System.out.println(q.getRear());
        System.out.println(q.dequeue());
        System.out.println(q.getFront());
    }    
}
