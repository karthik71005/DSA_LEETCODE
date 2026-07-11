class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack <Integer> next = new Stack<>();
        int n = temperatures.length;
        int [] ans = new int[n];
        ans[n-1] = 0;
        next.push(n-1);
        for(int i = n-2;i>=0;i--)
        {
            while(!next.isEmpty() && temperatures[i]>=temperatures[next.peek()])
            {
                next.pop();
            }
            if(!next.isEmpty())
            {
                ans[i]=next.peek()-i;
            }
            else{
                ans[i]=0;
            }
            next.push(i);
        }   
        return ans;
        
    }
}