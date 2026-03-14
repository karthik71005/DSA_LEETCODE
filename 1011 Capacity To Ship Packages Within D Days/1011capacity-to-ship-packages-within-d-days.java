class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low =0;
        int high=0;
        

        for(int w:weights){
            low = Math.max(low,w);
            high+=w;
        }
        while(low<high){
            int cl=0;
            int Rd=1;
            int mid=(low+high)/2;
            
            for(int w:weights){
                if((cl+w)>mid){
                    Rd++;
                    cl=0;
                }
                cl+=w;
            }
            if(Rd<=days){
                high=mid;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}