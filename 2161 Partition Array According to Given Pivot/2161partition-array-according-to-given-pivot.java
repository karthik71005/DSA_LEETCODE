class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
       int n =nums.length;
       int [] res = new int [nums.length];
       int left = 0;
        int right =nums.length-1;

        for(int i = 0, j =n-1;i<n;i++,j--)
        {
            if(nums[i]<pivot)
            {
                res[left++] = nums[i];
            }
            if(nums[j]>pivot)
            {
                res[right--] = nums[j];
            }
        }
        while(left<=right)
        {
            res[left++] = pivot;
        }
        return res;
        
    }
}