/*Leetcode: 3870. Count Commas in Range
Link: https://leetcode.com/problems/count-commas-in-range */


// class Solution {
//     public int countCommas(int n) 
//     {
//         int comCount=0;
//         for (int i=1000;i<=n;i++)
//         {
//             int digCount=String.valueOf(i).length();
//             if (digCount%3==0)
//             {
//                 comCount+=digCount/3-1;
//             }
//             else
//             {
//                 comCount+=digCount/3;
//             }
//         }    
//         return comCount;
//     }
// }


// class Solution {
//     public int countCommas(int n) 
//     {
//         if (n<1000)
//         {
//             return 0;
//         }
//         int comCount=0;
//         int minVal=1000;
//         int maxVal=9000;
//         int digCount=4;
//         int nDig=String.valueOf(n).length();
//         int com=1;
//         for (int i=4;i<nDig;i++)
//         {
//             if (i%3==0)
//             {
//                 com=i/3-1;
//             }
//             else
//             {
//                 com=i/3;
//             }
//             comCount+=maxVal*com;
//             maxVal=maxVal*10;
//             minVal=minVal*10;
//         }    
//         if (nDig%3==0)
//         {
//             com=nDig/3-1;
//         }
//         else
//         {
//             com=nDig/3;
//         }
//         comCount+=(n-minVal+1)*com;
//         return comCount;
//     }
// }


class Solution {
    public int countCommas(int n) {
        if (n < 1000) {
            return 0;
        }

        long ans = 0;

        if (n >= 1000) {
            ans += Math.min(n, 9999) - 1000 + 1;
        }

        if (n >= 10000) {
            ans += Math.min(n, 99999) - 10000 + 1;
        }

        if (n >= 100000) {
            ans += Math.min(n, 999999) - 100000 + 1;
        }

        if (n >= 1000000) {
            ans += 2L * (Math.min(n, 9999999) - 1000000 + 1);
        }

        if (n >= 10000000) {
            ans += 2L * (Math.min(n, 99999999) - 10000000 + 1);
        }

        if (n >= 100000000) {
            ans += 2L * (Math.min(n, 999999999) - 100000000 + 1);
        }

        if (n >= 1000000000) {
            ans += 3L * (Math.min(n, Integer.MAX_VALUE) - 1000000000L + 1);
        }

        return (int) ans;
    }
}
