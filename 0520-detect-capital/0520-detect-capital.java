class Solution {
    public boolean detectCapitalUse(String word) {
        int uppercase =0;
        for(int i =0;i<word.length();i++)
        {
            if(Character.isUpperCase(word.charAt(i)))
                uppercase++;
        }
        return uppercase==0||uppercase==word.length()||(uppercase==1&&Character.isUpperCase(word.charAt(0)));
        
    }
}