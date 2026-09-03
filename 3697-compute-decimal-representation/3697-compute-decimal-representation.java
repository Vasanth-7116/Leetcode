class Solution {
    public int[] decimalRepresentation(int n) {
        int mul = 1;
        List<Integer> list = new ArrayList<>();
        while(n>0){
            int val = (n%10)*mul;
            if(val!=0){
                list.add(0,val);
            }
            
            mul *= 10;
            n=n/10;
        }
        int[] arr = new int[list.size()];
        for(int i=0;i<arr.length;i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
}