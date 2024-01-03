class Solution {
    public List<List<Integer>> generate(int numRows) {
        /*
            Algorithm & DS: BFS
            Time: O(n^2), Extra Space: O(1)
        */
        List<List<Integer>> res = new ArrayList<>();
        res.add(Collections.singletonList(1));

        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = res.get(i - 1);
            List<Integer> currentRow = new ArrayList<>(i + 1);

            for (int j = 0; j <= i; j++) {
                int left = (j - 1 >= 0) ? prevRow.get(j - 1) : 0;
                int right = (j < prevRow.size()) ? prevRow.get(j) : 0;
                currentRow.add(left + right);
            }

            res.add(currentRow);
        }
        
        return res;
    }
}