class Solution {
    public int findComplement(int num) {
        int temp = num;
        int bit = 1;
        while (temp != 0) {
            num ^= bit;
            bit <<= 1;
            temp >>= 1;
        }
        return num;
    }
}