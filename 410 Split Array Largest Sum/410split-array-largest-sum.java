class Solution {
    public int splitArray(int[] nums, int k) {
        int low=0;
        int high=0;
        for(int n:nums){
            low=Math.max(low,n);
            high +=n;
        }

        while(low<high){
            int part=1;
            int sum=0;
            int mid=(low+high)/2;
            for(int n:nums){
                if(sum+n>mid){
                    part++;
                    sum=0;
                }
                sum+=n;
            }
        
        if(part<=k){
            high=mid;
        }
        else {
            low=mid+1;
        }
        }
        return low;
        
    }
}