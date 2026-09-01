import java.util.Arrays;

class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        
        int n = nums.length;
        int minVal = nums[0];
        int maxVal = nums[0];
        
        // Find the overall minimum and maximum in the array
        for (int i = 1; i < n; i++) {
            minVal = Math.min(minVal, nums[i]);
            maxVal = Math.max(maxVal, nums[i]);
        }
        
        // If all elements are the same, the gap is 0
        if (minVal == maxVal) {
            return 0;
        }
        
        // The minimum possible gap is ceiling((max - min) / (N - 1))
        int gap = (int) Math.ceil((double) (maxVal - minVal) / (n - 1));
        
        // Create buckets to store the min and max of each bucket
        int[] bucketMin = new int[n];
        int[] bucketMax = new int[n];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        
        // Place each number into its corresponding bucket
        for (int num : nums) {
            int idx = (num - minVal) / gap;
            bucketMin[idx] = Math.min(bucketMin[idx], num);
            bucketMax[idx] = Math.max(bucketMax[idx], num);
        }
        
        // Calculate the maximum gap between adjacent non-empty buckets
        int maxGap = 0;
        int previousMax = minVal;
        
        for (int i = 0; i < n; i++) {
            // Skip empty buckets
            if (bucketMin[i] == Integer.MAX_VALUE && bucketMax[i] == Integer.MIN_VALUE) {
                continue;
            }
            
            // The gap is current bucket's min minus previous bucket's max
            maxGap = Math.max(maxGap, bucketMin[i] - previousMax);
            previousMax = bucketMax[i];
        }
        
        return maxGap;
    }
}