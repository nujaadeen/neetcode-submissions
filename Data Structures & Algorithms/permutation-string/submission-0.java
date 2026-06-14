class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();

        int start = 0;

        int[] s1FeqCount = new int[26];
        int[] s2FeqCount = new int[26];

        for (char c : s1Arr) {
            int idx = c - 'a';
            s1FeqCount[idx] = s1FeqCount[idx] + 1;
        }

        for (int end = 0; end < s2Arr.length; end++) {
            int idx = s2Arr[end] - 'a';
            if (s2FeqCount[idx] > s1FeqCount[idx] || end - start + 1 > s1Arr.length) {
                s2FeqCount[s2Arr[start] - 'a'] = s2FeqCount[s2Arr[start] - 'a'] - 1;
                start++;
            }
            s2FeqCount[idx] = s2FeqCount[idx] + 1;
            if (Arrays.equals(s1FeqCount, s2FeqCount)) {
                return true;
            }
        }
        return false;
    }
}
