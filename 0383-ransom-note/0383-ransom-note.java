class Solution {
    public boolean canConstructlazy(String ransomNote, String magazine) {
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
    public boolean canConstruct(String ransomNote, String magazine) {
        // Quick optimization: If the note requires more letters than the magazine has, it's impossible
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        // A fixed-size array acts as a perfect direct-address map for 'a' through 'z'
        int[] counts = new int[26];

        // Fill counts from the magazine
        for (char ch : magazine.toCharArray()) {
            counts[ch - 'a']++;
        }

        // Consume counts for the ransomNote
        for (char ch : ransomNote.toCharArray()) {
            // Decrement first, then check if we've used more than available
            if (--counts[ch - 'a'] < 0) {
                return false; // Immediate failure exit
            }
        }

        return true;
    }
    
}