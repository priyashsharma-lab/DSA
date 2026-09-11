/*Leetcode:3903. Smallest Stable Index I
Link: https://leetcode.com/problems/smallest-stable-index-i/ */

// class Solution {
//     public int firstStableIndex(int[] nums, int k) 
//     {
//         int n=nums.length;
//         int []maxIdx=new int[n];    
//         int []minIdx=new int[n];    

//         int m=0;
//         for (int i=0;i<n;i++)
//         {
//             if (nums[i]>m)
//             {
//                 m=nums[i];
//             }
//             maxIdx[i]=m;
//         }
//         m=Integer.MAX_VALUE;
//         for (int i=n-1;i>=0;i--)
//         {
//             if (nums[i]<m)
//             {
//                 m=nums[i];
//             }
//             minIdx[i]=m;
//         }

//         for (int i=0;i<n;i++)
//         {
//             if (maxIdx[i]-minIdx[i]<=k)
//             {
//                 return i;
//             }
//         }
//         return -1;
//     }
// }

// class Solution {
//     public int firstStableIndex(int[] nums, int k) 
//     {
//         int n=nums.length;
//         int []maxIdx=new int[n];    
//         int []minIdx=new int[n];    

//         int maxi=0;
//         int mini=Integer.MAX_VALUE;

//         int maPtr=0;
//         int miPtr=n-1;
//         while (maPtr<n && miPtr>=0)
//         {
//             if (nums[maPtr]>maxi)
//             {
//                 maxi=nums[maPtr];
//             }
//             maxIdx[maPtr]=maxi;

//             if (nums[miPtr]<mini)
//             {
//                 mini=nums[miPtr];
//             }
//             minIdx[miPtr]=mini;

//             maPtr++;
//             miPtr--;
//         }

//         for (int i=0;i<n;i++)
//         {
//             if (maxIdx[i]-minIdx[i]<=k)
//             {
//                 return i;
//             }
//         }
//         return -1;
//     }
// }

// class Solution {
//     public int firstStableIndex(int[] nums, int k) 
//     {
//         int n=nums.length;  
//         int []minIdx=new int[n];    

//         int m=Integer.MAX_VALUE;
//         for (int i=n-1;i>=0;i--)
//         {
//             if (nums[i]<m)
//             {
//                 m=nums[i];
//             }
//             minIdx[i]=m;
//         }
//         m=0;
//         for (int i=0;i<n;i++)
//         {
//             if (nums[i]>m)
//             {
//                 m=nums[i];
//             }
//             if (m-minIdx[i]<=k)
//             {
//                 return i;
//             }
//         }
//         return -1;
//     }
// }

class Solution {
    public int firstStableIndex(int[] nums, int k) 
    {
        int n=nums.length;     

        int maxi=0;
        int mini=Arrays.stream(nums).min().getAsInt();
        for (int i=0;i<n;i++)
        {
            if (nums[i]>maxi)
            {
                maxi=nums[i];
            }
            if (i==n-1)
            {
                mini=nums[i];
            }
            if (maxi-mini<=k)
            {
                return i;
            }
            if (nums[i]==mini && i<n-1)
            {
                mini=Arrays.stream(nums,i+1,n).min().getAsInt();
            }
        }
        return -1;
    }
}