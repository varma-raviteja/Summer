You are given an integer array nums and an integer target.

You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then 
  concatenate all the integers.

For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.
  
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return sum(nums, target, 0,0);
    }
    public int sum(int[] nums, int target, int ans, int index)
    {
       if(index == nums.length && ans != target) return 0;
        if(index == nums.length && ans == target){
            return 1;
        }
        int count=0;
        count+=sum(nums,target,ans-nums[index],index+1);
       
        count+=sum(nums,target,ans+nums[index],index+1);
        return count;
    }
}



class Solution {
    int total = 0;
    public int findTargetSumWays(int[] nums, int target) {
        for(int a : nums){
            total += a;
        }
        int dp[][]=new int[nums.length+1][total*2+1];
        return sum(nums, target, 0,0,dp);
    }
    public int sum(int[] nums, int target, int ans, int index, int dp[][])
    {
       if(index == nums.length && ans != target) return 0;
        if(index == nums.length && ans == target){
            return 1;
        }
        if(dp[index][ans+total]!=0) return dp[index][ans+total]; 
        int count=0;
        count+=sum(nums,target,ans-nums[index],index+1,dp);
       
        count+=sum(nums,target,ans+nums[index],index+1,dp);

        return dp[index][ans+total]=count;


    }
}

