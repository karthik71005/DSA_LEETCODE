// class Pair{
//     int first;
//     char second;
//     public Pair(int first,char second)
//     {
//         this.first =first;
//         this.second = second;
//     }
// }
// class Solution {
//     public int leastInterval(char[] tasks, int n) {
//         HashMap<Character,Integer> freq  = new HashMap<>();
//         HashMap<Character,Integer> free  = new HashMap<>();
//         int len = tasks.length;
//         for(char c:tasks)
//         {
//             freq.put(c,freq.getOrDefault(c,0)+1);
//             free.put(c,1);
//         }
//         PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.first-a.first);
//         for(Map.Entry<Character,Integer>entry:freq.entrySet())
//         {
//             int val = entry.getValue();
//             char c = entry.getKey();
//             pq.offer(new Pair(val,c));
//         }
//         int seat =1;
//         while(!pq.isEmpty())
//         {
//             List<Pair> temp = new ArrayList<>();
//             while(!pq.isEmpty()){
//             Pair p =pq.peek();
//             pq.poll();
//             int fr = p.first;
//             char c = p.second;
//             if(free.get(c)<=seat)
//             {
//                 if(fr>1)
//                     pq.offer(new Pair(fr-1,c));
//                 free.put(c,seat+n+1);
//                 break;
//             }
//             else{
//                 temp.add(p);
//             }
//             }
//             for(int i =0;i<temp.size();i++)
//                 pq.offer(temp.get(i));
//             seat++;


//         }
//         return seat-1;
        
//     }
// }
class Solution {
    class Pair {
        int first;
        char second;
        int availableAt; // Track when this task can run next directly on the object
        
        Pair(int first, char second, int availableAt) {
            this.first = first;
            this.second = second;
            this.availableAt = availableAt;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        int len = tasks.length;
        HashMap<Character, Integer> freq = new HashMap<>();
        
        for (char c : tasks) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        
        // PriorityQueue only holds tasks that are READY to run right now
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.first - a.first);
        // Queue holds tasks waiting for their cooldown to expire
        Queue<Pair> coolingQueue = new LinkedList<>();
        
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            pq.offer(new Pair(entry.getValue(), entry.getKey(), 1)); // Initially all ready at seat 1
        }
        
        int seat = 1;
        
        while (!pq.isEmpty() || !coolingQueue.isEmpty()) {
            // 1. Check if the task at the front of the cooling queue is ready to be put back into the heap
            while (!coolingQueue.isEmpty() && coolingQueue.peek().availableAt <= seat) {
                pq.offer(coolingQueue.poll());
            }
            
            // 2. Process the highest frequency available task
            if (!pq.isEmpty()) {
                Pair p = pq.poll();
                int fr = p.first;
                char c = p.second;
                
                if (fr > 1) {
                    // Update its cooldown target and move it to the cooling queue
                    p.first = fr - 1;
                    p.availableAt = seat + n + 1;
                    coolingQueue.offer(p);
                }
            }
            
            // 3. Tick forward
            seat++;
        }
        
        return seat - 1;
    }
}