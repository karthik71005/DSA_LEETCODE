class Solution {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer>ans = new HashSet<>();
        for(int num:nums)
        {
                ans.add(num);
                int temp =num;
                int count=0;
                while(temp>0)
                {
                    int dig = temp%10;
                    count =count*10+dig;
                    temp=temp/10;
                }
                ans.add(count);
        }
        return ans.size();
        
    }
}