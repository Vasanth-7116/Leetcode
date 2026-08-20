class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int maxProd = nums[0];
        int minProd = nums[0];
        int ans = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int tempMax = Math.max(curr, Math.max(maxProd * curr, minProd * curr));
            minProd = Math.min(curr, Math.min(maxProd * curr, minProd * curr));
            
            maxProd = tempMax;
            ans = Math.max(ans, maxProd);
        }
        
        return ans;
    }
}