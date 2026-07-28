class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        } 
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int target = -(nums[i]+nums[j]);
                if (map.containsKey(target)) {
                    int idx = map.get(target);

                    if (idx != i && idx != j) {
                        // valid triplet
                        List<Integer> triplets = Arrays.asList(nums[i], nums[j], k - (nums[i] + nums[j]));
                        Collections.sort(triplets);
                        if (!set.contains(triplets)) {
                            set.add(triplets);
                            ans.add(triplets);
                        }
                    }
                    
                }

            }
        }
        return ans;
    }
}