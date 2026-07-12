class Solution {
    public int maxNumberOfBalloons1(String text) {
        HashMap <Character,Integer> freq =new HashMap<>();
        for(char ch:text.toCharArray())
        {
            if(ch=='b'||ch=='a'||ch=='l'||ch=='o'||ch=='n')
                freq.put(ch,freq.getOrDefault(ch,0)+1);
        }
      
        int ans =0;
        while (true) {
            if (freq.getOrDefault('b', 0) >= 1 &&
                freq.getOrDefault('a', 0) >= 1 &&
                freq.getOrDefault('l', 0) >= 2 &&
                freq.getOrDefault('o', 0) >= 2 &&
                freq.getOrDefault('n', 0) >= 1) {
             
                freq.put('b', freq.get('b') - 1);
                freq.put('a', freq.get('a') - 1);
                freq.put('l', freq.get('l') - 2);
                freq.put('o', freq.get('o') - 2);
                freq.put('n', freq.get('n') - 1);
                
                ans += 1;
            } else {
                break; 
            }
        }
        return ans;
    }
    public int maxNumberOfBalloons(String text) {
        HashMap <Character,Integer> freq =new HashMap<>();
        for(char ch:text.toCharArray())
        {
            if(ch=='b'||ch=='a'||ch=='l'||ch=='o'||ch=='n')
                freq.put(ch,freq.getOrDefault(ch,0)+1);
        }
      
        int b = freq.getOrDefault('b', 0);
        int a = freq.getOrDefault('a', 0);
        int l = freq.getOrDefault('l', 0) / 2;
        int o = freq.getOrDefault('o', 0) / 2;
        int n = freq.getOrDefault('n', 0);

        return Math.min(Math.min(b, a), Math.min(Math.min(l, o), n));
    }
}