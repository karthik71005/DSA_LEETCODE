class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length())
            return false;
        
        String doubled =s+s;
        int n = goal.length();
        for(int i =0;i<=n;i++)
        {
            boolean matchFound = true;
            for(int j =0;j<n;j++)
            {
                if(doubled.charAt(i+j)!=goal.charAt(j)){
                    matchFound = false;
                    break;
                }
            }
            if(matchFound)
                return true;
        }
        return false;
    }
    public boolean rotateStringlazy(String s, String goal) {
        if(s.length()!=goal.length())
            return false;
        
        String doubled =s+s;
      return doubled.contains(goal);
    }

}