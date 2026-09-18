/*Leetcode: 1189. Maximum Number of Balloons
Link: https://leetcode.com/problems/maximum-number-of-balloons/ */

class Solution {
    public int maxNumberOfBalloons(String text) 
    {
        HashMap<Character,Integer> m=new HashMap<>();
        for (int i=0;i<text.length();i++)
        {
            char c=text.charAt(i);
            if (c=='b' || c=='a' || c=='l' || c=='o' || c=='n')
            {
                m.put(c,m.getOrDefault(c,0)+1);
            }
        }
        int minNo=Integer.MAX_VALUE;
        if (!m.containsKey('b') || !m.containsKey('a') || !m.containsKey('n') || !m.containsKey('l') || !m.containsKey('o'))
        {
            System.out.println("1st");
            return 0;
        }
        minNo=Math.min(m.get('b'),m.get('a'));
        minNo=Math.min(minNo,m.get('n'));
        minNo=Math.min(minNo,(int)m.get('o')/2);
        minNo=Math.min(minNo,(int)m.get('l')/2);
        return minNo;
    }
}

// better using array
class Solution {
    public int maxNumberOfBalloons(String text) 
    {
        int []freq=new int[5];
        for (int i=0;i<text.length();i++)
        {
            char c=text.charAt(i);
            switch(c)
            {
                case 'b':
                    freq[0]++;
                    break;
                case 'a':
                    freq[1]++;
                    break;
                case 'l':
                    freq[2]++;
                    break;
                case 'o':
                    freq[3]++;
                    break;
                case 'n':
                    freq[4]++;
                    break;
                default:
                    continue;
            }
        }
        int minNo=Integer.MAX_VALUE;
        for (int i=0;i<5;i++)
        {
            if (freq[i]==0)
            {
                return 0;
            }
            else if (i<2 || i==4)
            {
                minNo=Math.min(minNo,freq[i]);    
            }
            else
            {
                minNo=Math.min(minNo,(int)(freq[i]/2));
            }
        }
        return minNo;
    }
}

// Best Compact version
class Solution {
    public int maxNumberOfBalloons(String text) {
        int b = 0, a = 0, l = 0, o = 0, n = 0;

        for (int i = 0; i < text.length(); i++) {
            switch (text.charAt(i)) {
                case 'b' -> b++;
                case 'a' -> a++;
                case 'l' -> l++;
                case 'o' -> o++;
                case 'n' -> n++;
            }
        }

        return Math.min(
            Math.min(Math.min(b, a), n),
            Math.min(l / 2, o / 2)
        );
    }
}