class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] need = new int[128];
        int[] have = new int[128];
        int required = 0;

        for (char c : t.toCharArray()) {
            if (need[c] == 0) required++;
            need[c]++;
        } 

        int start = 0, formed = 0, minLen = Integer.MAX_VALUE, resStart = 0;
        char[] arr = s.toCharArray();

        for (int end = 0; end < arr.length; end++) {
            char endChar = arr[end];
            have[endChar]++;

            if (have[endChar] == need[endChar]) formed++;

            while (formed == required) {
                if (end - start + 1 < minLen) {
                    resStart = start;
                    minLen = end - start + 1;
                }

                char startChar = arr[start];

                have[startChar]--;

                if (have[startChar] < need[startChar]) formed--;
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(resStart, resStart+minLen);
    }
}
