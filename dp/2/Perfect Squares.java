Given an integer n, return the least number of perfect square numbers that sum to n.

A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. 
For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.


public int numSquares(int n) {
	if (n < 4)
		return n;
	
	int ans = n;
	
	for (int i = 1; i * i <= n; i++) {
		int square = i * i;
		ans = Math.min(ans, 1 + numSquares(n - square));
	}
	
	return ans;
}


// Time complexity: O(N * sqrt(N))
// Space complexity: O(N)
	
class Solution {
    public int numSquares(int n) {
        int[] memo = new int[n + 1];
        return helper(n, memo);
    }
    
    public int helper(int n, int[] memo) {
        if (n < 4)
            return n;
        
        if (memo[n] != 0)
            return memo[n];
        
        int ans = n;
        
        for (int i = 1; i * i <= n; i++) {
            int square = i * i;
            ans = Math.min(ans, 1 + helper(n - square, memo));
        }
        
        return memo[n] = ans;
    }
}


// Time complexity: O(N * sqrt(N))
// Space complexity: O(N)
	
class Solution {
    public int numSquares(int n) {
        int[] memo = new int[n + 1];
        return helper(n, memo);
    }
    
    public int helper(int n, int[] memo) {
        if (n < 4)
            return n;
        
        if (memo[n] != 0)
            return memo[n];
        
        int ans = n;
        
        for (int i = 1; i * i <= n; i++) {
            int square = i * i;
            ans = Math.min(ans, 1 + helper(n - square, memo));
        }
        
        return memo[n] = ans;
    }
}
