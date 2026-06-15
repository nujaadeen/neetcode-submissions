class Solution {
    public String minWindow(String s, String t) {
        char[] charArrT = t.toCharArray();
        char[] charArrS = s.toCharArray();

        if (charArrS.length < charArrT.length) return "";

        Map<Character, Integer> mapT = new HashMap<>();
        Map<Character, Integer> mapS = new HashMap<>();

        for (int i = 0; i < charArrT.length; i++) {
            mapT.put(charArrT[i], mapT.getOrDefault(charArrT[i], 0) + 1);
        }

        int start = 0;
        int minLen = 1001;
        int found = 0;
        String returnVal = "";

        for (int end = 0; end < charArrS.length; end++) {
            if (mapT.containsKey(charArrS[end])) {
                mapS.put(charArrS[end], mapS.getOrDefault(charArrS[end], 0) + 1);
                if (mapS.get(charArrS[end]) <= mapT.get(charArrS[end])) {
                    found += 1;
                } 
            }

            while (found == charArrT.length && end - start + 1 >= charArrT.length) {
                
                if (end - start + 1< minLen) {
                    returnVal = new String(Arrays.copyOfRange(charArrS, start, end+1));
                    minLen = end - start + 1;
                }

                if (mapT.containsKey(charArrS[start])) {
                    mapS.put(charArrS[start], mapS.get(charArrS[start]) - 1);
                    if (mapS.get(charArrS[start]) < mapT.get(charArrS[start])) {
                        found -= 1;
                    } 
                }
                start++;
            }
        }
        return returnVal;
    }
}
