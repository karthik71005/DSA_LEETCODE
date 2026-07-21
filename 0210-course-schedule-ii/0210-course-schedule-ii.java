class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int [] res = new int[numCourses];
        int j =0;
        for(int i =0;i<numCourses;i++)
        {
            adj.add(new ArrayList<>());
        }
        int [] indegree = new int[numCourses];
        for(int i =0;i<prerequisites.length;i++)
        {
            int src = prerequisites[i][0];
            int dest = prerequisites[i][1];
            adj.get(dest).add(src); 
            indegree[src]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i =0;i<numCourses;i++)
        {
            if(indegree[i]==0)
                q.offer(i);

        }
        if(q.size()==0)
            return new int[]{};
        // int vis =0;
        while(!q.isEmpty())
        {
            
            int node = q.poll();
            res[j++] = node;

            for(int i =0;i<adj.get(node).size();i++)
            {
                int neigh = adj.get(node).get(i);
                indegree[neigh]--;
                if(indegree[neigh]==0)
                    q.offer(neigh);
            }
        }
        if(j== numCourses)
            return res;
        return new int[]{};
    }
}