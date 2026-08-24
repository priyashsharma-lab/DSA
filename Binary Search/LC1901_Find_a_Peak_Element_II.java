/*Leetcode: 1901. Find a Peak Element II
Link: https://leetcode.com/problems/find-a-peak-element-ii/  */

class Solution {
    public int[] findPeakGrid(int[][] mat) 
    {
        int low=0;
        int high=mat.length-1;
        while (low<=high)
        {
            int mid=(low+high)/2;
            int maxIdx=0;
            for (int i=1;i<mat[mid].length;i++)
            {
                if (mat[mid][maxIdx]<mat[mid][i])
                {
                    maxIdx=i;
                }
            }
            int up=(mid==0)?-1:mat[mid-1][maxIdx];
            int down=(mid==mat.length-1)?-1:mat[mid+1][maxIdx];
            if (mat[mid][maxIdx]>up && mat[mid][maxIdx]>down)
            {
                return new int[]{mid,maxIdx};
            }
            else if (mat[mid][maxIdx]<down)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return new int[]{-1,-1};
    }
}