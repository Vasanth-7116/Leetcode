class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        java.util.HashSet<String> bannedSet = new java.util.HashSet<>();
        for (String w : banned) {
            bannedSet.add(w);
        }
        
        java.util.HashMap<String, Integer> counts = new java.util.HashMap<>();
        String[] words = paragraph.toLowerCase().replaceAll("[!?',;.]", " ").split("\\s+");
        
        String result = "";
        int maxCount = 0;
        
        for (String word : words) {
            if (!word.isEmpty() && !bannedSet.contains(word)) {
                counts.put(word, counts.getOrDefault(word, 0) + 1);
                if (counts.get(word) > maxCount) {
                    maxCount = counts.get(word);
                    result = word;
                }
            }
        }
        
        return result;
    }
}