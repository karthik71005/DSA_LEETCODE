class Solution {
    public int numberOfSubstrings(String s) {
        int count=0;
        int lA=-1;
        int lB=-1;
        int lC=-1;
        for(int i =0;i<s.length();i++)
        {
            if(s.charAt(i)=='a')
                lA=i;
            else  if(s.charAt(i)=='b')
                lB=i;
            else
                lC=i;
            
            if(lA!=-1 && lB!=-1 && lC!=-1)
            {
                count+=Math.min(lA,Math.min(lB,lC))+1;
            }
        }
        return count;
        
    }
}