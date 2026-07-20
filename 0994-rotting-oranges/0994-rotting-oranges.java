class Solution {
    int [] x ={-1,1,0,0};
    int [] y ={0,0,-1,1};
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q= new LinkedList<>();
        int m = grid.length;
        int minute=0;
        int n = grid[0].length;
        int freshCount =0;
        for(int i =0;i<m;i++)
        {
            for(int j =0;j<n;j++)
            {
                if(grid[i][j]==2)
                {
                    q.offer(new int[]{i,j});
                }
                else if(grid[i][j]==1)
                {
                    freshCount++;
                }
            }

        }
        if(freshCount == 0)
            return 0;
        while(!q.isEmpty()&&freshCount>0)
        {
            int z = q.size();
            for(int i=0;i<z;i++)
            {
                int [] temp = q.poll();
                for(int k =0;k<4;k++)
                {
                    int row = temp[0]+x[k];
                    int col = temp[1]+y[k];
                    if(isValid(row,col,m,n)&&grid[row][col]==1)
                    {
                        freshCount--;
                        grid[row][col] =2;
                        q.offer(new int[]{row,col});
                    }

                }
            }
            minute++;

        }

        return freshCount==0?minute:-1;
        
    }
    private boolean isValid(int row,int col,int m,int n)
    {
        if(row<0||row>=m||col<0||col>=n)
            return false;
        return true;
    }
}