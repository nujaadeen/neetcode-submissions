class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = Arrays.stream(piles).max().getAsInt();

        int minK = r;

        while (l <= r) {
            int k = (r - l) / 2 + l;
            long total = 0;

            for(int pile : piles) {
                total += Math.ceilDiv(pile, k);
            }

            if (total <= h) {
                minK = Math.min(minK, k);
                r = k - 1;
            } else if (total > h) {
                l = k + 1;
            }
        }

        return minK;
    }
}
