class Solution {
    public static int rob(int[] nums) {
        if (nums.length==1)
            return nums[0];
        if (nums.length==2)
            return Math.max(nums[0],nums[1] );
        int[] dp=new int[nums.length];
        int[] dp2=new int[nums.length];
        Arrays.fill(dp,-1);
        Arrays.fill(dp2,-1);
        int ans=fun(nums,nums.length-2,dp, 0);
        int ans2=fun(nums,nums.length-1,dp2, 1);
        return Math.max(ans2, ans);
    }
    public static int fun(int[] nums, int i, int[] dp,int stop){
        if (i== stop) {
            return nums[stop];
        }
        if (i<stop)
            return 0;
        if (dp[i]!=-1)
            return dp[i];
        int pick=nums[i] + fun(nums, i-2, dp, stop);
        int notpick=0+fun(nums, i-1, dp,stop);
        return dp[i]=Math.max(pick, notpick);
    }
}




class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)    return nums[0];
        if(nums.length == 2)    return Math.max(nums[0], nums[1]);
        
        // 1st option: including the 1st and excluding the last house
        int resultWithFirst = solve(nums, 0, nums.length - 2);
        // 2nd option: excluding the 1st and including the last house
        int resultWithLast = solve(nums, 1, nums.length - 1);
        
        // Return the maximum of the two results
        return Math.max(resultWithFirst, resultWithLast);
    }
    
    public int solve(int[] nums, int start, int end){        
        if(start == end)    return nums[start];
        
        // Array to store the maximum sum at the current iteration
        // while traversing all houses
        int money[] = new int[nums.length];
        
        /* Base case */
        money[start] = nums[start];
        
        // At the 2nd house, we decide to rob
        // either the 1st house or the 2nd
        // This is the core idea of the transition function
        money[start + 1] = Math.max(nums[start + 1], nums[start]);
        
        for (int i = start + 2; i <= end; ++i)
            /* At ith house we have two options:
             1. not rob it, keeping the money from the (i-1)th house
             2. rob it after the (i-2)th house, skipping the (i-1)th house
              We choose the one that gives the max amount */
            money[i] = Math.max(money[i - 1], money[i - 2] + nums[i]);
        
        // Return the sum that we have at the last house
        return money[end];
    }
}
