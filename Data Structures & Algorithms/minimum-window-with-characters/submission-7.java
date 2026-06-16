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

        int start = 0;
        char[] arr = s.toCharArray();
        int formed = 0;
        int minLen = Integer.MAX_VALUE;
        String result = "";

        for (int end = 0; end < arr.length; end++) {
            char endChar = arr[end];
            have[endChar]++;

            if (have[endChar] == need[endChar]) formed++;

            while (formed == required) {
                int subLen = end - start + 1;
        
                if (subLen < minLen) {
                    result = new String(Arrays.copyOfRange(arr, start, end+1));
                    minLen = subLen;
                }

                char startChar = arr[start];

                have[startChar]--;

                if (have[startChar] < need[startChar]) formed--;
                start++;
            }
        }
        return result;
    }
}
