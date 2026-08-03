class Solution {
    public int[] dailyTemperatures(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] result = new int[n];

        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty()&&arr[stack.peek()]<=arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                stack.push(i);
                result[i] = 0;
                continue;
            }
            result[i] = stack.peek()-i;
            stack.push(i);

        }
        return result;
    }
}