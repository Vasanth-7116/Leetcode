class Solution {
    public long subArrayRanges(int[] nums) {
        int[] prevMin = prevMi(nums);
        int[] nextMin = nextMi(nums);
        int[] prevMax = prevMa(nums);
        int[] nextMax = nextMa(nums);
        long total = 0;
        for(int i=0;i<nums.length;i++){
            int prevMin_l = i-prevMin[i];
            int nextMin_r = nextMin[i]-i;
            int prevMax_l = i-prevMax[i];
            int nextMax_r = nextMax[i]-i;
            long minSum = 1L*prevMin_l*nextMin_r*nums[i];
            long maxSum = 1L*prevMax_l*nextMax_r*nums[i];
            total = total + (maxSum - minSum);
        }
        return total;
    }
    static int[] prevMi(int[] nums){
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            while(!stack.isEmpty()&&nums[stack.peek()]>nums[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                result[i]=-1;
                stack.push(i);
                continue;
            }
            result[i] = stack.peek();
            stack.push(i);
        }
        return result;
    }

    static int[] nextMi(int[] nums){
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        for(int i=nums.length-1;i>=0;i--){
            while(!stack.isEmpty()&&nums[stack.peek()]>=nums[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                result[i]=nums.length;
                stack.push(i);
                continue;
            }
            result[i] = stack.peek();
            stack.push(i);
        }
        return result;
                                                   
    }

    static int[] prevMa(int[] nums){
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            while(!stack.isEmpty()&&nums[stack.peek()]<nums[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                result[i]=-1;
                stack.push(i);
                continue;
            }
            result[i] = stack.peek();
            stack.push(i);
        }
        return result;
    }

    static int[] nextMa(int[] nums){
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        for(int i=nums.length-1;i>=0;i--){
            while(!stack.isEmpty()&&nums[stack.peek()]<=nums[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                result[i]=nums.length;
                stack.push(i);
                continue;
            }
            result[i] = stack.peek();
            stack.push(i);
        }
        return result;
    }

}