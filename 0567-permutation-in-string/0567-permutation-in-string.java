class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int k = s1.length();

        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();

        for(int i=0;i<k;i++){
            map1.put(s1.charAt(i),map1.getOrDefault(s1.charAt(i),0)+1);
        }

        for(int i=0;i<s2.length();i++){
            map2.put(s2.charAt(i),map2.getOrDefault(s2.charAt(i),0)+1);

            if(i>=k){
                
                map2.put(s2.charAt(i-k),map2.get(s2.charAt(i-k))-1);
                if(map2.get(s2.charAt(i-k))==0){
                    map2.remove(s2.charAt(i-k));
                }
                
            }
            if(map2.equals(map1)){
                return true;
            }

            
        }
        return false;

    }
}