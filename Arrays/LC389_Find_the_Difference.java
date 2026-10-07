/*Leetcode: 389. Find the Difference
Link: https://leetcode.com/problems/find-the-difference/description/ */

class Solution {
    public char findTheDifference(String s, String t) 
    {
        int []sFreq=new int[26];
        int []tFreq=new int[26];
        for (int i=0;i<s.length();i++)
        {
            sFreq[s.charAt(i)-'a']++;
            tFreq[t.charAt(i)-'a']++;
        }
        tFreq[t.charAt(t.length()-1)-'a']++;
        for (int i=0;i<26;i++)
        {
            if (sFreq[i]!=tFreq[i])
            {
                return (char)(i+'a');
            }
        }
        return 'a';
    }
}

// Using XOR
class Solution {
    public char findTheDifference(String s, String t) {

        char ans = 0;

        for (char c : s.toCharArray())
            ans ^= c;

        for (char c : t.toCharArray())
            ans ^= c;

        return ans;
    }
}
// Using Subtraction
class Solution {
    public char findTheDifference(String s, String t) {
        int checkSum = 0;
        for (char c : s.toCharArray())
            checkSum -= c;
        for (char c : t.toCharArray())
            checkSum += c;
        return (char) (checkSum);
    }
}