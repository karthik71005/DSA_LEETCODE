class Solution {
    public long sumAndMultiply(int n) {
        int sum = 0;
        int x =0;
        int place=1;
        while(n>0)
        {
            int digit = n%10;
            sum+=digit;
            if(digit!=0)
            {
                x = x+digit*place;
                place = place*10;
            }

            n= n/10;
        }
        // long res = x*sum;
        return 1L*x*sum;
        
    }
}