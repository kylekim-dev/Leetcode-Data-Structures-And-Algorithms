class Solution {
    public List<List<Integer>> generate(int numRows) {
        /*
            Algorithm & DS: Iterator
            Time: O(n^2), Extra Space: O(1)
        */
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>(List.of(1)));

        for(int i = 1; i < numRows; i++){
            List<Integer> local = new ArrayList<>();

            for(int j = 0; j <= i; j++){
                int a = 0, b = 0;

                if(j - 1 >= 0)
                    a = res.get(i - 1).get(j - 1);

                if(j < res.get(i - 1).size())
                    b = res.get(i - 1).get(j);

                local.add(a + b);
            }

            res.add(local);
        }
        
        return res;
    }
}