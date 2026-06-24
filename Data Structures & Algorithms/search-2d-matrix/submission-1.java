class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0, r = m - 1;

        int targetN = -1;

        while (l <= r) {
            int mid = (r - l) / 2 + l;
            int midStart = matrix[mid][0];
            int midEnd = matrix[mid][n-1];
    
            if (midStart <= target && target <= midEnd) {
                targetN = mid;
                break;
            } else if (target < midStart) {
                r = mid - 1;
            } else {
                l = mid + 1; 
            }
        }

        if (targetN == -1) return false;

        l = 0; 
        r = n - 1;

        while (l <= r) {
            int mid = (r - l) / 2 + l;
            int midVal = matrix[targetN][mid];

            if (target == midVal) {
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
