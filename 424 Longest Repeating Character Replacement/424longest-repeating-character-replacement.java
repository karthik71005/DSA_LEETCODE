class Solution {
    public int characterReplacement(String s, int k) {
        int [] count = new int [26];
        int left =0;
        int n =s.length();
        int mC=0;
        int mL=0;
        int wL=0;
        for(int right =0;right<n;right++)
        {
            count[s.charAt(right)-'A']++;

            mC = Math.max(mC,count[s.charAt(right)-'A']);
            wL = right-left+1;
            if(wL-mC>k)
            {
                count[s.charAt(left)-'A']--;
                left++;
            }
            mL=Math.max(mL,right-left+1);
            
        }
        return mL;
    }
}