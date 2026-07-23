class Solution {
    int [] x = {-1,1,0,0};
    int [] y = {0,0,-1,1};
    private boolean isValid(int row,int col,int n)
    {
        if(row<0||row>=n||col<0||col>=n)
            return false;
        return true;
    }
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int [][] dist =  new int[n][n];
        for(int i =0;i<n;i++)
        {
            for(int j =0;j<n;j++)
            {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = grid[0][0];
        pq.offer(new int[]{dist[0][0],0,0});
        while(!pq.isEmpty())
        {
            int [] curr =  pq.poll();
            int time =curr[0];
            int r = curr[1];
            int c=curr[2];
            if(r==n-1&&c==n-1)
                return time;
            if(time>dist[r][c])
                continue;
            for(int i =0;i<4;i++)
            {
                int nr =  r+x[i];
                int nc = c+y[i];
                if(isValid(nr,nc,n))
                {
                    int nextTime = Math.max(time,grid[nr][nc]);
                    if(nextTime<dist[nr][nc])
                    {
                        dist[nr][nc] = nextTime;
                        pq.offer(new int[]{nextTime,nr,nc});
                    }
                }
            }
        }
        return 0;
        
    }
}