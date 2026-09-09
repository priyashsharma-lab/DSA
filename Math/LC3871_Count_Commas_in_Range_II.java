/*Leetcode: 3871. Count Commas in Range II
Link: https://leetcode.com/problems/count-commas-in-range-ii/ */

class Solution {
    public long countCommas(long n) 
    {
        if (n<1000)
        {
            return 0;
        }
        long comCount=0;
        long minVal=1000;
        long maxVal=9000;
        long digCount=4;
        long nDig=String.valueOf(n).length();
        long com=1;
        for (long i=4;i<nDig;i++)
        {
            if (i%3==0)
            {
                com=i/3-1;
            }
            else
            {
                com=i/3;
            }
            comCount+=maxVal*com;
            maxVal=maxVal*10;
            minVal=minVal*10;
        }    
        if (nDig%3==0)
        {
            com=nDig/3-1;
        }
        else
        {
            com=nDig/3;
        }
        comCount+=(n-minVal+1)*com;
        return comCount;
    }
}