class Solution {
    public int singleNonDuplicate(int[] nums) {
        int i=0;
        while(i<nums.length-2){
            if(nums[i]!=nums[i+1]){
                return nums[i];
            }
            i=i+2;
        }
        return nums[nums.length-1];

    }
}