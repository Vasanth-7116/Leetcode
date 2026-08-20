class Solution {
    public String[] findWords(String[] words) {
        int[] rowMap = new int[26];
        String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        for (int i = 0; i < rows.length; i++) {
            for (char c : rows[i].toCharArray()) {
                rowMap[c - 'a'] = i;
            }
        }
        
        java.util.List<String> result = new java.util.ArrayList<>();
        for (String word : words) {
            String lowerWord = word.toLowerCase();
            boolean isValid = true;
            int row = rowMap[lowerWord.charAt(0) - 'a'];
            
            for (char c : lowerWord.toCharArray()) {
                if (rowMap[c - 'a'] != row) {
                    isValid = false;
                    break;
                }
            }
            
            if (isValid) {
                result.add(word);
            }
        }
        
        return result.toArray(new String[0]);
    }
}