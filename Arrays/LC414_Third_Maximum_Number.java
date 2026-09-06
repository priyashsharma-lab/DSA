/*Leetcode: 414. Third Maximum Number
Link: https://leetcode.com/problems/third-maximum-number/ */

class Solution {
    public int thirdMax(int[] nums) 
    {
        long firstMax=Long.MIN_VALUE;
        long secondMax=Long.MIN_VALUE;
        long thirdMax=Long.MIN_VALUE;
        for (int i:nums)
        {
            if (i==firstMax || i==secondMax || i==thirdMax)
            {
                continue;
            }
            if (i>firstMax)
            {
                thirdMax=secondMax;
                secondMax=firstMax;
                firstMax=i;
            }
            else if (i>secondMax)
            {
                thirdMax=secondMax;
                secondMax=i;
            }
            else if (i>thirdMax)
            {
                thirdMax=i;
            }
        }
        if (thirdMax==Long.MIN_VALUE)
        {
            return (int)firstMax;
        }
        return (int)thirdMax;
    }
}