// class Solution {
//     public boolean isAnagram1(String s, String t) {
//         if(s.length()!=t.length())
//         {
//             return false;
//         }
//         int [] freq1 = new int[26];
//         int [] freq2 = new int[26];
//         for(int  i =0;i<s.length();i++)
//         {
//             freq1[(int)s.charAt(i)-'a']++;
//             freq2[(int)t.charAt(i)-'a']++;
//         }
//         for(int i =0;i<26;i++)
//         {
//             if(freq1[i]!=freq2[i])
//             {
//                 return false;
//             }

//         }
//         // if(freq[(int)s.charAt(0)-'a']!=freq[(int)t.charAt(0)-'a'])
//         //     return false;
//         return true;
        

//     }
// }
class Solution {
    public boolean isAnagram(String s, String t) {
        int [] freq = new int[26];
        if(s.length()!=t.length())
        {
            return false;
        }
        for(int i =0;i<s.length();i++)
        {
            freq[s.charAt(i)-'a']++;
            freq[t.charAt(i)-'a']--;
        }
        // if(freq[s.charAt(0)-'a']!=0)
        //     return false;
        for(int i =0;i<26;i++)
        {
            if(freq[i]!=0)
                return false;
        }
        return true;

    }
}