class Solution {
    int []x= {-1,1,0,0};
    int []y={0,0,-1,1};
    private boolean isValid(int i,int j,int n,int m)
    {
        if(i<0||i>=n||j<0||j>=m)
            return false;
        return true;
    }
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int n =  heights.length;
        int m = heights[0].length;
        int [][] dist =  new int [n][m];
        for(int i =0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        dist[0][0] =0;
        
        pq.offer(new int []{0,0,0});
        while(!pq.isEmpty())
        {
            int [] temp = pq.poll();
            int effort = temp[0];
            int i = temp[1];
            int j =temp[2];
            if (i == n - 1 && j == m - 1) {
                return effort;
            }
            if(effort>dist[i][j])
                continue;
            for(int k =0;k<4;k++)
            {
                int row = i+x[k];
                int col = j+y[k];
                if(isValid(row,col,n,m))
                {
                    int diff = Math.abs(heights[row][col]-heights[i][j]);
                    int newEffort = Math.max(diff,effort);
                    if(newEffort<dist[row][col])
                    {
                        dist[row][col] = newEffort;
                        pq.offer(new int[]{newEffort,row,col});
                    }

                }
            }

        }
     return 0;   
        
    }
}