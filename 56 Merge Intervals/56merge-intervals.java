class Solution {
    public int[][] merge(int[][] intervals) {
     Arrays.sort(intervals,(a,b)->a[0]-b[0]);
     
     ArrayList<int []>result = new ArrayList<>();
     int [] newinterval = intervals[0];
     result.add(newinterval);
     for(int [] interval:intervals)
     {
        if(interval[0]<=newinterval[1])
        {
            newinterval[1]=Math.max(interval[1],newinterval[1]);

        }
        else
        {
            newinterval = interval;
            result.add(newinterval);
        }

     }
     int [][] ans = new int[result.size()][];

     for (int i =0 ;i<result.size();i++)
     {
        ans[i]= result.get(i);
     }
     return ans;

    }
}