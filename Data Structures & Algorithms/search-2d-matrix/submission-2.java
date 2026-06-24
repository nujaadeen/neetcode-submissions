class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0, r = m - 1;

        while (l <= r) {
            int mid = (r - l) / 2 + l;
            int midStart = matrix[mid][0];
            int midEnd = matrix[mid][n-1];
    
            if (target < midStart) {
                r = mid - 1;
            } else if (target > midEnd){
                l = mid + 1; 
            } else {
                int left = 0; 
                int right = n - 1;

                while (left <= right) {
                    int mid2 = (right - left) / 2 + left;
                    int midVal = matrix[mid][mid2];

                    if (target == midVal) {
                        return true;
                    } else if (target < midVal) {
                        right = mid2 - 1;
                    } else {
                        left = mid2 + 1;
                    }
                }

                return false;
            }
        }

        return false;
    }
}
