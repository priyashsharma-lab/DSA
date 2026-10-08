/*Leetcode: 496. Next Greater Element I
Link: https://leetcode.com/problems/next-greater-element-i/ */


//First try
// class Solution {
//     public int[] nextGreaterElements(int[] nums) 
//     {
//         int[] ans=new int[nums.length];
//         Stack<Integer> st=new Stack<>();
//         int i=nums.length-1;
//         for (int j=0;j<2*nums.length;j++)
//         {
//             while (!st.isEmpty() && nums[i]>=st.peek())
//             {
//                 st.pop();
//             }
//             if (st.isEmpty())
//             {
//                 ans[i]=-1;
//             }
//             else
//             {
//                 ans[i]=st.peek();
//             }
//             st.push(nums[i]);
//             if (i==0)
//             {
//                 i=nums.length-1;
//             }
//             else
//             {
//                 i--;
//             }
//         }    
//         return ans;
//     }
// }

// Optimal Sol
class Solution {
    public int[] nextGreaterElements(int[] nums) 
    {
        int[] ans=new int[nums.length];
        Stack<Integer> st=new Stack<>();
        int N=nums.length;
        for (int i=2*N-1;i>=0;i--)
        {
            int idx=i%N;
            while (!st.isEmpty() && nums[idx]>=st.peek())
            {
                st.pop();
            }
            if (i<N && st.isEmpty())
            {
                ans[idx]=-1;
            }
            else if (i<N)
            {
                ans[idx]=st.peek();
            }
            st.push(nums[idx]);
        }    
        return ans;
    }
}