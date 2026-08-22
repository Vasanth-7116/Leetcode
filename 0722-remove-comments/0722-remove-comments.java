import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean inBlock = false;
        
        for (String s : source) {
            int i = 0;
            char[] chars = s.toCharArray();
            
            while (i < chars.length) {
                if (!inBlock) {
                    if (i + 1 < chars.length && chars[i] == '/' && chars[i + 1] == '*') {
                        inBlock = true;
                        i++;
                    } else if (i + 1 < chars.length && chars[i] == '/' && chars[i + 1] == '/') {
                        break;
                    } else {
                        sb.append(chars[i]);
                    }
                } else {
                    if (i + 1 < chars.length && chars[i] == '*' && chars[i + 1] == '/') {
                        inBlock = false;
                        i++;
                    }
                }
                i++;
            }
            
            if (!inBlock && sb.length() > 0) {
                res.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        
        return res;
    }
}