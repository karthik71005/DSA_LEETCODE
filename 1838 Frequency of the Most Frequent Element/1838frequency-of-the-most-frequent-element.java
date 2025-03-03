class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);  // Sort the array
        int left = 0, ans = 0;
        long sum = 0;  // Use long to prevent overflow

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];  // Add current number to sum

            // Check if we can make all elements in window [left, right] equal to nums[right]
            while ((long) nums[right] * (right - left + 1) > sum + k) {
                sum -= nums[left];  // Remove leftmost element from sum
                left++;  // Shrink the window
            }

            ans = Math.max(ans, right - left + 1);  // Update max frequency
        }
        return ans;
    }
}