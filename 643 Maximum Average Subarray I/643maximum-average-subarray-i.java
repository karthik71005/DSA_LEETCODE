class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int cursum = 0;
        int maxsum = 0;
        for(int i =0;i<k;i++) 
        {
            cursum+=nums[i];
        }
        maxsum = cursum;
        for( int i = k;i<nums.length;i++)
        {
            int left = i-k;
            cursum = cursum -nums[left]+nums[i];
            maxsum = Math.max(cursum,maxsum);
        }
        return (double)maxsum/k;
    }
}