class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            int src = edges[i][0];
            int dest = edges[i][1];

    
            boolean[] visited = new boolean[n + 1];
            if (hasPath(adj, src, dest, visited)) {
    
                return edges[i]; 
            }

            adj.get(src).add(dest);
            adj.get(dest).add(src);
        }

        return new int[0];
    }

    private boolean hasPath(List<List<Integer>> adj, int curr, int target, boolean[] visited) {
        if (curr == target) return true;
        visited[curr] = true;

        for (int neigh : adj.get(curr)) {
            if (!visited[neigh]) {
                if (hasPath(adj, neigh, target, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}