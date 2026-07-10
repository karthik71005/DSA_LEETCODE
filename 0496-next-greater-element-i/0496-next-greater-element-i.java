import java.util.HashMap;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        
        // Process nums2 backwards
        for (int i = nums2.length - 1; i >= 0; i--) {
            int num = nums2[i];
            
            // Pop elements that are smaller than the current number
            while (!stack.isEmpty() && stack.peek() <= num) {
                stack.pop();
            }
            
            // If stack is empty, there's no greater element to the right
            if (stack.isEmpty()) {
                map.put(num, -1);
            } else {
                map.put(num, stack.peek());
            }
            
            // Push current element onto the stack
            stack.push(num);
        }
        
        // Build the result array for nums1 using our map
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }
        
        return ans;
    }
}