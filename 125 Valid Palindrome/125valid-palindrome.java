class Solution {
    public boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        char[] charArray = str.toCharArray();
        int left = 0;
        int right = charArray.length - 1;
        
        while (left < right) {
            // Move left pointer forward if the character is not alphanumeric
            while (left < right && !Character.isLetterOrDigit(charArray[left])) {
                left++;
            }
            // Move right pointer backward if the character is not alphanumeric
            while (left < right && !Character.isLetterOrDigit(charArray[right])) {
                right--;
            }
            
            // Compare the characters
            if (charArray[left] != charArray[right]) {
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
    }
}