class Pair{
    int first;
    char second;
    public Pair(int first,char second)
    {
        this.first =first;
        this.second = second;
    }
}
class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> freq  = new HashMap<>();
        HashMap<Character,Integer> free  = new HashMap<>();
        int len = tasks.length;
        for(char c:tasks)
        {
            freq.put(c,freq.getOrDefault(c,0)+1);
            free.put(c,1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.first-a.first);
        for(Map.Entry<Character,Integer>entry:freq.entrySet())
        {
            int val = entry.getValue();
            char c = entry.getKey();
            pq.offer(new Pair(val,c));
        }
        int seat =1;
        while(!pq.isEmpty())
        {
            List<Pair> temp = new ArrayList<>();
            while(!pq.isEmpty()){
            Pair p =pq.peek();
            pq.poll();
            int fr = p.first;
            char c = p.second;
            if(free.get(c)<=seat)
            {
                if(fr>1)
                    pq.offer(new Pair(fr-1,c));
                free.put(c,seat+n+1);
                break;
            }
            else{
                temp.add(p);
            }
            }
            for(int i =0;i<temp.size();i++)
                pq.offer(temp.get(i));
            seat++;


        }
        return seat-1;
        
    }
}