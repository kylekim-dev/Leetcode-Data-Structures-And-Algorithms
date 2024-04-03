class Solution {
    // Time: O(N*M) < 10^6, Space: O(N)
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) { // O(N), N < 10^4
            int[] alpha = new int[26];

            for (char c : s.toCharArray()) alpha[c - 'a'] += 1; // O(M) M < 100
            String key = Arrays.toString(alpha);

            if(!map.containsKey(key)) map.put(key, new ArrayList<>());

            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}