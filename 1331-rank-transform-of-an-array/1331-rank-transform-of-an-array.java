class Solution {
    public int[] arrayRankTransform1(int[] arr) {
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
    public int[] arrayRankTransform(int[] arr) {
        if (arr.length == 0) return new int[0];
        
        // 1. Clone and sort just like you did
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        
        // 2. Pre-size the HashMap to prevent resizing overhead
        HashMap<Integer, Integer> rankMap = new HashMap<>(arr.length);
        
        // 3. Single-pass ranking without containsKey() overhead
        int rank = 1;
        rankMap.put(sorted[0], rank);
        
        for (int i = 1; i < sorted.length; i++) {
            // Only increase the rank if the current element is different from the previous one
            if (sorted[i] != sorted[i - 1]) {
                rank++;
                rankMap.put(sorted[i], rank);
            }
        }
        
        // 4. Build the final result array
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = rankMap.get(arr[i]);
        }
        
        return result;
    }
}