class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Integer>, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            List<Integer> key = toAlphaArray(str);

            map.putIfAbsent(key, new ArrayList<String>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }

    private List<Integer> toAlphaArray(String str) {
        List<Integer> alphaArray = IntStream.range(0, 26)
            .mapToObj(i -> 0)
            .collect(Collectors.toList());

        for (char c : str.toLowerCase().toCharArray()){
            alphaArray.set(c - 'a', alphaArray.get(c - 'a') + 1);
        }

        return alphaArray;
    }
}
