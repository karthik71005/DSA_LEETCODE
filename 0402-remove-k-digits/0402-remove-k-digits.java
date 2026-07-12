class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        for(int i =0;i<num.length();i++)
        {
            while(!stack.isEmpty()&&k>0&&stack.peek()>num.charAt(i))
            {
                stack.pop();
                k--;
            }
            
            stack.push(num.charAt(i));
        }
        while(k>0 && !stack.isEmpty())
        {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
      
        while(!stack.isEmpty())
        {
            sb.append(stack.pop());
        }
        sb.reverse();
        int startIndex = 0;
        while (startIndex < sb.length() && sb.charAt(startIndex) == '0') {
            startIndex++;
        }
        String result = sb.substring(startIndex);
     
        return result.isEmpty() ? "0" : result;
    }
}