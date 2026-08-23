/*Leetcode: 74. Search a 2D Matrix
Link: https://leetcode.com/problems/search-a-2d-matrix/  */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) 
    {
        int low=0;
        int n=matrix[0].length;
        int high=matrix.length*n-1;
        while (low<=high)
        {
            int mid=(low+high)/2;
            int i=mid/n;
            int j=mid%n;
            if (matrix[i][j]==target)
            {
                return true;
            }
            else if (matrix[i][j]<target)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }    
        return false;
    }
}
