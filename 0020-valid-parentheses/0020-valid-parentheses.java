class Solution {
    public boolean isValid(String s) {
        Stack<Character>stack=new Stack<Character>();
        int len=s.length();
        for(int i=0;i<len;i++){
            if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='['){
                stack.push(s.charAt(i));
            }
            else{
                if(stack.isEmpty())return false;
                char top=stack.peek();
                if((s.charAt(i)==')'&&top=='(') ||(s.charAt(i)==']'&&top=='[')||(s.charAt(i)=='}'&&top=='{')) stack.pop();
                else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}