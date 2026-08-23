class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words == null || words.length == 0) {
            return result;
        }
        
        int wordLen = words[0].length();
        int numWords = words.length;
        int totalLen = wordLen * numWords;
        
        if (s.length() < totalLen) {
            return result;
        }
        
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        for (int i = 0; i < wordLen; i++) {
            int left = i;
            int count = 0;
            Map<String, Integer> currentCount = new HashMap<>();
            
            for (int j = i; j <= s.length() - wordLen; j += wordLen) {
                String word = s.substring(j, j + wordLen);
                
                if (wordCount.containsKey(word)) {
                    currentCount.put(word, currentCount.getOrDefault(word, 0) + 1);
                    count++;
                    
                    while (currentCount.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        currentCount.put(leftWord, currentCount.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }
                    
                    if (count == numWords) {
                        result.add(left);
                    }
                } else {
                    currentCount.clear();
                    count = 0;
                    left = j + wordLen;
                }
            }
        }
        
        return result;
    }
}