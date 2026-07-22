class Pair{
    int node;
    int distance;
 Pair(int node,int distance)
    {
        this.node = node;
        this.distance = distance;
    }
}


class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

         int [] distance =  new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i =0;i<edges.length;i++)
        {
            int s = edges[i][0];
            int d =edges[i][1];
            adj.get(s).add(d);
            adj.get(d).add(s);
        }
        boolean [] visited = new boolean[n];
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(source,0));
        visited[source]=true;
        while(!q.isEmpty())
        {
            Pair current = q.poll();
            int u = current.node;
            int dist = current.distance;
            if(u ==destination)
            {
                return true;
            }
            for(int i =0;i<adj.get(u).size();i++)
            {
                int neigh =adj.get(u).get(i);
                if(!visited[neigh])
                {
                    visited[neigh]=true;
                    q.offer(new Pair(neigh,dist+1));
                }
            }
        }
        return false;
    }
}