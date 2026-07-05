class Solution {
    public int maxProduct(int[] nums) {
        int minEnd = nums[0];
        int maxEnd = nums[0];
        int ans = nums[0];
        for(int i =1;i<nums.length;i++)
        {
            int v1 = nums[i];
            int v2 =nums[i]*minEnd;
            int v3 = nums[i]*maxEnd;
            minEnd = Math.min(v1,Math.min(v3,v2));
            maxEnd = Math.max(v1,Math.max(v2,v3));
            ans = Math.max(ans,Math.max(maxEnd,minEnd));
        }
        return ans;

    }
}