class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = score[i];
            pairs[i][1] = i;
        }
        
        java.util.Arrays.sort(pairs, (a, b) -> b[0] - a[0]);
        
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                result[pairs[i][1]] = "Gold Medal";
            } else if (i == 1) {
                result[pairs[i][1]] = "Silver Medal";
            } else if (i == 2) {
                result[pairs[i][1]] = "Bronze Medal";
            } else {
                result[pairs[i][1]] = String.valueOf(i + 1);
            }
        }
        
        return result;
    }
}