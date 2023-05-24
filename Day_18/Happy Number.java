class Solution {
    public boolean isHappy(int n) {
        if(n==1 || n==-1)
            return true;
        
        Set<Integer> set=new HashSet<Integer>();

        while(!set.contains(n))
        {
            set.add(n);
            n=sofsq(n);
            if(n==1)
                return true;
        }

        return false;
    }

    public static int sofsq(int n)
    {
        int sum=0;
        while(n!=0)
        {
            int rem=n%10;
            int sq=rem*rem;
            sum+=sq;
            n=n/10;
        }
        return sum;
    }
}
