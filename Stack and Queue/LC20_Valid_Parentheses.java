/*Leetcode: 20. Valid Parentheses
Link: https://leetcode.com/problems/valid-parentheses/ */


class Solution {
    public boolean isValid(String s) 
    {
        if (s.length()==1)
        {
            return false;
        }
        Stack<Character> st=new Stack<>();
        for (int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if (c=='(' || c=='[' || c=='{')
            {
                st.push(c);
            }
            else if (st.empty())
            {
                return false;
            }
            else if (c==')' && st.peek()=='(')
            {
                st.pop();
            }
            else if (c==']' && st.peek()=='[')
            {
                st.pop();
            }
            else if (c=='}' && st.peek()=='{')
            {
                st.pop();
            }
            else
            {
                return false;
            }
            
        }    
        if (st.empty())
        {
            return true;
        }
        return false;
    }
}

// Cleaner sol 
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {

            if (c == '(') {
                st.push(')');
            }
            else if (c == '[') {
                st.push(']');
            }
            else if (c == '{') {
                st.push('}');
            }
            else {
                if (st.empty() || st.pop() != c) {
                    return false;
                }
            }
        }

        return st.empty();
    }
}