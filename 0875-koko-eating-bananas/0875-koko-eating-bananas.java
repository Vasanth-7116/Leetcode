class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = max(piles);
        int s = 1;
        int e = max;
        while(s<=e){
            int mid = s + (e-s)/2;
            long hours = totalhours(piles,mid);
            if(hours<=h){
                e = mid - 1;
            }
            else{
                s = mid + 1;
            }
        }
        return s;
    }

    static int max(int[] piles){
        int max = 0;
        for(int i=0;i<piles.length;i++){
            max = Math.max(max,piles[i]);
        }
        return max;
    }

    static long totalhours(int[] piles,int mid){
        long total = 0L;
        for(int i=0;i<piles.length;i++){
            total = total + (piles[i]+mid-1)/mid;
        }
        return total;
    }
}