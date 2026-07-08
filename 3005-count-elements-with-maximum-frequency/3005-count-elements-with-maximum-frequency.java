class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer,Integer>freq = new HashMap<>();
        int count =0;
        int maxFreq =0;
        int curFreq=0;

        for(int num:nums)
        {
            curFreq =  freq.getOrDefault(num,0)+1;
            freq.put(num,curFreq);
            if(curFreq>maxFreq)
            {
                maxFreq=curFreq;
                count = maxFreq;
            }
            else if(curFreq==maxFreq){
                count = count+maxFreq;
            }
        }
        return count;
    }
}