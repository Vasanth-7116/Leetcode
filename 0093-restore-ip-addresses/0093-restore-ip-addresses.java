class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return result;
        }
        backtrack(result, new ArrayList<>(), s, 0);
        return result;
    }
    
    private void backtrack(List<String> result, List<String> current, String s, int start) {
        if (current.size() == 4) {
            if (start == s.length()) {
                result.add(String.join(".", current));
            }
            return;
        }
        
        for (int i = 1; i <= 3; i++) {
            if (start + i > s.length()) {
                break;
            }
            
            String part = s.substring(start, start + i);
            if (isValid(part)) {
                current.add(part);
                backtrack(result, current, s, start + i);
                current.remove(current.size() - 1);
            }
        }
    }
    
    private boolean isValid(String part) {
        if (part.length() > 1 && part.startsWith("0")) {
            return false;
        }
        int val = Integer.parseInt(part);
        return val >= 0 && val <= 255;
    }
}