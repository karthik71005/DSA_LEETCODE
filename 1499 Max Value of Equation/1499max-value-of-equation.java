class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int n = points.length;
        int[] vals = new int[n];  // store yi - xi
        int[] xs = new int[n];    // store xi
        int front = 0, rear = 0;  // deque pointers
        
        int res = Integer.MIN_VALUE;

        for (int j = 0; j < n; j++) {
            int xj = points[j][0];
            int yj = points[j][1];

            // Remove points out of window (xj - xi > k)
            while (front < rear && xj - xs[front] > k) {
                front++;
            }

            // If we have a valid candidate, calculate result
            if (front < rear) {
                res = Math.max(res, yj + xj + vals[front]);
            }

            int val = yj - xj;

            // Maintain deque in decreasing order of vals
            while (front < rear && vals[rear - 1] <= val) {
                rear--;
            }

            // Add current point
            vals[rear] = val;
            xs[rear] = xj;
            rear++;
        }

        return res;
    }
}
