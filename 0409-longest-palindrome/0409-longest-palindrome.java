class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer>freq= new HashMap<>();
        for(char ch:s.toCharArray())
        {
            freq.put(ch,freq.getOrDefault(ch,0)+1);
        }
        int count =0;
        int flag=0;
        for(int i =0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(freq.containsKey(ch)){
            if((freq.get(ch)%2) == 0)
            {
                count+=freq.get(ch);
                freq.remove(ch);
            }
            else if(freq.get(ch)==1)
            {
                flag=1;
                continue;
            }
            else{
                count = count+(freq.get(ch)-1);
                flag =1;
                freq.remove(ch);

            }
            }
        }
        if(flag ==0)
            return count;
        return count+1;
    }
}