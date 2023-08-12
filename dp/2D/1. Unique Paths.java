There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.
    
class Solution {
    public int uniquePaths(int m, int n) {
       int dp[][]=new int[m+1][n+1];
      return helper(dp,0,0,m,n);
    }
    static int helper(int dp[][],int i,int j,int m,int n){
         if(i>=m || j>=n){
            return 0;
         }
        if(i==m-1 && j==n-1){
            return 1;
        }
       
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        int r=helper(dp,i+1,j,m,n);
        int c=helper(dp,i,j+1,m,n);
        return dp[i][j]=r+c;
        
    }
}
