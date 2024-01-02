class Solution {
    public String minWindow(String s, String t) {
        /*
            Algorithms & DS: Queue, HashMap
            Time: O(N), Extra Space: O(M)
         */

        if(s.length() < t.length()){
            return "";
        }
        
        Queue<Integer> q = new LinkedList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0, r = s.length();

        for(Character c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int bal = map.size();

        for(int i = 0; i < s.length(); i++){
            Character curr = s.charAt(i);

            if(map.containsKey(curr)){
                q.offer(i);
                map.put(curr, map.get(curr) - 1);

                if(map.get(curr) == 0){
                    bal -= 1;
                }

                while (!q.isEmpty() && bal <= 0){
                    int j = q.poll();
                    Character leftChar = s.charAt(j);
                    map.put(leftChar, map.get(leftChar) + 1);

                    if(bal == 0 && r - l > i - j){
                        l = j;
                        r = i;
                    }

                    if(map.get(leftChar) == 1){
                        bal += 1;
                    }
                }
            }
        }

        return r < s.length() ?  s.substring(l, r + 1) : "";
    }
}