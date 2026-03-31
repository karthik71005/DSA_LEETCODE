class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> res = new HashSet<>();
        for(int num:nums)
            res.add(num);

        int longestStreak = 0;

        for(int num:res)
        {
            
            if(!res.contains(num-1))
            {
                int currentNum=num;
                int currentStreak =1;

                while(res.contains(currentNum+1))
                {
                    currentNum+=1;
                    currentStreak+=1;

                }
                longestStreak = Math.max(longestStreak,currentStreak);
            }
            
        }
    return longestStreak;
    }
}