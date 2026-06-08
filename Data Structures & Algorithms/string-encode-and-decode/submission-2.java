class Solution {

    public String encode(List<String> strs) {
        return strs.stream()
                    .map(word -> word.length() + "#" + word)
                    .collect(Collectors.joining());
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        System.out.println(str);
        int lastIndx = 0;
        for (int i = 0 ; i < str.length() ; i++) {
            if (str.charAt(i) == '#') {
                int itr = i-1;
                String lenStr = "";
                while(itr >= 0 && lastIndx <= itr){
                    lenStr = str.charAt(itr) + lenStr;
                    itr = itr - 1;
                }
                System.out.println(lenStr);
                int len = Integer.parseInt(lenStr);;
                String resStr = "";
                for (int j = i+1 ; j < i+len+1 ; j++) {
                    resStr = resStr + str.charAt(j);
                }
                System.out.println(resStr);
                result.add(resStr);
                i = i + len;
                lastIndx = i + 1;
            }
        }
        return result;
    }
}
