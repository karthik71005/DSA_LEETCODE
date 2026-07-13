class Solution {
    public boolean judgeSquareSum(int c) {
        int n = (int)Math.sqrt(c);
        int [] nums = new int[n+1];
        for(int i =0;i<=n;i++)
        {
            nums[i] = i;
        }
        int left =0;
        int right = nums.length-1;
        while(left<=right)
        {  
             long sum = (long)(nums[left]*nums[left])+(long)(nums[right]*nums[right]);
             if(sum==c)
                return true;
             else if(sum<c)
                left++;
            else 
                right--;
        }
        return false;
        
    }
}