class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        ArrayList <int []>result = new ArrayList<>();
       
        
        boolean insert = false;
        for(int [] interval:intervals)
        {
            if(interval[1]<newInterval[0])
            {
                
                result.add(interval);
            }
            else if(newInterval[1]<interval[0])
            {
                if (!insert) {
                    result.add(newInterval);
                    insert = true;
                }
                result.add(interval);
            }
            else 
            {
                newInterval[1]= Math.max(newInterval[1],interval[1]);
                newInterval[0] =Math.min(newInterval[0],interval[0]);
            }
           
        }
        if(!insert){
            result.add(newInterval);
        }
        int [][] ans = new int[result.size()][];
        for(int i =0;i<result.size();i++)
        {
            ans[i] = result.get(i);
        }
        return ans;
    }
}