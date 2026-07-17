class Solution {
    private void solve(int index,String digits,StringBuilder temp,List<String>res,Map<Character,String>mapping){
        if(index == digits.length())
        {
            res.add(temp.toString());
            return;
        }
        String letters = mapping.get(digits.charAt(index));
        for(int i = 0;i<letters.length();i++)
        {
            char ch = letters.charAt(i);
            temp.append(ch);
            solve(index+1,digits,temp,res,mapping);
            temp.deleteCharAt(temp.length()-1);
        }

    }
    public List<String> letterCombinations(String digits) {
        List <String> res = new ArrayList<>();
        if(digits==null||digits.isEmpty())
        {
            return res;
        }
        HashMap<Character,String>mapping = new HashMap<>();
        mapping.put('2',"abc");
        mapping.put('3',"def");
        mapping.put('4',"ghi");
        mapping.put('5',"jkl");
        mapping.put('6',"mno");
        mapping.put('7',"pqrs");
        mapping.put('8',"tuv");
        mapping.put('9',"wxyz");
        StringBuilder temp = new StringBuilder();
        solve(0,digits,temp,res,mapping);
        return res;
    }
}