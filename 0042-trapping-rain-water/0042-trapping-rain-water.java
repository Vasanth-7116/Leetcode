class Solution {
    public int trap(int[] h) {
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=1;i<h.length;i++){
            if(stack.isEmpty()){
                stack.push(h[i-1]);
            }
            if(!stack.isEmpty()&&stack.peek()<h[i-1]){
                stack.pop();
                stack.push(h[i-1]);
            }
            int lmax = stack.peek();
            int rmax = rightmax(i,h);
            if(h[i]<lmax && h[i]<rmax){
                int min = Math.min(lmax,rmax);
                count += min - h[i];
            }
            
        }return count;
    }
    

    static int rightmax(int index,int[] h){
        int max = 0;
        for(int i=index;i<h.length;i++){
            max = Math.max(max,h[i]);
        }
        return max;
    }
}