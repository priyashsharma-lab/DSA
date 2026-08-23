/*Leetcode: 2643. Row With Maximum Ones
Link: https://leetcode.com/problems/row-with-maximum-ones/  */

class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) 
    {
        int maxOneIndex=0;
        int maxOneCount=0;
        for (int i=0;i<mat.length;i++)
        {
            int oneCount=0;
            for (int j=0;j<mat[i].length;j++)
            {
                if (mat[i][j]==1)
                {
                    oneCount++;
                }
            }
            if (maxOneCount<oneCount)
            {
                maxOneCount=oneCount;
                maxOneIndex=i;
            }
        }    
        return new int[]{maxOneIndex,maxOneCount};
    }
}


// If every a[i] row is sorted then we can apply binary search to reduce time complexity to O(m logn)