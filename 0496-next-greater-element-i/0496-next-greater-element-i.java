class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();

        int n = nums2.length;

        for(int i =n-1;i>=0;i--){
            while(!stack.isEmpty()&&nums2[i]>=stack.peek()){
                stack.pop();
            }
            if(stack.isEmpty()){
                stack.push(nums2[i]);
                map.put(nums2[i],-1);
                continue;
            }
            map.put(nums2[i],stack.peek());
            stack.push(nums2[i]);
        }

        for(int i=0;i<nums1.length;i++){
            nums1[i] = map.get(nums1[i]);
        }

        return nums1;

    }
}