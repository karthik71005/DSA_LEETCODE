class Solution {
    public String capitalizeTitle(String title) {
        char[] chars = title.toCharArray();
        int n = chars.length;
        
        int start = 0;
        for (int i = 0; i <= n; i++) {
         
            if (i == n || chars[i] == ' ') {
                int wordLength = i - start;
             
                if (wordLength > 2) {
                    chars[start] = Character.toUpperCase(chars[start]);
                }
                
                
                start = i + 1;
            } else {
                
                chars[i] = Character.toLowerCase(chars[i]);
            }
        }
        
        return new String(chars);
    }
}