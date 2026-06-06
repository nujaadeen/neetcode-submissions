class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            String key = getMapKey(str);

            map.putIfAbsent(key, new ArrayList<String>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }

    private String getMapKey(String str) {
        int[] count = new int[26];

        for (char c : str.toCharArray()){
            count[c - 'a']++;
        }

        return Arrays.toString(count);
    }
}
