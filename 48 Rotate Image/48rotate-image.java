class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int k=0;
        int [] arr = new int [m*n];
        for (int j =0;j<n;j++) 
        {
            for (int i =m-1;i>=0;i--)
            {
                arr[k++]=matrix[i][j];
            }
        }
         k =0;
        for(int i = 0;i<m;i++)
        {
            for(int j =0;j<n;j++)
            {
                matrix[i][j] = arr[k++];
            }
        }
        
    }
}