class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int sum =0;
        for(int num:nums)
        {
            sum+=num;
        }   
        int currentMaxSum = nums[0];
        int currentMinSum =nums[0];
        int res = nums[0];
        int k =0;
        int maxGlobal =nums[0];
        int minGlobal = nums[0];

        for(int i =1;i<nums.length;i++)
        {
            currentMaxSum = Math.max(nums[i],currentMaxSum+nums[i]);
            maxGlobal = Math.max(maxGlobal,currentMaxSum);

            currentMinSum = Math.min(nums[i],currentMinSum+nums[i]);
            minGlobal = Math.min(minGlobal,currentMinSum);

        }

        if(maxGlobal <0)
            return maxGlobal;
        return Math.max(maxGlobal ,sum-minGlobal);
        
    }
}