class Solution {
    public int findMaxLength(int[] nums) {
        int oneCount=0;
        int zeroCount = 0;
        int maxLen=0;
        HashMap <Integer,Integer> freq= new HashMap<>();
        // freq.put(0,-1);
        for(int i =0;i<nums.length;i++)
        {
            if(nums[i]==0)
                oneCount++;
            else
                zeroCount++;
            int dif = oneCount-zeroCount;
            if(dif  == 0)
                {
                    maxLen = Math.max(maxLen,i+1);
                }
                
             else if(freq.containsKey(dif))
                maxLen =Math.max(maxLen,i-freq.get(dif));
                
            else
                 freq.put(dif,i);
                
        }      
        return maxLen;
        
    }
}