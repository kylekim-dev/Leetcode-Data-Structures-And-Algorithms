class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for(int i = 0; i < strs.length; i++){
            String val = strs[i];
            char[] sorted = val.toCharArray();
            Arrays.sort(sorted);
            String key = new String(sorted);

            if(!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(val);
        }

        for(String key : map.keySet()){
            result.add(map.get(key));
        }

        return result;
    }
}