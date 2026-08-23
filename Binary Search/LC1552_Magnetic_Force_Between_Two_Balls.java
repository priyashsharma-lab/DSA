/*Leetcode: 1552. Magnetic Force Between Two Balls
Link: https://leetcode.com/problems/magnetic-force-between-two-balls/ */

// First try approach 
class Solution {
    public int maxDistance(int[] position, int m) 
    {
        Arrays.sort(position);
        int low=1;
        int high=position[position.length-1]-position[0];
        int maxF=Integer.MIN_VALUE;
        while (low<=high)
        {
            int mid=(low+high)/2;
            int placedBalls=1;
            int placedBallPos=0;
            int minF=Integer.MAX_VALUE;
            for (int i=1;i<position.length;i++)
            {
                if (position[i]-position[placedBallPos]>=mid)
                {
                    minF=Math.min(minF,position[i]-position[placedBallPos]);
                    placedBallPos=i;
                    placedBalls++;
                }
                if (placedBalls==m)
                {
                    maxF=Math.max(maxF,minF);
                    break;
                }
            }
            if (placedBalls<m)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }    
        return maxF;
    }
}


// Optimized approach
class Solution {
    public int maxDistance(int[] position, int m) 
    {
        Arrays.sort(position);
        int low=1;
        int high=position[position.length-1]-position[0];
        int ans=0;
        while (low<=high)
        {
            int mid=(low+high)/2;
            int placedBalls=1;
            int placedBallPos=0;
            for (int i=1;i<position.length;i++)
            {
                if (position[i]-position[placedBallPos]>=mid)
                {
                    placedBallPos=i;
                    placedBalls++;
                }
                if (placedBalls==m)
                {
                    break;
                }
            }
            if (placedBalls==m)
            {
                ans=mid;
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }    
        return ans;
    }
}