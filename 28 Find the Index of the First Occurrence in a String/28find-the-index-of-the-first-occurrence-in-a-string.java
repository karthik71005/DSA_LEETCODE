class Solution {
    public int strStr(String haystack, String needle) {
        int n = needle.length();
        int m = haystack.length();

         if (needle.length() == 0) {
            return 0;
        }
        for (int i =0;i<= m-n;i++)
        {
            int k =0;
            int j =i;
            while(k<n&&needle.charAt(k) ==haystack.charAt(j))
            {

                k++;
                j++;
                if(n==k)
                {
                    return i;
                }
            }
        }
        return -1;
        
    }
}
