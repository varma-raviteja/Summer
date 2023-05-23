class Solution {
    public int[] countBits(int n) {
        int dp[]=new int[4+n];
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
        dp[3]=2;
        int p=4;
       for(int i=4;i<=n;i++)
       {
           if(i!=4 && (i&i-1)==0)
            p=p*2;
           dp[i]=1+dp[i-p];
       }
        return Arrays.copyOfRange(dp,0,n+1);
    }

}
