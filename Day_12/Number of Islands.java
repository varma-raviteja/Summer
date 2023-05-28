class Solution {
    public int numIslands(char[][] grid) {
        int[][] visited=new int[grid.length][grid[0].length];

        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                visited[i][j]=0;
            }
        }
        int count=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]=='1' && visited[i][j]!=1)
                {
                    dfs(grid,visited,i,j);
                  
                    count++;
                    System.out.println(" ");
                }
            }
        }
    return count;
    }


    public static void dfs(char grid[][], int visited[][], int i, int j)
    {

        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || visited[i][j]==1 || grid[i][j]=='0')
        return;
        if(grid[i][j]=='1' && visited[i][j]==0)
            visited[i][j]=1;
        dfs(grid,visited,i+1,j);
        dfs(grid,visited,i,j+1);
        dfs(grid,visited,i-1,j);
        dfs(grid,visited,i,j-1);
    }
}
