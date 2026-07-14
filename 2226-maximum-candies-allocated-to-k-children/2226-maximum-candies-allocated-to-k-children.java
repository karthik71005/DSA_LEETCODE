class Solution {
    public int maximumCandies(int[] candies, long k) {
        long low =1;
        long high  =0;
        for(int c:candies)
            high = Math.max(high,c);
        long ans=0;
        while(low<=high)
        {
            long mid = low +(high-low)/2;
            long totalPiles =0;
            for(int c : candies)
            {
                totalPiles +=c/mid;
            }
            if(totalPiles>=k)
            {
                ans =mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return (int)ans;
    }
}