//DFS

class Solution {
    public boolean dfs(int src,int parent,ArrayList<ArrayList<Integer>> adj,boolean visited[])
    {
        visited[src]=true;
        for(int x:adj.get(src))
        {
            if(!visited[x])
            {
                if(dfs(x,src,adj,visited)==true)return true;
            }
            else if(parent!=x)
            {
                return true;
            }
        }
        return false;
    }
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean visited[]=new boolean[V];
        for(int i=0;i<V;i++)
        {
            if(!visited[i])
            {
                if(dfs(i,-1,adj,visited)==true)return true;
            }
        }
        return false;
    }
}


//BFS
bool detect(int src,vector<int>adj[],int vis[]){
        vis[src]= 1;
        queue<pair<int,int>>q;
        q.push({src,-1});
        while(!q.empty()){
            int node= q.front().first;
            int parent= q.front().second;
            q.pop();
            for(auto adjentnode:adj[node])
            {
                if(!vis[adjentnode]){
                    vis[adjentnode]=1;
                    q.push({adjentnode,node});
                    
                }
                
                else if(parent!=adjentnode){
                    return true;
                }
            }
            
            
        }
        return false;
    }

