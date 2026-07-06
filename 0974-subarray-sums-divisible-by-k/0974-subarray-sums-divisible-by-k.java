class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        HashMap <Integer,Integer>freq = new HashMap<>();
        freq.put(0,1);
      
        int sum=0;
        int rem =0;

        for(int i =0;i<nums.length;i++)
        {   
            sum+=nums[i];
            rem = (sum%k+k)%k;
          
            if(freq.containsKey(rem)){
                count+=freq.get(rem);
            }


            freq.put(rem,freq.getOrDefault(rem,0)+1);
              
            

        }
        return count;
        
    }
}