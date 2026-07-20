class Solution {
    int x[] ={-1,1,0,0};
    int y[] ={0,0,-1,1};
    private void dfs(int [][]isConnected,int n,int i, boolean[] visited)
    {
     for(int j = 0;j<n;j++)
     {
        if(isConnected[i][j]==1&&!visited[j])
        {
            visited[j]=true;
            dfs(isConnected,n,j,visited);
        }
     }
        return;
    }
 
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int res=0;
        boolean [] visited = new boolean[n];
        for(int i =0;i<n;i++)
        {
            if(!visited[i])
            {
                visited[i]=true;
                res++;
                dfs(isConnected,n,i,visited);
            }
        }

        return res;
        
    }
}