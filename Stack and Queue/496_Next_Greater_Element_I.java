/*Leetcode: 496. Next Greater Element I
Link: https://leetcode.com/problems/next-greater-element-i/ */

// First try
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) 
    {
        int[] m=new int[nums2.length];
        Stack<Integer> st=new Stack<>();
        for (int i=nums2.length-1;i>=0;i--)
        {
            while (!st.isEmpty() && nums2[i]>=nums2[st.peek()])
            {
                st.pop();
            }
            if (st.isEmpty())
            {
                m[i]=-1;
            }
            else
            {
                m[i]=nums2[st.peek()];
            }
            st.push(i);
        }
        int[] ans=new int[nums1.length];
        for (int i=0;i<nums1.length;i++)
        {
            for (int j=0;j<nums2.length;j++)
            {
                if (nums1[i]==nums2[j])
                {
                    ans[i]=m[j];
                }
            }
        }
        return ans;
    }
}
//Second try
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) 
    {
        Stack<Integer> st=new Stack<>();
        int[] ans=new int[nums1.length];
        for (int i=nums2.length-1;i>=0;i--)
        {
            while (!st.isEmpty() && nums2[i]>=nums2[st.peek()])
            {
                st.pop();
            }
            for (int j=0;j<nums1.length;j++)
            {
                if (nums2[i]==nums1[j])
                {
                    if (st.isEmpty())
                    {
                        ans[j]=-1;
                    }
                    else
                    {
                        ans[j]=nums2[st.peek()];
                    }
                }
            }
            st.push(i);
        }
        return ans;
    }
}

// Optimal Hashmap + motonoic solution
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) 
    {
        Stack<Integer> st=new Stack<>();
        int[] ans=new int[nums1.length];
        HashMap<Integer,Integer> m=new HashMap<>();
        for (int i=nums2.length-1;i>=0;i--)
        {
            while (!st.isEmpty() && nums2[i]>=nums2[st.peek()])
            {
                st.pop();
            }
            if (st.isEmpty())
            {
                m.put(nums2[i],-1);
            }
            else
            {
                m.put(nums2[i],nums2[st.peek()]);
            }
            st.push(i);
        }
        for (int i=0;i<nums1.length;i++)
        {
            ans[i]=m.get(nums1[i]);
        }
        return ans;
    }
}