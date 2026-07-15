class Pair{
    int first;
    String second;
    public Pair(int first,String second)
    {
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public List<String> topKFrequent(String[] words, int k) {   
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.first!=b.first ? a.first-b.first:b.second.compareTo(a.second));
        HashMap<String,Integer> freq = new HashMap<>();
        for(String s : words)
        {
            freq.put(s,freq.getOrDefault(s,0)+1);
        }
        for(Map.Entry<String,Integer>entry :freq.entrySet())
        {
            String val = entry.getKey();
            int count = entry.getValue();
            pq.offer(new Pair(count,val));
            if(pq.size()>k)
                pq.poll();
        }
  
        ArrayList<String> temp = new ArrayList<>();
        while(!pq.isEmpty())
        {
           temp.add(pq.poll().second);
        }
        Collections.reverse(temp);

        return temp;
        
    }
}