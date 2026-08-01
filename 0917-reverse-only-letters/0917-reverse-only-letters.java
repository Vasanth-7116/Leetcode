class Solution {
    public String reverseOnlyLetters(String str) {
        int i = 0;
        
        StringBuilder s = new StringBuilder(str);
        int j = s.length() - 1;
        while (i < j) {
            if (Character.isLetter(s.charAt(i)) && Character.isLetter(s.charAt(j))) {
                char temp  = s.charAt(i);
                s.setCharAt(i,s.charAt(j));
                s.setCharAt(j,temp);
                i++;
                j--;
            }
            else if(Character.isLetter(s.charAt(i))&&!Character.isLetter(s.charAt(j))){
                j--;
            }
            else if(!Character.isLetter(s.charAt(i))&&!Character.isLetter(s.charAt(j))){
                i++;
                j--;
            }
            else{
                i++;
            }
        }
        return s.toString();
    }
}