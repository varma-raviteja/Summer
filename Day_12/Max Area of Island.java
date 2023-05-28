class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int[][] directions = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int area = 0;
        // loop grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // start from new 1's that we haven't explored
                if (grid[i][j] == 1 && !visited[i][j]){
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j}); // add initial element
                    visited[i][j] = true;
                    int island = 0;
                    while (!q.isEmpty()) {
                        int[] curr = q.poll(); // take from queue every time
                        island++; // increase area of island, whenever we explore a new cell
                        
                        // loop directions
                        for (int[] dir: directions) {
                            // add directions for x and y
                            int x = curr[0] + dir[0];
                            int y = curr[1] + dir[1];
                            if (x < 0 || x > grid.length-1 || y < 0 || y > grid[0].length-1 || visited[x][y] || grid[x][y] == 0) { // boundary cases
                                continue;
                            }
                            q.add(new int[]{x, y});
                            visited[x][y] = true;
                        }
                    }                    
                    area = Math.max(area, island); // take max area
                }
            }
        }
        return area;
    }
}





class Solution {

    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) 
                  ans = Math.max(dfs(grid, i, j, m, n, new int[] { 0 }), ans);
            }
        }
        return ans;
    }

    public int dfs(int[][] grid, int i, int j, int m, int n, int[] count) {
        if (
            i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0
        ) return count[0];
        count[0]++;
        grid[i][j] = 0;
        dfs(grid, i - 1, j, m, n, count);
        dfs(grid, i + 1, j, m, n, count);
        dfs(grid, i, j - 1, m, n, count);
        dfs(grid, i, j + 1, m, n, count);
        return count[0];
    }
}
