/*Leetcode: 1189. Maximum Number of Balloons
Link: https://leetcode.com/problems/maximum-number-of-balloons/ */

class Solution {
    public int numIdenticalPairs(int[] nums) 
    {
        int []freq=new int[101];
        int ans=0;
        for (int i:nums)
        {
            freq[i]++;
        }
        for (int i=1;i<freq.length;i++)
        {
            ans+=((freq[i]*(freq[i]-1))/2);
        }
        return ans;
    }
}

//BEST 
class Solution {
    public int numIdenticalPairs(int[] nums) 
    {
        int []freq=new int[101];
        int ans=0;
        for (int i:nums)
        {
            ans+=freq[i];
            freq[i]++;
        }
        return ans;
    }
}