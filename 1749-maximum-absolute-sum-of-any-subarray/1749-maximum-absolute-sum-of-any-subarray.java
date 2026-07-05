class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int cS = nums[0];
        int mS= nums[0];
        int minSum = nums[0];
        int res =Math.abs(nums[0]);
        int cMinSum = nums[0];
        for(int i =1;i<nums.length;i++)
        {
            cS = Math.max((nums[i]),(cS+nums[i]));
            mS =Math.max(mS,cS);

            cMinSum = Math.min(nums[i],cMinSum+nums[i]);

            minSum =Math.min(minSum,cMinSum);
            res = Math.max(res,Math.max(Math.abs(mS),Math.abs(minSum)));

        }
        return res;
    }
}