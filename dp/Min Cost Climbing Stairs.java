
You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.




// Recursive Top Down - O(2^n) Time Limit Exceeded
public int minCostClimbingStairs(int[] cost) {
	int n = cost.length;
	return Math.min(minCost(cost, n-1), minCost(cost, n-2));
}
private int minCost(int[] cost, int n) {
	if (n < 0) return 0;
	if (n==0 || n==1) return cost[n];
	return cost[n] + Math.min(minCost(cost, n-1), minCost(cost, n-2));
}


class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] memo = new int[cost.length];
        
        return Math.min(rec(cost, 0, memo), rec(cost, 1, memo));
    }
    
    int rec(int[] cost, int index, int[] memo) {
       if(index >= cost.length)
           return 0;
        
        if(memo[index] == 0) {
            memo[index] = Math.min(rec(cost, index + 1, memo), rec(cost, index + 2, memo));
        }
        
        return cost[index] + memo[index];
    }
}


class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int dp[]=new int[cost.length+1];
        dp[cost.length-1]=cost[cost.length-1];
        for(int i=cost.length-2;i>=0;i--)
        {
            if(i==cost.length-2)
            {
                dp[i]=cost[i];
            }else
            {
                dp[i]=cost[i]+Math.min(dp[i+1],dp[i+2]);
            }
        }
        return Math.min(dp[0],dp[1]);
    }
}
