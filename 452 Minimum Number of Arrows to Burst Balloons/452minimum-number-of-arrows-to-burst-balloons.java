class Solution {
    public int findMinArrowShots(int[][] points) {
        //  Arrays.sort(points,(a,b)-> Integer.compare(a[0]-b[0]));
     Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
     ArrayList<int []>result = new ArrayList<>();
     int k =1;
     int [] newinterval = points[0];
     for(int i = 1;i<points.length;i++)
     {
        int [] curr = points[i];

        if(newinterval[1]>=curr[0])
        {
            // k++;
            newinterval[0] = curr[0];
            newinterval[1] = Math.min(curr[1],newinterval[1]);
        }
        else 
        {
            k++;
            newinterval = curr;
        }
     }
     return k;
    }
}