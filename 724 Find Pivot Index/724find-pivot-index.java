class Solution {
    public int pivotIndex(int[] nums) {
        for(int i =1;i<nums.length;i++)
        {
            nums[i] = nums[i]+nums[i-1];
        }
       
         int ls,rs;
        int ts=nums[nums.length-1];
        // System.out.println(rs);
        
        for(int i =0;i<nums.length;i++)
        {
            if(i == 0)
            {
                ls =0;
            }else {
                ls = nums[i-1];
            }
            rs = ts-nums[i];
            if(ls == rs)
            {
                return i;
            }
            
            
            
        }
        return -1;
        
    }
}