class Solution {
    public List<String> stringSequence(String target) {
        List<String>ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append('a');
        int i=0;
        while(i<target.length())
        {
            ans.add(sb.toString());
            if(sb.charAt(i)==target.charAt(i))
            {
                    sb.append('a');
                    i++;
                
            }
            else{
                sb.setCharAt(i,(char)(sb.charAt(i)+1));
            }
        }
        return ans;
        
    }
}