/*Leetcode: 680. Valid Palindrome II
Link: https://leetcode.com/problems/valid-palindrome-ii/ */

class Solution {
    public boolean validPalindrome(String s) 
    {
        if (s.length()==1)
        {
            return true;
        }
        int l=0;
        int r=s.length()-1;    
        int removeCtr1=0;
        int removeCtr2=0;
        while (l<=r)
        {
            if (s.charAt(l)!=s.charAt(r))
            {
                removeCtr1++;
                r--;
                continue;
            }
            l++;
            r--;
            if (removeCtr1>1)
            {
                break;
            }
        }
        if (removeCtr1<=1)
        {
            return true;
        }

        l=0;
        r=s.length()-1;    
        while (l<=r)
        {
            if (s.charAt(l)!=s.charAt(r))
            {
                removeCtr2++;
                l++;
                continue;
            }
            l++;
            r--;
            if (removeCtr2>1)
            {
                break;
            }
        }
        if (removeCtr2<=1)
        {
            return true;
        }
        return false;
    }
}