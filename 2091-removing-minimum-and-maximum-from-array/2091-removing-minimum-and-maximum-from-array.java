class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int minIndex = 0;
        int maxIndex = 0;
        for(int i=0;i<n;i++){
            if(nums[i]<nums[minIndex]){
                minIndex = i;
            }
            if(nums[i]>nums[maxIndex]){
                maxIndex = i;
            }
        }
        int left,right,both;
        left = Math.max(minIndex, maxIndex) + 1;
        right = n - Math.min(minIndex, maxIndex);
        both = Math.min(minIndex, maxIndex) + 1 + (n - Math.max(minIndex, maxIndex));
        return Math.min(left,Math.min(right,both));
    }
}