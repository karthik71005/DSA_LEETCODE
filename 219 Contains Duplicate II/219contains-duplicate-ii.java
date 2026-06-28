class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            // 1. If the window is larger than k, evict the oldest element
            if (i > k) {
                window.remove(nums[i - k - 1]);
            }
            
            // 2. Try to add the current element. 
            // .add() returns false if the element already exists in the Set!
            if (!window.add(nums[i])) {
                return true;
            }
        }
        
        return false;
    }
}