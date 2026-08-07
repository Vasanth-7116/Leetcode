class Solution {
    public int[] asteroidCollision(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for(int i =0;i<nums.length;i++){
            if(nums[i]<0){
                while(!stack.isEmpty()&&stack.peek()>0&&stack.peek()< -(nums[i])){
                    stack.pop();
                }
                if(stack.isEmpty()||stack.peek()<0){
                    stack.push(nums[i]);
                }
                else if(-(nums[i])==stack.peek()){
                    stack.pop();
                }
            }
            else{
                stack.push(nums[i]);
            }
        }
        int[] result = new int[stack.size()];
        int index = 0;
        for(int val : stack){
            result[index] = val;
            index++;
        }
        return result;

    }
}