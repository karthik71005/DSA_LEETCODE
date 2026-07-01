import java.util.*;

class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        
        // Edge cases: if start or end has a thief, safeness factor is 0
        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) {
            return 0;
        }

        int[][] distToThief = new int[n][n];
        for (int[] row : distToThief) Arrays.fill(row, -1);
        
        Queue<int[]> queue = new LinkedList<>();
        
        // Phase 1: Multi-source BFS from all thieves
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid.get(r).get(c) == 1) {
                    queue.offer(new int[]{r, c});
                    distToThief[r][c] = 0;
                }
            }
        }
        
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1];
            
            for (int[] dir : directions) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && distToThief[nr][nc] == -1) {
                    distToThief[nr][nc] = distToThief[r][c] + 1;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
        
        // Phase 2: Dijkstra to maximize the minimum safeness factor
        // Max-heap stores: [safeness_so_far, r, c]
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        boolean[][] visited = new boolean[n][n];
        
        maxHeap.offer(new int[]{distToThief[0][0], 0, 0});
        visited[0][0] = true;
        
        while (!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();
            int maxSafe = curr[0], r = curr[1], c = curr[2];
            
            // If we reached the bottom-right corner, return the answer
            if (r == n - 1 && c == n - 1) {
                return maxSafe;
            }
            
            for (int[] dir : directions) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    // The safeness of the path to the neighbor is limited by the neighbor's safety
                    int nextSafe = Math.min(maxSafe, distToThief[nr][nc]);
                    maxHeap.offer(new int[]{nextSafe, nr, nc});
                }
            }
        }
        
        return 0;
    }
}