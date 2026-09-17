/*Leetcode: 448. Find All Numbers Disappeared in an Array
Link: https://leetcode.com/problems/first-unique-character-in-a-string/ */

// Using hashset
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) 
    {
        HashSet<Integer> s=new HashSet<>();
        for (int i:nums)
        {
            s.add(i);
        }    
        List<Integer> ls=new ArrayList<>();
        for (int i=1;i<=nums.length;i++)
        {
            if (!s.contains(i))
            {
                ls.add(i);
            }
        }
        return ls;
    }
}

// using Array to store
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) 
    {
        boolean []isPresent=new boolean[nums.length+1];
        for (int i:nums)
        {
            isPresent[i]=true;
        }    
        List<Integer> ls=new ArrayList<>();
        for (int i=1;i<isPresent.length;i++)
        {
            if (!isPresent[i])
            {
                ls.add(i);
            }
        }
        return ls;
    }
}
// Best Sol 
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> ls = new ArrayList<>();

        for (int x : nums) {
            int index = Math.abs(x) - 1;
            nums[index] = -Math.abs(nums[index]);
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ls.add(i + 1);
            }
        }

        return ls;
    }
}
