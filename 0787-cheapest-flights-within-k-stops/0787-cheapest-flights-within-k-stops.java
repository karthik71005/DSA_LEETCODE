import java.util.Arrays;

public class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Distance array initialized to infinity (1e8 is commonly used in competitive programming)
        int[] res = new int[n];
        Arrays.fill(res, (int) 1e8);
        res[src] = 0;

        // Perform relaxation at most (k + 1) times (allowing at most k stops)
        for (int i = 0; i <= k; i++) {
            // Create a temporary copy of the current distance array to prevent 
            // using updated distances from the current iteration
            int[] t = Arrays.copyOf(res, n);

            for (int[] flight : flights) {
                int s = flight[0];   // source node
                int d = flight[1];   // destination node
                int wt = flight[2];  // flight cost/weight

                // If source node is reachable and relaxing this edge gives a cheaper cost
                if (res[s] != 1e8 && res[s] + wt < t[d]) {
                    t[d] = res[s] + wt;
                }
            }

            // Update res with the newly computed costs for this level of stops
            res = t;
        }

        // Return the cost to reach 'dst' or -1 if unreachable
        return res[dst] == (int) 1e8 ? -1 : res[dst];
    }
}