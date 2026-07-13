class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;
        int l = 0;
        int h = (r*c)-1;
        while(l<=h)
        {
            int mid = l+(h-l)/2;

            if(matrix[mid/c][mid%c] == target)
                return true;
            else if(matrix[mid/c][mid%c] < target)
                    l = mid+1;
            else
                h = mid-1;

        }
        return false;
    }
}