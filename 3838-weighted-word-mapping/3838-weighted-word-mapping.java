class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder temp = new StringBuilder();
        
        for (String word : words) {
            int sum = 0; 
            
            for (int i = 0; i < word.length(); i++) {
                sum += weights[word.charAt(i) - 'a'];
            }
            
            int remainder = sum % 26;
    
            char mappedChar = (char) ('z' - remainder);
            temp.append(mappedChar);
        }
        
        return temp.toString();
    }
}