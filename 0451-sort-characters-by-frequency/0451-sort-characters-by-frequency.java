class Solution {
    public String frequencySort(String s) {
        StringBuilder sorted = new StringBuilder();
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((o1, o2) -> o2[1].compareTo(o1[1]));

        for (Character c: s.toCharArray()) map.put((int)c, map.getOrDefault((int)c, 0) + 1);
        for (Integer key : map.keySet()) pq.add(new Integer[]{ key, map.get(key) });

        while (!pq.isEmpty()){
            Integer[] charAndFreq = pq.poll();
            for(int i = 0; i < charAndFreq[1]; i++){
                sorted.append(Character.toString(charAndFreq[0]));
            }
        }
        
        return sorted.toString();
    }
}