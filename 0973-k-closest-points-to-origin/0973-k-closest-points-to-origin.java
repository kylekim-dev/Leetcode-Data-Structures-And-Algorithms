class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Algorithm & DS: TreeMap
        // Time: O(N*LogN) Space: O(N)

        TreeMap<Integer, List<int[]>> tm = new TreeMap<>();
        int[][] output = new int[k][2];

        // O(N*LogN)
        for(int i = 0; i < points.length; i++){
            int key = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            if(!tm.containsKey(key)) tm.put(key, new ArrayList<>());
            List<int[]> chaining = tm.get(key);
            chaining.add(points[i]);
        }

        int i = 0;
        for(List<int[]> chains : tm.values()){
            for(int[] point : chains) output[i++] = point;
            if(i >= k) break;
        }
        
        return output;
    }
}