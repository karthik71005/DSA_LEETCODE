class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int low =0;
        int high = intervals.length-1;
        int tI = intervals.length;
        
 
  
        while(low<=high)
        {
            int mid =low + (high-low)/2;
            if(intervals[mid][0]>=newInterval[0])
            {
                tI = mid;
                high = mid-1;
            }else{
                low=mid+1;
            }
        }
        
        List <int[]>temp = new ArrayList<>();
        for(int i =0;i<intervals.length;i++)
        {
            if(i == tI)
            {
                temp.add(newInterval);
                temp.add(intervals[i]);
            }
            else{
                temp.add(intervals[i]);
            }
        }
        if(tI == intervals.length)
        {
            temp.add(newInterval);
        }
        
        List <int []>res = new ArrayList<>();
        int start = temp.get(0)[0];
        int end = temp.get(0)[1];

        for(int [] row :temp)
        {
            int s = row[0];
            int e = row[1];
            if(end>=s)
            {
                end = Math.max(end,e);
    
            }
            else
            {
                res.add(new int []{start,end});
                start =s;
                end = e;
            }

        }     
        res.add(new int[]{start,end});
            return res.toArray(new int[res.size()][]);  
    }
}