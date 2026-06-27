class Solution {
    public int maxArea(int[] height) {
       int left =0;
       int right = height.length-1;
       int min = 0;
       int cn =0;
       while(left<right)
       {
        if(height[left]<height[right])
        {
            cn = height[left]*(right-left);  
            left++; 
        }
        else {
            cn = height[right]*(right-left);    
            right--;
        }
        min = Math.max(cn,min);
        
       }

        return min;
        
    }
}