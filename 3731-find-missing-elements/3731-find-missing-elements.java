class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        int s = nums[0];
        int e = nums[nums.length-1];
        int i=0;
        while(s<e){
            if(nums[i]!=s){
                list.add(s);
                
            }
            else{
                i++;
            }
            s++;
            
        }
        return list;
    }
}