/*Leetcode: 155. Min Stack
Link: https://leetcode.com/problems/min-stack/*/

// can be dont using 2 stacks. Here I used a class Data which stores both value and minVal till it . TC-O(1) SC-O(2n)
class Data
{
    public int data;
    public int minVal;
    public Data(int data,int minVal)
    {
        this.data=data;
        this.minVal=minVal;
    }
}
class MinStack 
{
    private Stack<Data> st;
    public MinStack() 
    {
        st=new Stack<Data>();
    }
    
    public void push(int value) 
    {
        if (st.empty())
        {
            st.push(new Data(value,value));
            return;
        }
        st.push(new Data(value,Math.min(st.peek().minVal,value))); 
    }
    
    public void pop() 
    {
        st.pop();    
    }
    
    public int top() 
    {
        return st.peek().data;   
    }
    
    public int getMin() 
    {
        return st.peek().minVal;    
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

// Using formula 

class MinStack {
    Stack<Long> st = new Stack<>();
    long min;

    public void push(int val) {
        if (st.empty()) {
            st.push((long) val);
            min = val;
        }
        else if (val < min) {
            st.push(2L * val - min);
            min = val;
        }
        else {
            st.push((long) val);
        }
    }

    public void pop() {
        long x = st.pop();

        if (x < min) {
            min = 2 * min - x;
        }
    }

    public int top() {
        long x = st.peek();

        if (x < min) {
            return (int) min;
        }

        return (int) x;
    }

    public int getMin() {
        return (int) min;
    }
}