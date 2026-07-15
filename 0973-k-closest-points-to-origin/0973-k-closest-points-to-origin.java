class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue <Integer> pq = new PriorityQueue<>((a,b)->distance(points[b])-distance(points[a]));

        for(int i =0;i<points.length;i++)
        {
            pq.offer(i);
           if(pq.size()>k)
           {
            pq.poll();
    
           }
            

        }
        int [][] ans = new int[k][2];
        for(int i =0;i<k;i++)
        {
           ans[i] = points[pq.poll()];
        }
        return ans;
    }
    public int distance(int [] point)
    {
        int firstNum = point[0]*point[0];
        int secondNum = point[1]*point[1];
        return firstNum+secondNum;
    }
}