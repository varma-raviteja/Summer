You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, 
the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it 
will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob 
tonight without alerting the police.

class Solution {
    public int rob(int[] nums) {
        return maxMoney(nums, nums.length - 1);
    }
    static int maxMoney(int[] nums, int i) {
        if(i < 0) {
            return 0;
        }
        if(i == 0) {
            return nums[0];
        }
        int include = maxMoney(nums, i - 2) + nums[i];
        int exclude = maxMoney(nums, i - 1);
        return Math.max(include, exclude);
    }
}

class Solution {
    public int rob(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        
        return compute(nums,map,0);
    }
    int compute( int[] nums,HashMap<Integer,Integer> map,int n)
    {
        if(n>=nums.length) return 0;
        if(map.containsKey(n))
        {
            return map.get(n);
        }
        map.put(n,Math.max(nums[n]+compute(nums,map,n+2),compute(nums,map,n+1)));
        return map.get(n);
    }
}

class Solution {
    public int rob(int[] nums) {

        int size = nums.length;
        int[] dp = new int[size];
        dp[0] = nums[0];

        if(dp.length > 1) {
            dp[1] = Math.max(nums[1], nums[0]);
        }

        for(int i = 2; i < size; i++) {
            int include = dp[i - 2] + nums[i];
            int exclude = dp[i - 1];
            dp[i] = Math.max(include, exclude);
        }
        return dp[size - 1];
    }
}
