class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair<Integer,Integer>> q=new LinkedList<>();
        int time=-1;
        int freshoranges=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==2)
                    q.add(new Pair(i,j));
                if(grid[i][j]==1)
                    freshoranges++;
            }
        }
        
        int dirs[][]={{1,0},{0,1},{-1,0},{0,-1}};
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int j=0;j<size;j++)
            {
                Pair<Integer,Integer> cell=q.poll();
                int x=cell.getKey();
                int y=cell.getValue();
                for(int i=0;i<4;i++)
                {
                    int nc=x+dirs[i][0];
                    int ny=y+dirs[i][1];
                    if(nc<0 || ny<0 || nc>=grid.length || ny>=grid[0].length)
                        continue;
                    if(grid[nc][ny]==0)
                    {
                        continue;
                    }
                    if(grid[nc][ny]==1)
                    {
                        q.add(new Pair(nc,ny));
                        grid[nc][ny]=-1;
                        freshoranges--;
                    }
                        
                }
            }
            time++;
           

        }

        if(freshoranges!=0)
            return -1;
        if(time==-1)
            return 0;

        return time;
    }
}
