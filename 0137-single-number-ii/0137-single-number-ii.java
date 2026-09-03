class Solution {
    public int singleNumber(int[] nums) {
        int result =0;
        int countSB = 0;
        for(int b=0;b<=31;b++){
            countSB =0;
            for(int n:nums){
                if ((n & (1 << b)) != 0) {
                    countSB++;
                }
            }
            if(countSB % 3!=0){
                result = result | (1<<b);
            }
        }
        return result;
    }
}