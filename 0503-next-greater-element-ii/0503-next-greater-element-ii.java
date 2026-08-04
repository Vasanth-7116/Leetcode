class Solution {
    public int[] nextGreaterElements(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length]; 
        Arrays.fill(result,-1);
     
        int n = arr.length;
        for (int i = n*2-1; i >=0 ; i--) {
            while(!stack.isEmpty()&&stack.peek()<=arr[i%n]){
                stack.pop();
            }
            if (stack.isEmpty()){
                stack.push(arr[i%n]);
                result[i%n] = -1;
                continue;
            }
            if(result[i%n]==-1) {
                result[i % n] = stack.peek();
            }
            stack.push(arr[i%n]);
        }
        return result;
    }
}