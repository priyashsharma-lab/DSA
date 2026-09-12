/*Leetcode: 1047. Remove All Adjacent Duplicates In String
Link: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/ */

// Using String as ans
class Solution {
    public String removeDuplicates(String s) 
    {
        if (s.length()==1)
        {
            return s;
        }
        String ans="";
        Stack<Character> st=new Stack<>();
        for (int i=s.length()-1;i>=0;i--)
        {
            char c=s.charAt(i);
            if (st.empty())
            {
                st.push(c);
            }
            else if (c==st.peek())
            {
                st.pop();
            }
            else
            {
                st.push(c);
            }
        }    
        while (!st.empty())
        {
            ans+=st.pop();
        }
        return ans;
    }
}

// Using StringBuilder for concatanation 
class Solution {
    public String removeDuplicates(String s) 
    {
        if (s.length()==1)
        {
            return s;
        }
        StringBuilder ans=new StringBuilder();
        Stack<Character> st=new Stack<>();
        for (int i=s.length()-1;i>=0;i--)
        {
            char c=s.charAt(i);
            if (st.empty())
            {
                st.push(c);
            }
            else if (c==st.peek())
            {
                st.pop();
            }
            else
            {
                st.push(c);
            }
        }    
        while (!st.empty())
        {
            ans.append(st.pop());
        }
        return String.valueOf(ans);
    }
}

// Using StringBuilder as Stack
class Solution {
    public String removeDuplicates(String s) 
    {
        StringBuilder ans=new StringBuilder();
        for (int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if (ans.length()==0)
            {
                ans.append(c);
            }
            else if (c==ans.charAt(ans.length()-1))
            {
                ans.deleteCharAt(ans.length()-1);
            }
            else
            {
                ans.append(c);
            }
        }    
        return ans.toString();
    }
}