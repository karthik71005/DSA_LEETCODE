class Solution {
    public boolean isPowerOfTwo(int n) {
       StringBuilder binarystr = new StringBuilder();
       if(n==0)
            binarystr.append(n);
        else 
        {
            while(n>0)
            {
                int remainder = n%2;
                binarystr.insert(0,remainder);
                n=n/2;
            }
        }
        int onecount=0;
        for(int i =0;i<binarystr.length();i++)
        {
            if(binarystr.charAt(i)=='1')
                onecount++;
        }
        return onecount==1;
    }
}