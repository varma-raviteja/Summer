Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.

class Solution {
    int dp[][]=new int[1000+1][1000+1] ;
    public  int maxsub(String a,String b, int i,int j){
        if( i>=a.length() || j>=b.length()) return 0;
        
        if(dp[i][j]!=-1) return dp[i][j];
        
        if( a.charAt(i)==b.charAt(j)) return dp[i][j]=1+maxsub(a,b,i+1,j+1);
        
        else {
            return dp[i][j]=Math.max( maxsub(a,b,i+1,j)  , maxsub(a,b,i,j+1));
        }
    }
    public int longestCommonSubsequence(String a, String b) {
        for (int[] row: dp)
            Arrays.fill(row, -1);
        
        return maxsub(a,b,0,0);
    }
};
