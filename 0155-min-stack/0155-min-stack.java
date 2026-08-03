class MinStack {
    Stack<Integer> stack;
    Stack<Integer> min;
    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int value) {
        stack.push(value);
        if(min.isEmpty()){
            min.push(value);
        }
        else if(min.peek()>=value){
         
            min.push(value);
        }
        
        
    }
    
    public void pop() {
        if(stack.peek().equals(min.peek())){
            min.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */