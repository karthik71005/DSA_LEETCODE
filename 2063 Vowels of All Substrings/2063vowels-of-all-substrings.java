class Solution {
    public long countVowels(String word) {
        long tS=0;
        long n=word.length();
        for(int i =0;i<n;i++)
        {
            char ch = word.charAt(i);
            if(ch =='a' || ch =='e' ||ch == 'i' || ch =='o' ||ch =='u'){
                tS+=(i+1)*(n-i);
            }
        }
        return tS;
    }
}