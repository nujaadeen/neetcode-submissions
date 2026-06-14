class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();

        if (s1Arr.length > s2Arr.length) return false;

        int start = 0;

        int[] s1FeqCount = new int[26];
        int[] s2FeqCount = new int[26];

        for (int i = 0; i < s1Arr.length; i++) {
            int idxS1 = s1Arr[i] - 'a';
            s1FeqCount[idxS1] += 1;

            int idxS2 = s2Arr[i] - 'a';
            s2FeqCount[idxS2] += 1;
        }

        int matches = 0;

        for (int i = 0; i < 26; i++) {
            if (s1FeqCount[i] == s2FeqCount[i]) {
                matches += 1;
            }
        }

        for (int end = s1Arr.length; end < s2Arr.length; end++) {
            if (matches == 26) return true;
            
            int startIdx = s2Arr[start] - 'a';

            s2FeqCount[startIdx] -= 1;

            if (s2FeqCount[startIdx] == s1FeqCount[startIdx]) {
                matches += 1;
            } else if (s2FeqCount[startIdx] + 1 == s1FeqCount[startIdx]) {
                matches -= 1;
            }
            start++;

            int endIdx = s2Arr[end] - 'a';

            s2FeqCount[endIdx] += 1;

            if (s2FeqCount[endIdx] == s1FeqCount[endIdx]) {
                matches += 1;
            } else if (s2FeqCount[endIdx] - 1 == s1FeqCount[endIdx]){
                matches -= 1;
            } 
        }
        return matches == 26;
    }
}
