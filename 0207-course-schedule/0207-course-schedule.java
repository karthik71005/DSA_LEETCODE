class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<numCourses;i++)
        {
            adj.add(new ArrayList<>());
        }
        int [] indegree = new int[numCourses];
        for(int i =0;i<prerequisites.length;i++)
        {
            int src = prerequisites[i][0];
            int dest = prerequisites[i][1];
            adj.get(src).add(dest); 
            indegree[dest]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i =0;i<numCourses;i++)
        {
            if(indegree[i]==0)
                q.offer(i);

        }
        if(q.size()==0)
            return false;
        int vis =0;
        while(!q.isEmpty())
        {
            vis++;
            int node = q.poll();

            for(int i =0;i<adj.get(node).size();i++)
            {
                int neigh = adj.get(node).get(i);
                indegree[neigh]--;
                if(indegree[neigh]==0)
                    q.offer(neigh);
            }
        }
        return numCourses==vis;
    }
}