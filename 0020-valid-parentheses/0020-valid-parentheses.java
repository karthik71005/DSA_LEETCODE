class Solution {
    public boolean isValid(String s) {
        Stack <Character> count = new Stack <>();

        for(int i =0;i<s.length();i++)
        {
            char current = s.charAt(i);
            if(count.isEmpty() && (current=='}'||current==')'||current==']'))
            {
                return false;
            }
            else if(current=='}')
            {
                if(count.peek()=='{')
                    count.pop();
                else
                    return false;
            }
            else if(current==']')
            {
                if(count.peek()=='[')
                    count.pop();
                else
                    return false;
            }
            else if(current==')')
            {
                if(count.peek()=='(')
                    count.pop();
                else
                    return false;
            }
            else
                count.push(current);

        }
        if(!count.isEmpty())
            return false;
        return true;
    }
}