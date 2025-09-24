class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max=candies[0];
        boolean [] ba=new boolean[candies.length];
        for (int i=0;i<candies.length;i++)
        {
            if(candies[i]>max)
            {
                max=candies[i];
            }
        }
        for (int i=0;i<candies.length;i++)
        {
            if(candies[i]+extraCandies>=max)
            {
                ba[i]=true;
            }
            else
            {
                ba[i]=false;
            }
        }
        List<Boolean> list = new ArrayList<>();
        for (boolean b : ba) {
            list.add(b); // auto-boxing: boolean → Boolean
        }
        return list;
        
    }
}