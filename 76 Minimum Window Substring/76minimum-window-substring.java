class Solution {
    public String minWindow(String s, String t) {
        int [] count = new int[126];
        int left=0;
        int start =0;
        int right = 0;
        int mL = Integer.MAX_VALUE;
        int n = t.length();
        for(char c: t.toCharArray())
        {
            count[c]++;
        }
        while(right<s.length())
        {
            char r = s.charAt(right);
            if(count[r]>0)
            {
                n--;
            }
            count[r]--;
            // right++;
            while(n==0)
            {
                if(right-left+1<mL)
                {
                    mL = right-left+1;
                    start =left;
                }
                char l = s.charAt(left);
                count[l]++;
                if(count[l]>0)
                {
                    n++;
                }
                left++;
            }
            right++;
            
        }
        if(mL == Integer.MAX_VALUE)
            return "";
        else
            return s.substring(start,start+mL);
        
    }
}