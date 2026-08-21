class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), k, n, 1);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentList, int k, int remain, int start) {
        if (currentList.size() == k && remain == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        }
        
        if (currentList.size() == k || remain < 0) {
            return;
        }

        for (int i = start; i <= 9; i++) {
            currentList.add(i);
            backtrack(result, currentList, k, remain - i, i + 1);
            currentList.remove(currentList.size() - 1);
        }
    }
}