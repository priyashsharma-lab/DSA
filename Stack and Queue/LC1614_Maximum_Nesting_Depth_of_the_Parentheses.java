/*Leetcode: 1614. Maximum Nesting Depth of the Parentheses
Link: https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/ */
 // Using Stack
class Solution {
    public int maxDepth(String s) 
    {
        Stack<Character> st=new Stack<>();
        int maxDep=0;
        for (int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if (c=='(')
            {
                st.push(c);
            }
            if (c==')')
            {
                st.pop();
            }
            maxDep=Math.max(maxDep,st.size());
        }    
        return maxDep;
    }
}
 
// without stack
class Solution {
    public int maxDepth(String s) 
    {
        int maxDep=0;
        int dep=0;
        for (int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if (c=='(')
            {
                dep++;
            }
            if (c==')')
            {
                dep--;
            }
            maxDep=Math.max(maxDep,dep);
        }    
        return maxDep;
    }
}
