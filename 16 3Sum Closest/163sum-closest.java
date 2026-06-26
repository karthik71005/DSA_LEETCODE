class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int csum = nums[0]+nums[1]+nums[2];
        
        for(int i =0;i<nums.length-2;i++)
        {
            int left =i+1;
            int right = nums.length-1;
            if(i>0 && nums[i] == nums[i-1])
                continue;
            while(left<right)
            {
                int cursum = nums[left]+nums[right]+nums[i];
                if(cursum== target)
                {
                    return cursum;
                }
                if(Math.abs(cursum-target)<Math.abs(csum-target))
                {
                    csum = cursum;
                }
                if(cursum<target)
                    left++;
                else    
                    right--;
                
            }
            
        }
        return csum;
        
    }
}