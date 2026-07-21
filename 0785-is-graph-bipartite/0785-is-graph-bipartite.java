class Solution {
    private boolean res = true;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int [] colored = new int[n];
        for(int i =0;i<n;i++)
        {
            colored[i]=-1;
        }
        for(int i =0;i<n;i++)
        {
            if(colored[i] == -1)
                dfs(graph,i,0,colored);
        }
        return res;
        
    }
    private void dfs(int[][] graph,int node,int c,int []colored)
    {
        colored[node] =c;
        for(int i=0;i<graph[node].length;i++)
        {
            int neigh = graph[node][i];
            if(colored[neigh]!=-1&&colored[neigh]==c)
            {
                res = false;
            }
            if(colored[neigh]==-1)
            {
                dfs(graph,neigh,1-c,colored);
            }
        }
    }
}