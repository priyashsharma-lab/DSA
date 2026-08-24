/*Leetcode: 475. Heaters
Link: https://leetcode.com/problems/heaters/  */

class Solution {
    public int findRadius(int[] houses, int[] heaters) 
    {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int low=0;
        int high=Math.max(houses[houses.length-1],heaters[heaters.length-1]);
        while (low<=high)
        {
            int mid=low+((high-low)/2);
            int i=0;
            int j=0;
            while (i<houses.length && j<heaters.length)
            {
                if (houses[i]==heaters[j])
                {
                    i++;
                    continue;
                }
                if (Math.abs(houses[i]-heaters[j])<=mid)
                {
                    i++;
                }
                else
                {
                    j++;
                }
            }
            if (j>=heaters.length && i<houses.length)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }    
        return low;
    }
}