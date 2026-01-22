class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int k = nums.length/3;
        int count;
        ArrayList<Integer>list = new ArrayList<>();
        for(int i =0;i<nums.length;i++)
        {
            count = 0;
            for(int j =0 ;j<nums.length;j++)
            {
                if(nums[i]==nums[j])
                {
                    count++;
                }
            }
            if(count>nums.length/3 && (!list.contains(nums[i])))
            {
                list.add(nums[i]);
            }
        }
        return list;
    }
}