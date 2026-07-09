class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer,Integer> freq = new HashMap<>();
        for(int num:nums)
            freq.put(num,freq.getOrDefault(num,0)+1);

        int [] temp = new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            temp[i] = freq.get(nums[i]);
        }
        for(int i = 0;i<nums.length;i++)
        {
            int minIndex = i;
            for(int j = i+1;j<nums.length;j++)
            {
                if(temp[minIndex]>temp[j]||(temp[minIndex]==temp[j]&&nums[minIndex]<nums[j]))
                {
                    minIndex=j;
                }
            }
                if(minIndex!=i)
                {
                    int tem = nums[i];
                    nums[i]=nums[minIndex];
                    nums[minIndex] = tem;

                    tem=temp[i];
                    temp[i]=temp[minIndex];
                    temp[minIndex]=tem;
                }
            
        }
        return nums;
    }
}