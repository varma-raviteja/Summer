Given an integer n, break it into the sum of k positive integers, where k >= 2, and maximize the product of those integers.

Return the maximum product you can get.

class Solution {
    public int integerBreak(int n) {
         if(n<=2) return 1;
        int dp[]=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        find(n,dp);
        return dp[n];
    }
    public int find(int n, int dp[])
    {
        if(n<=2) return n;
        if(dp[n]!=0) return dp[n];
        int max=Integer.MIN_VALUE;
        for(int i=n-1;i>=1;i--)
            max=Math.max(max,Math.max(i*(n-i),i*find(n-i,dp)));
        return dp[n]=max;
    }
}
