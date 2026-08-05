class Solution {
    public int trap(int[] h) {
        int l = 0;
        int r = h.length-1;
        int count = 0;
        int leftmax=0,rightmax = 0;
        while(l<=r){
            if(leftmax<=rightmax){
                if(leftmax>h[l]){
                    count+=leftmax-h[l];
                }
                else{
                    leftmax = h[l];
                }
                l++;
            }
            else{
                if(rightmax>h[r]){
                    count+=rightmax-h[r];
                }
                else{
                    rightmax = h[r];
                }
                r--;
            }
        }
        return count;
    }
}