/*Leetcode:1848. Minimum Distance to the Target Element
Link: https://leetcode.com/problems/minimum-distance-to-the-target-element/ */

class Solution {
    public int getMinDistance(int[] nums, int target, int start) 
    {
        int minD=Integer.MAX_VALUE;
        for (int i=0;i<nums.length;i++)
        {
            if (nums[i]==target)
            {
                int d=Math.abs(i-start);
                minD=Math.min(minD,d);
            }
        }    
        if (minD==Integer.MAX_VALUE)
        {
            return 0;
        }
        return minD;
    }
}

class Solution {
    public int getMinDistance(int[] nums, int target, int start) 
    {
        int minD=Integer.MAX_VALUE;
        int l=0;
        int r=nums.length-1;
        while (l<=r)
        {
            if (nums[l]==target)
            {
                int d=Math.abs(l-start);
                minD=Math.min(minD,d);
            }
            if (nums[r]==target)
            {
                int d=Math.abs(r-start);
                minD=Math.min(minD,d);
            }
            l++;
            r--;
        }    
        if (minD==Integer.MAX_VALUE)
        {
            return 0;
        }
        return minD;
    }
}

class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        for (int d = 0; d < nums.length; d++) {
            int left = start - d;
            int right = start + d;

            if (left >= 0 && nums[left] == target)
                return d;

            if (right < nums.length && nums[right] == target)
                return d;
        }

        return 0;
    }
}