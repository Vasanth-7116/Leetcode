class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int s = 0;
        int e = matrix.length-1;
        while(s<=e){
            
            int mid = s + (e-s)/2;
          
            if(matrix[mid][0]<=target&&target<=matrix[mid][matrix[mid].length-1]){
                return search(matrix,mid,target);
            }
            else if(matrix[mid][0]>target){
                e = mid -1;
            }
            else{
                s = mid+1;
            }
        }

        return false;

    }
        
    

    static boolean search(int[][] matrix,int i, int target) {
        int s = 0;
        int e = matrix[i].length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (matrix[i][mid] == target) {
                return true;
            } else if (matrix[i][mid] > target) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return false;
    }
}