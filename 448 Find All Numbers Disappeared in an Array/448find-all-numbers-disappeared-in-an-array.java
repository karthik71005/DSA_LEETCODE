class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer>ans= new ArrayList<>();
        for(int i =0;i<nums.length;i++)
        {
            int tI = Math.abs(nums[i])-1;

            if(nums[tI]>0)
            {
                nums[tI]=-nums[tI];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
            
                ans.add(i + 1);
            }
        
    }
    return ans;
}}