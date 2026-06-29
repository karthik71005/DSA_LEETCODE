class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int csum =0;
        int wL=0;
        int flag=0;
        int mL=Integer.MAX_VALUE;

        while(right<nums.length)
        {
            csum = csum +nums[right];
            if(csum>=target)
            {
                while(csum>=target)
                {
                    wL = right-left+1;
                    mL = Math.min(wL,mL);
                    flag=1;
                    csum =csum-nums[left];
                    left++;
                }

            }
            right++;
        }
        if(flag==1)
            return mL;
        return 0;
    }
}