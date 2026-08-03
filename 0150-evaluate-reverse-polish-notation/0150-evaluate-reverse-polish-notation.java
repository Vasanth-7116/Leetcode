class Solution {
    public int evalRPN(String[] t) {
        Stack<Integer> stack = new Stack<>();
        int ans= 0;
        for(int i=0;i<t.length;i++){
            if(t[i].equals("*")){
                int val = stack.get(stack.size()-2)* stack.get(stack.size()-1);
                stack.pop();
                stack.pop();
                stack.push(val);

            }
            else if(t[i].equals("+")){
                int val = stack.get(stack.size()-2) + stack.get(stack.size()-1);
                stack.pop();
                stack.pop();
                stack.push(val);
            }
            else if(t[i].equals("-")){
                int val = stack.get(stack.size()-2) - stack.get(stack.size()-1);
                stack.pop();
                stack.pop();
                stack.push(val);
            }
            else if(t[i].equals("/")){
                int val = stack.get(stack.size()-2) / stack.get(stack.size()-1);
                stack.pop();
                stack.pop();
                stack.push(val);
            }
            else{
                stack.push(Integer.valueOf(t[i]));
            }

        }
        return stack.peek();
    }
}