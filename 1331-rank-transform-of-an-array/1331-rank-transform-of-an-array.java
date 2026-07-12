class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int [] sorted = arr.clone();
        Arrays.sort(sorted);
        HashMap<Integer ,Integer> temp = new HashMap<>();
        int rank =1;
        for(int num:sorted)
        {
            if(!temp.containsKey(num))
            {
                temp.put(num,rank);
                rank++;
            }
        }
        int [] result = new int[arr.length];
        for(int i =0;i<arr.length;i++)
        {
            result[i] = temp.get(arr[i]);
        }
        return result;
    }
}