class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer,Integer>count = new HashMap<>();
        int left =0;
        int Mf =0;
        for(int right =0;right<fruits.length;right++)
        {
            count.put(fruits[right],count.getOrDefault(fruits[right],0)+1);
            while(count.size()>2)
            {
                int lF = fruits[left];
                count.put(lF,count.get(lF)-1);

                if(count.get(lF)==0)
                {
                    count.remove(lF);
                }
                left++;
            }
            Mf = Math.max(Mf,right-left+1);
        }
       return Mf;
    }
}