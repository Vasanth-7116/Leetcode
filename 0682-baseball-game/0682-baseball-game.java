class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for(int i=0;i<operations.length;i++){
            if(operations[i].equals("C")){
                stack.pop();
            }
            else if(operations[i].equals("D")){
                stack.push(stack.peek()*2);
            }
            else if(operations[i].equals("+")){
                stack.push(stack.get(stack.size()-1)+stack.get(stack.size()-2));
            }
            else{
                int val = Integer.valueOf(operations[i]);
                stack.push(val);
            }
        }
      
        for(int i=0;i<stack.size();i++){
            sum+=stack.get(i);
        }
        return sum;
    }
}