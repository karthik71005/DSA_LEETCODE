class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low =1;
        int n = position.length;
        int high = position[n-1] - position[0];
        int res =-1;
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(distance(position,m,n,mid))
            {
                res = mid;
                low = mid+1;
            }
            else
            {
               high = mid-1;
            }
        }
        return  res;
        
    }
    public boolean distance(int [] a,int m,int n,int mid)
    {
        int ball =1;
        int pos = a[0];
        for(int i =1;i<n;i++)
        {
            int dist = a[i]-pos;
            if(dist < mid)
                continue;
            ball++;
            pos = a[i];
        }
        if(ball>=m)
            return true;
        return false;
    }
}