class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Character> charStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (!charStack.isEmpty() && charStack.peek() == ch) {
                // If it matches the top, increment its specific running count
                countStack.push(countStack.peek() + 1);
            } else {
                // New character encountered, start count at 1
                countStack.push(1);
            }
            
            charStack.push(ch);
            
            // If the running count hits k, pop all k instances
            if (countStack.peek() == k) {
                for (int j = 0; j < k; j++) {
                    charStack.pop();
                    countStack.pop();
                }
            }
        }
        
        // Rebuild the final string efficiently
        StringBuilder res = new StringBuilder();
        while (!charStack.isEmpty()) {
            res.append(charStack.pop());
        }
        
        return res.reverse().toString();
    }
}