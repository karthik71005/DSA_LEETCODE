class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int left =0;
        int right = n-1;
        while(left<=right)
        {
            int mid = left+(right-left)/2;
            int count = n-mid;
            if(citations[mid] == count)
                return count;
            else if(citations[mid]>count)
                right = mid-1;
            else 
                left = mid+1;
        }
        return n-left;
    }
}