class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
      List <List<Integer>> answer = new ArrayList<>();
      List <Integer> current = new ArrayList<>();
      backtrack(candidates,target,0,current,answer);
      return answer;

        
    }
    public void backtrack(int [] candidates,int target,int start,List <Integer>current,List<List<Integer>> answer)
    {
        if(target == 0)
             answer.add(new ArrayList<>(current));
        if(target<0)
            return;
        for(int i =start;i<candidates.length;i++)
        {
            current.add(candidates[i]);
            backtrack(candidates,target-candidates[i],i,current,answer);
            current.remove(current.size()-1);
        }
    }
}