class Pair{
    int first;
    int second;
    public Pair(int first,int second)
    {
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
    PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.first!=b.first ? a.first-b.first:a.second-b.second);
    
    HashMap<Integer,Integer> freq = new HashMap<>();
    for(int num:nums)
    {
        freq.put(num,freq.getOrDefault(num,0)+1);
    }

    for(Map.Entry<Integer,Integer>entry:freq.entrySet())
    {
        int val = entry.getKey();
        int count =  entry.getValue();
        pq.add(new Pair(count,val));

        if(pq.size()>k)
            pq.poll();
    }
    int [] result = new int[k];
    int index=0;
    while(!pq.isEmpty()){
        result[index++] = pq.poll().second;
    }
        return result;
    }
}