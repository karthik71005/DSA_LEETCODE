class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        int noDel = arr[0];
        int oneDel = Integer.MIN_VALUE;
        int res =arr[0];
        for(int i =1;i<n;i++)
        {
            int prevNoDel = noDel;
            int prevOneDel = oneDel;
            noDel = Math.max(arr[i],noDel+arr[i]);
            int v2;
            if(prevOneDel == Integer.MIN_VALUE)
            {
                v2= arr[i];
            }
            else{
                v2 = arr[i]+prevOneDel;
            }
            oneDel = Math.max(v2,prevNoDel);
            res = Math.max(res,Math.max(noDel,oneDel));
        }
        return res;
        
    }
}