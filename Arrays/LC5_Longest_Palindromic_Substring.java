/*Leetcode: 5. Longest Palindromic Substring
Link: https://leetcode.com/problems/longest-palindromic-substring/ */

class Solution {
    public String longestPalindrome(String s) 
    {
        if (s == null || s.isEmpty())
        {
            return "";
        }
        StringBuilder sb=new StringBuilder();
        sb.append("^#");
        for (int i=0;i<s.length();i++)
        {
            sb.append(s.charAt(i));
            sb.append("#");
        }    
        sb.append("$");
        int radii[]=new int[sb.length()];
        int center=0;
        int right=0;
        int maxLength=0;
        int maxCenter=0;

        for (int i=1;i<sb.length();i++)
        {
            int mirror=2*center-i;

            if (i<right)
            {
                radii[i]=Math.min(right-i,radii[mirror]);
            }

            while (i-1+radii[i]>=0 && i+1+radii[i]<sb.length() &&sb.charAt(i+(1+radii[i]))==sb.charAt(i-(1+radii[i])))
            {
                radii[i]++;
            }

            if (i+radii[i]>right)
            {
                right=i+radii[i];
                center=i;
            }

            if (radii[i]>maxLength)
            {
                maxLength=radii[i];
                maxCenter=i;
            }
        }
        int start=(maxCenter-maxLength)/2;
        return s.substring(start,start+maxLength);
    }
}
