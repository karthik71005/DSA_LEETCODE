class Solution {
    public boolean isValid(String s) {
        Stack <Character> count = new Stack <>();

        for(int i =0;i<s.length();i++)
        {
            if(count.isEmpty() && (s.charAt(i)=='}'||s.charAt(i)==')'||s.charAt(i)==']'))
            {
                return false;
            }
            if(s.charAt(i)=='}')
            {
                if(count.peek()=='{')
                    count.pop();
                else
                    return false;
            }
            else if(s.charAt(i)==']')
            {
                if(count.peek()=='[')
                    count.pop();
                else
                    return false;
            }
            else if(s.charAt(i)==')')
            {
                if(count.peek()=='(')
                    count.pop();
                else
                    return false;
            }
            else
                count.push(s.charAt(i));

        }
        if(!count.isEmpty())
            return false;
        return true;
    }
}