class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0, r = (m * n) - 1;

        while (l <= r) {
            int mid = (r - l) / 2 + l;
            int midVal = matrix[mid/n][mid%n];
    
            if (midVal == target) {
                return true;
            } else if (target < midVal) {
                r = mid - 1;
            } else {
                l = mid + 1; 
            }
        }
        return false;
    }
}
