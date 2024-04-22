class Solution {
    public String minWindow(String s, String t) {
        /*
            Algorithms & DS: #Sliding Window, #Queue
            Time: O(N), Space: O(N)
         */

        if(s.length() < t.length()){
            return "";
        }

        int[] ansIndex = {-1, s.length()};
        int l = 0,r = 0;
        int bal = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        Queue<Integer> q = new ArrayDeque<>();

        for(Character c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        while (r < s.length()){
            Character curr = s.charAt(r);

            if(map.containsKey(curr)){
                map.put(curr, map.get(curr) - 1);
                if(map.get(curr) == 0){
                    bal++;
                }

                q.offer(r);
            }

            while (!q.isEmpty() && bal == map.size()){
                l = q.poll();

                if(ansIndex[1] - ansIndex[0] > r - l){
                    ansIndex[0] = l;
                    ansIndex[1] = r;
                }

                map.put(s.charAt(l), map.get(s.charAt(l)) + 1);

                if(map.get(s.charAt(l)) == 1){
                    bal--;
                }
            }

            r++;
        }
        
        if(ansIndex[0] < 0){
            return "";
        }
        
        return s.substring(ansIndex[0], ansIndex[1] + 1);
        
    }
}