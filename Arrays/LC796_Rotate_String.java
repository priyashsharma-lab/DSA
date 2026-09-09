/*Leetcode: 796. Rotate String
Link: https://leetcode.com/problems/rotate-string/ */


//TC- O(n^2) worst case
class Solution {
    public boolean rotateString(String s, String goal) 
    {
        int n1=s.length();
        int n2=goal.length();
        if (n1!=n2)
        {
            return false;
        }
        if (s.equals(goal))
        {
            return true;
        }
        int sPtr=0;
        int gPtr=0;
        int temp=0;
        while (temp<n1)
        {
            if (s.charAt(temp)==goal.charAt(gPtr))
            {
                sPtr=temp;
                while (gPtr<n2 && s.charAt(sPtr)==goal.charAt(gPtr))
                {
                    sPtr=(sPtr+1)%n1;
                    gPtr++;
                }
                if (gPtr>=n2)
                {
                    return true;
                }
                gPtr=0;
            }
            temp++;
        }    
        return false;
    }
}

//Using KMP Algo TC- O(m+n) SC- O(n)
class Solution {
    public boolean rotateString(String s, String goal) {

        int n = s.length();

        if (n != goal.length()) {
            return false;
        }

        String text = s + s;

        int[] lps = new int[n];

        int len = 0;
        int i = 1;

        while (i < n) {
            if (goal.charAt(i) == goal.charAt(len)) {
                lps[i] = ++len;
                i++;
            } 
            else if (len > 0) {
                len = lps[len - 1];
            } 
            else {
                lps[i] = 0;
                i++;
            }
        }

        i = 0;
        int j = 0;

        while (i < text.length()) {

            if (text.charAt(i) == goal.charAt(j)) {
                i++;
                j++;

                if (j == n) {
                    return true;
                }
            } 
            else if (j > 0) {
                j = lps[j - 1];
            } 
            else {
                i++;
            }
        }

        return false;
    }
}