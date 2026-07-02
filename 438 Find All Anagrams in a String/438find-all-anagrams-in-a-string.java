class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n = p.length();
        int left =0;
        int[] pCount = new int[26];
        int[] sCount = new int[26];
        List<Integer> ans = new ArrayList<>();
        if (s.length() < n) {
        return ans;
        }
        for(int i =0;i<n;i++)
        {
            pCount[p.charAt(i)-'a']++;
            sCount[s.charAt(i)-'a']++;
        
        }
        if(Arrays.equals(pCount,sCount)){
            ans.add(0);
        }
        int right =n;
    
        while(right<s.length())
        {
            sCount[s.charAt(right)-'a']++;
            sCount[s.charAt(right-n)-'a']--;
            right++;
            if(Arrays.equals(pCount,sCount)){
                ans.add(right-n);
            }
        }
        return ans;
    
        
    }
}