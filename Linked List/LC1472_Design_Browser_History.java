/*Leetcode: 1472. Design Browser History
Link: https://leetcode.com/problems/design-browser-history/ */

class Node
{
    String val;
    Node next;
    Node prev;
    public Node()
    {
        val="";
        next=null;
        prev=null;
    }
    public Node(String val)
    {
        this.val=val;
    }
}
class BrowserHistory {
    private Node curr;
    public BrowserHistory(String homepage) 
    {
        curr=new Node(homepage);
    }
    
    public void visit(String url) 
    {
        curr.next=new Node(url);
        curr.next.prev=curr;
        curr=curr.next;
    }
    
    public String back(int steps) 
    {
        for (int i=1;i<=steps;i++)
        {
            if (curr.prev==null)
            {
                return curr.val;
            }
            curr=curr.prev;
        }
        return curr.val;
    }
    
    public String forward(int steps) 
    {
        for (int i=1;i<=steps;i++)
        {
            if (curr.next==null)
            {
                return curr.val;
            }
            curr=curr.next;
        }    
        return curr.val;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
