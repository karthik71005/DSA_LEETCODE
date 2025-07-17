bool check(int* nums, int numsSize) {
    int count=0;
    for(int i=0;i<numsSize-1;i++)
    {
        if(nums[i]>nums[i+1])
        {
            count++;
        }
   
    }
    if(nums[numsSize-1]>nums[0])
    {
        count++;
    }
    return count<=1;
    
}