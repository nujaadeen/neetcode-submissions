class Solution {

    public String encode(List<String> strs) {
        return strs.stream()
                    .map(word -> word.length() + "#" + word)
                    .collect(Collectors.joining());
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < str.length()){
            int len = 0;
            while(str.charAt(i) != '#'){
                len = len * 10 + str.charAt(i) - '0';
                i++;
            }
            i++;

            String subString = str.substring(i, i+len);
            result.add(subString);
            i = i + len;
        }
        return result;
    }
}
