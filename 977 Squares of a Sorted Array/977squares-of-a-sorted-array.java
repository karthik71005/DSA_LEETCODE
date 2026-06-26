class Solution {
    public int[] sortedSquares(int[] nums) {
        int [] res = new int[nums.length];
        int left = 0 ;
        int index = nums.length-1;
        int right = nums.length-1;
        while(left<=right)
        {
            if(Math.abs(nums[left])<Math.abs(nums[right]))
            {
                res[index] = nums[right]*nums[right];
                right--;
                index--;

            }
            else{
                res[index] = nums[left]*nums[left];
                left++;
                index--;
            }
        }
        return res;

        
    }
}