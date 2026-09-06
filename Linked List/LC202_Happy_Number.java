/*Leetcode: 202. Happy Number
Link: https://leetcode.com/problems/happy-number/ */

// Uisng HashSet and 2 loops 
class Solution {
    public boolean isHappy(int n) 
    {
        HashSet<Integer> s=new HashSet<>();
        System.out.println("oye");
        s.add(n);
        while (n!=1)    
        {
            int newN=0;
            int len=String.valueOf(n).length();
            for (int i=0;i<len;i++)
            {
                newN+=(n%10)*(n%10);
                n=n/10;
            }
            n=newN;
            if (s.contains(n))
            {
                break;
            }
            s.add(n);
            System.out.println(n);
        }
        if (n==1)
        {
            return true;
        }
        return false;
    }
}

// Using slow and fast pointers Floyd algo
class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = squareSum(slow);
            fast = squareSum(squareSum(fast));
        } while (slow != fast);

        return slow == 1;
    }

    private int squareSum(int n) {
        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }

        return sum;
    }
}