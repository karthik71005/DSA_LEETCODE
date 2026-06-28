class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findBoundary(nums,target,true);
        if(first == -1)
        {
            return new int []{-1,-1};
        }
        int last = findBoundary(nums,target,false);
        return new int []{first,last};
        
    }
    private int findBoundary(int [] nums,int target ,boolean isFirst)
    {
        int left = 0;
        int right = nums.length-1;
        int mid =0;
        int index =-1;
        while(left<=right)
        {
            mid =left+(right-left)/2;
            if(nums[mid]==target)
            {
                index =mid;
                if(isFirst)
                {
                    right= mid-1;
                }
                else{
                    left = mid+1;
                }
            }else if(nums[mid]<target)
            {
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return index;
    }
}