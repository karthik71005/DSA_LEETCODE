class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        int [] arr = new int[words.length];
        int sum =0;
        int j =0;
        for(String word :words)
        {
            for(int i =0;i<word.length();i++)
            {
                sum=sum+weights[(int)word.charAt(i)-'a'];
            }
            arr[j]=sum%26;
            sum=0;
            j++;
        }
        StringBuilder temp = new StringBuilder();
        for(int i =0;i<arr.length;i++)
        {
            temp.append((char)('z'-arr[i]));
        }
        return temp.toString();


        
    }
}