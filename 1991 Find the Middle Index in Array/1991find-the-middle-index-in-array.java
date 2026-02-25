class Solution {
    public int findMiddleIndex(int[] nums) {

        int ts =0;
        for(int num:nums)
        {
            ts +=num;
        }
        int ls =0,rs;
        for(int i =0;i<nums.length;i++)
        {
            rs = ts - ls - nums[i];
            if(rs == ls)
            {
                return i;
            }
            else
            ls = ls+nums[i];
        }
        return -1;
        
    }
}