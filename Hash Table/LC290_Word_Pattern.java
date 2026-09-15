/*Leetcode: 290. Word Pattern
Link: https://leetcode.com/problems/word-pattern/ */

class Solution {
    public boolean wordPattern(String pattern, String s) 
    {
        String[] sArr=s.split(" ");
        if (sArr.length!=pattern.length())
        {
            return false;
        }
        HashMap<Character,String> mp=new HashMap<>();
        HashMap<String,Character> ms=new HashMap<>();
        for (int i=0;i<sArr.length;i++)
        {
            char p=pattern.charAt(i);
            if (mp.containsKey(p))
            {
                if (!(mp.get(p).equals(sArr[i])) || ms.get(sArr[i])!=p)
                {
                    return false;
                }
            }
            else if (ms.containsKey(sArr[i]))
            {
                if (ms.get(sArr[i])!=p)
                {
                    return false;
                }   
            }
            else
            {
                mp.put(p,sArr[i]);
                ms.put(sArr[i],p);
            }
        }
        return true;    
    }
}