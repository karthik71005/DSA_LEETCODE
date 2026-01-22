class Solution {
    public int findDuplicate(int[] nums) {
       int slow =nums[0];
       int fast = nums[0];
       do {
        slow=nums[slow];
        fast =nums[nums[fast]];
       }while(slow!=fast);
       slow = nums[0]; // Start from the beginning
        while (slow != fast) {
            slow = nums[slow]; // Move slow by 1 step
            fast = nums[fast]; // Move fast by 1 step
        }
       return slow;
    }
}