class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> freq = new HashMap<>();
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        for(char ch:magazine.toCharArray())
        {
            freq.put(ch,freq.getOrDefault(ch,0)+1);
        }
        for(char ch:ransomNote.toCharArray())
        {
            if(!freq.containsKey(ch))
            {
                return false;
            }
            int num = freq.get(ch);
            num--;
            if(num==0)
            {
                freq.remove(ch);
            }
            else{
            freq.put(ch,num);
            }

        }
        return true;
    }
}