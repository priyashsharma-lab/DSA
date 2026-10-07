/*Leetcode: 504. Base 7
Link: https://leetcode.com/problems/base-7 */

class Solution {
    public String convertToBase7(int num) 
    {
        int n=0;
        if (num<0)
        {
            n=Math.abs(num);
        }
        else if (num==0)
        {
            return "0";
        }
        else
        {
            n=num;
        }
        StringBuilder st=new StringBuilder();
        while (n>0)
        {
            int x=n%7;
            st.append(String.valueOf(x));
            n/=7;
        }    
        if (num<0)
        {
            st.append("-");
        }
        return st.reverse().toString();
    }
}

//Direct
class Solution {
    public String convertToBase7(int num) {
        return Integer.toString(num, 7);
    }
}
