class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int half = total / 2;

        int[] a = nums1;
        int[] b = nums2;

        if (nums1.length > nums2.length) {
            a = nums2;
            b = nums1;
        }

        int l = -1, r = a.length - 1;

        while (true) {
            int i = (r - l) / 2 + l;
            int j = half - i - 2;

            int aLeft = (i >= 0) ? a[i] : Integer.MIN_VALUE;
            int aRight = (i+1 < a.length) ? a[i+1] : Integer.MAX_VALUE;
            int bLeft = (j >= 0) ? b[j] : Integer.MIN_VALUE;
            int bRight = (j+1 < b.length) ? b[j+1] : Integer.MAX_VALUE;

            System.out.println("l=" + l + " r=" + r + " i=" + i + " j=" + j + 
                " aLeft=" + aLeft + " aRight=" + aRight + 
                " bLeft=" + bLeft + " bRight=" + bRight);

            if (aLeft > bRight) {
                r = i - 1;
            } else if (bLeft > aRight) {
                l = i + 1;
            } else {
                if (total % 2 == 0) {
                    return (Math.max(aLeft, bLeft) + Math.min(aRight, bRight)) / 2.0;
                } else {
                    return Math.min(aRight, bRight);
                }
            }
        }
    }
}
