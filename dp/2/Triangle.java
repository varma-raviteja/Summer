class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        int dp[][] =new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        return helper(triangle, 0,0,dp);
    }

    public static int helper(List<List<Integer>> triangle, int level, int index, int dp[][])
    {
        if(level>=triangle.size()) return 0;
        if(index>=triangle.get(level).size())
        return 0;
        if(dp[level][index]!=0)
        return dp[level][index];
        if(level==triangle.size()-1)
        return triangle.get(level).get(index);
        int left=helper(triangle, level+1, index,dp);
        int right=helper(triangle, level+1, index+1,dp);
        return dp[level][index]=Math.min(left,right)+triangle.get(level).get(index);
    }
}

class Solution {
    private Integer[][] memo;

public int minimumTotal(List<List<Integer>> triangle) {
	int n = triangle.size();
	memo = new Integer[n][n];
	return dfs(0, 0, triangle);
}

private int dfs(int level, int i, List<List<Integer>> triangle) {
	if (memo[level][i] != null) return memo[level][i];

	int path = triangle.get(level).get(i);
	if (level < triangle.size() - 1) 
		path += Math.min(dfs(level + 1, i, triangle), dfs(level + 1, i + 1, triangle));

	return memo[level][i] = path;
}
}
