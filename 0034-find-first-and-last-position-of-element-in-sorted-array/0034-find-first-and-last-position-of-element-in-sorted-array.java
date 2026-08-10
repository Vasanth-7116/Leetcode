class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if(n==0){
            return new int[]{-1,-1};
        }
        int s=0;
        int e=n-1;
        int lb = n;
        int ub = -1;
        while(s<=e){
            int mid = s + (e - s)/2;
            if(nums[mid]>=target){
                lb = mid;
                e = mid - 1;
            }
            else{
                s = mid + 1;
            }
        }
        s=0;
        e = n-1;
        while(s<=e){
            int mid = s + (e - s)/2;
            if(nums[mid]<=target){
                ub = mid;
                s = mid + 1;
            }
            else{
                e = mid - 1;
            }
        }
        if(lb==n||nums[lb]!=target){
            return new int[]{-1,-1};
        }
        return new int[]{lb,ub};
    }
}