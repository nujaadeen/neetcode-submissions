class TimeMap {

    Map<String, List<Map.Entry<String, Integer>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Map.Entry<String, Integer>> valList = map.getOrDefault(key, new ArrayList<>());
        valList.add(Map.entry(value, timestamp));
        map.put(key, valList);
    }
    
    public String get(String key, int timestamp) {
        List<Map.Entry<String, Integer>> valList = map.getOrDefault(key, new ArrayList<>());

        int l = 0, r = valList.size() - 1;

        String res = "";

        while(l <= r) {
            int mid = (r - l) / 2 + l;

            int time = valList.get(mid).getValue();

            if (time <= timestamp) {
                res = valList.get(mid).getKey();
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
}
