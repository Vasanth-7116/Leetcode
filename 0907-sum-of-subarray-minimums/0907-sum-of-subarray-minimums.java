import java.util.Stack;

class Solution {

    public int sumSubarrayMins(int[] nums) {

        int[] pse = previousSmaller(nums);
        int[] nse = nextSmaller(nums);

        long total = 0;
        long MOD = 1000000007L;

        for (int i = 0; i < nums.length; i++) {
            long l = i - pse[i];
            long r = nse[i] - i;

            total = (total + l * r * nums[i]) % MOD;
        }

        return (int) total;
    }

    static int[] previousSmaller(int[] nums) {

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                stack.push(i);
                result[i] = -1;
            } else {
                result[i] = stack.peek();
                stack.push(i);
            }
        }

        return result;
    }

    static int[] nextSmaller(int[] nums) {

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[i] = nums.length;
                stack.push(i);
            } else {
                result[i] = stack.peek();
                stack.push(i);
            }
        }

        return result;
    }
}