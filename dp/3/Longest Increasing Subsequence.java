class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[]=new int[nums.length];
        dp[nums.length-1]=1;

        int maxsofar=1;
        for(int i=nums.length-2;i>=0;i--)
        {
            int max=Integer.MIN_VALUE;
            for(int j=i;j<nums.length;j++)
            {
                if(nums[i]<nums[j])
                {
                    max=Math.max(max,1+dp[j]);
                }
            }
            dp[i]=Math.max(1,max);
            maxsofar=Math.max(maxsofar,dp[i]);

        }
        return maxsofar;
    }
}
