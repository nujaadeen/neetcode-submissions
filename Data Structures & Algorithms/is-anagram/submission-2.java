class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> s_map = new HashMap<>();
        Map<Character, Integer> t_map = new HashMap<>();

        for(char c : s.toLowerCase().toCharArray()){
            s_map.put(c, s_map.getOrDefault(c, 0)+1);
        }

        for(char c : t.toLowerCase().toCharArray()){
            t_map.put(c, t_map.getOrDefault(c, 0)+1);
        }

        return s_map.equals(t_map);
    }
}
