class Pair{
    int neigh;
    int weight;
    Pair(int neigh,int weight)
    {
        this.neigh= neigh;
        this.weight= weight;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i =0;i<=n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i =0;i<times.length;i++)
        {
            adj.get(times[i][0]).add(new Pair(times[i][1],times[i][2]));
        }
        int [] distance = new int[n+1];
        for(int i=0;i<=n;i++)
        {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[k] =0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0,k});
        while(!pq.isEmpty())
        {
            int [] temp =pq.poll();
            int dist = temp[0];
            int node = temp[1];
            if(dist>distance[node])
                continue;
            for(int i =0;i<adj.get(node).size();i++)
            {
                Pair t = adj.get(node).get(i);
                int neigh = t.neigh;
                int w = t.weight;
                if(dist+w<distance[neigh])
                {
                    distance[neigh] = dist+w;
                    pq.offer(new int[]{distance[neigh],neigh});
                }
            }

        }

        int max=0;
        for(int i =1;i<distance.length;i++)
        {
            if(distance[i]==Integer.MAX_VALUE)
                return -1;
            max = Math.max(max, distance[i]);
        }
   
    return max;
    }
}