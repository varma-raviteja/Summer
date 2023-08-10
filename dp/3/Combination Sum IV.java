Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.

The test cases are generated so that the answer can fit in a 32-bit integer.

class Solution {
    public int combinationSum4(int[] nums, int target) {
        Integer[] memo = new Integer[target + 1];
        return recurse(nums, target, memo);
    }
    
    public int recurse(int[] nums, int remain, Integer[] memo){
        
        if(remain < 0) return 0;
        if(memo[remain] != null) return memo[remain];
        if(remain == 0) return 1;
        
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            ans += recurse(nums, remain - nums[i], memo);
        }
        
        memo[remain] = ans;
        return memo[remain];
    }
}
