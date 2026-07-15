class Solution {
    public String reorganizeString(String s) {
        HashMap <Character,Integer> freq = new HashMap<>();
        for(char c :s.toCharArray())
            freq.put(c,freq.getOrDefault(c,0)+1);
        //Max Heap
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b)->freq.get(b)-freq.get(a));
        pq.addAll(freq.keySet());
        StringBuilder sb = new StringBuilder();
        int prevCharCount=0;
        char prevChar ='#';
        while(!pq.isEmpty())
        {
            char curr = pq.poll();
            sb.append(curr);
            
            if(prevCharCount>0)
            {
                pq.offer(prevChar);
            }
            freq.put(curr,freq.get(curr)-1);
            prevCharCount = freq.get(curr);
            prevChar = curr;
            
        }
        return s.length()==sb.length()?sb.toString():"";
        
    }
}