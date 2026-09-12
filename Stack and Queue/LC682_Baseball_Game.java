/*Leetcode: 682. Baseball Game
Link: https://leetcode.com/problems/baseball-game/ */

class Solution {
    public int calPoints(String[] operations) 
    {
        Stack<Integer> st=new Stack<>();
        int ans=0;
        for (String i:operations)
        {
            switch(i)
            {
                case "+":
                    int x=st.pop();
                    int y=st.peek();
                    st.push(x);
                    st.push(x+y);
                    ans+=x+y;
                    break;
                case "D":
                    int z=st.peek();
                    st.push(2*z);
                    ans+=2*z;
                    break;  
                case "C":
                    ans-=st.pop();
                    break;
                default:
                    st.push(Integer.parseInt(i));
                    ans+=Integer.parseInt(i);
                    break;
            }
        }    
        return ans;
    }
}