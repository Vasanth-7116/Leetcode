class Solution {
    public int minimumPushes(String word) {
        int pushes = 0;

        for(int i =0;i<word.length();i++){
            if(i<8){
                pushes++;
            }
            if(i>=8&&i<16){
                pushes = pushes + 2;
            }
            if(i>=16&&i<24){
                pushes = pushes + 3;
            }
            if(i>=24){
                pushes = pushes + 4;
            }
        }
        return pushes;
    }
}