class Solution {
    public int longestOnes(int[] nums, int k) {
        int left =0;
        int zC=0;
        int mL=0;
        for(int right =0;right<nums.length ;right++)
        {
            if(nums[right]==0)
            {
                zC++;
            }
            while(zC>k){
                if(nums[left]==0)
                {
                    zC--;
                }
                left++;
            }
            mL=Math.max(mL,right-left+1);
        }
        return mL;
    }
}