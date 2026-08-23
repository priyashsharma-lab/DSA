/*Leetcode: 240. Search a 2D Matrix II
Link: https://leetcode.com/problems/search-a-2d-matrix-ii/  */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) 
    {
        int row=0;
        int cols=matrix[0].length-1;
        while (row<matrix.length && cols>=0)
        {
            if (matrix[row][cols]==target)
            {
                return true;
            }
            else if (matrix[row][cols]>target)
            {
                cols--;
            }
            else
            {
                row++;
            }
        }        
        return false;
    }
}
