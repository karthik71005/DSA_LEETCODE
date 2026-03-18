class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        if(x%10 == 0&&x!=0)
            return false;
        
        int rH = 0;
        while(x>rH)
        {
            rH = rH*10 +x%10;
            x/=10;
        }
        return x==rH || x==rH/10;
    }
}