import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int maxLen = 0;
        HashSet<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                // Update the maximum length found so far
                maxLen = Math.max(maxLen, j - i);
            } else {
                // Duplicate found: shrink window from the left
                set.remove(s.charAt(i));
                i++;
            }
        }
        return maxLen;
    }
}