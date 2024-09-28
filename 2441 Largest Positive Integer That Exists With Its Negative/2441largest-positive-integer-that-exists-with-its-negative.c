int findMaxK(int* nums, int numsSize) {
    int maxK = -1;

    // Iterate over the array to find pairs of k and -k
    for (int i = 0; i < numsSize; i++) {
        for (int j = 0; j < numsSize; j++) {
            if (nums[i] == -nums[j] && nums[i] > 0) {
                if (nums[i] > maxK) {
                    maxK = nums[i];
                }
            }
        }
    }

    return maxK;
    
}