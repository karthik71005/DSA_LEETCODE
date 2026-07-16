class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result,"",0,0,n);
        return result;
    }
    void backtrack(List<String>result,String currentString,int openCount,int closeCount,int n)
    {
        if(currentString.length()==n*2)
        {
            result.add(currentString);
            return;
        }
        if(openCount<n)
        {
            backtrack(result,currentString+"(",openCount+1,closeCount,n);
        }
        if(closeCount<openCount)
        {
            backtrack(result,currentString+")",openCount,closeCount+1,n);
        }
    }
}