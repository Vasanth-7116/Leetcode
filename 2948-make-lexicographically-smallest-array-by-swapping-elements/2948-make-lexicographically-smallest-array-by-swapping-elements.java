class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);

        // Map to track which group ID a number belongs to
        Map<Integer, Integer> numToGroup = new HashMap<>();
        
        // Map to store the sorted elements belonging to each group ID
        Map<Integer, LinkedList<Integer>> groupToList = new HashMap<>();

        int currGroup = 0;
        numToGroup.put(sortedNums[0], currGroup);
        groupToList.put(currGroup, new LinkedList<>());
        groupToList.get(currGroup).add(sortedNums[0]);

        // 1. Group the elements based on the limit
        for (int i = 1; i < n; i++) {
            // If the gap between sorted elements is greater than the limit, 
            // they cannot be swapped. Start a new connected component.
            if (sortedNums[i] - sortedNums[i - 1] > limit) {
                currGroup++;
                groupToList.put(currGroup, new LinkedList<>());
            }
            numToGroup.put(sortedNums[i], currGroup);
            groupToList.get(currGroup).add(sortedNums[i]);
        }

        // 2. Reconstruct the array
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int group = numToGroup.get(nums[i]);
            // Since elements were added in sorted order, polling retrieves 
            // the smallest available number for this specific position.
            result[i] = groupToList.get(group).poll();
        }

        return result;
    }
}