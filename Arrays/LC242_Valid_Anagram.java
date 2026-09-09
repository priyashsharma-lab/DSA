/*Leetcode: 242. Valid Anagram
Link: https://leetcode.com/problems/valid-anagram/ */

//Using 2 Freq arrays

class Solution {
    public boolean isAnagram(String s, String t) 
    {
        int n1=s.length();
        int n2=t.length();
        int []sFreq=new int[26];
        int []tFreq=new int[26];
        int i=0;
        int j=0;
        while(i<n1 || j<n2) 
        {
            if (i<n1)
            {
                sFreq[(int)(s.charAt(i)-'a')]++;
                i++;
            }
            if (j<n2)
            {
                tFreq[(int)(t.charAt(j)-'a')]++;
                j++;
            }
        }   
        return Arrays.equals(sFreq,tFreq);
    }
}

// Using 1 freq array
class Solution {
    public boolean isAnagram(String s, String t) 
    {
        int n1=s.length();
        int n2=t.length();
        if (n1!=n2)
        {
            return false;
        }
        int []sFreq=new int[26];
        for (int i=0;i<n1;i++)
        {
            sFreq[(int)(s.charAt(i))-'a']++;
        }
        for (int i=0;i<n2;i++)
        {
            if (sFreq[(int)(t.charAt(i))-'a']>0)
            {
                sFreq[(int)(t.charAt(i))-'a']--;
            }
            else
            {
                return false;
            }
        }
        return true;
    }
}