class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int [] ans = new int[nums.length];
        int n =  nums.length;
        Deque<Integer>stack= new ArrayDeque<>();
        for(int i =n-1;i>=0;i--)
        {
            while(!stack.isEmpty()&&stack.peek()<=nums[i])
                stack.pop();
            
            stack.push(nums[i]);
        }
        for(int j = n-1;j>=0;j--)
        {
            while(!stack.isEmpty() && stack.peek()<=nums[j])
            {
                stack.pop();
            }
            if(stack.isEmpty())
            {
                ans[j] = -1;
            
            }
            else{
                ans[j] = stack.peek();
                
            }
            stack.push(nums[j]);
        }



        return ans;
        
    }
}