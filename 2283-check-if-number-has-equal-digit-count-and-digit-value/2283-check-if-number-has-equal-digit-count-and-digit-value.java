class Solution {
    public boolean digitCount(String num) {
        int[] freq = new int[10];
        for(char n: num.toCharArray()){
            freq[n-'0']++;
        }
        for(int i=0;i<num.length();i++){
            int exp = num.charAt(i)-'0';
            int act = freq[i];
            if(exp!=act){
                return false;
            }
        }
        return true;
    }
}