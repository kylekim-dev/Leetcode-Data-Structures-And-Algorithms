class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {

        List<Stack<Integer>> arr = new ArrayList<>();
        int totalSize = 0;

        for(int i = 0; i < nums.size(); i++){
            for(int j = 0; j < nums.get(i).size(); j++){
                int z = i + j;

                if(arr.size() <= z)
                    arr.add(new Stack<>());

                Stack<Integer> q = arr.get(z);
                q.push(nums.get(i).get(j));
                totalSize++;
            }
        }

        int[] output = new int[totalSize];
        int j = 0;

        for(int i = 0; i < arr.size(); i++){
            Stack<Integer> stack = arr.get(i);
            while (!stack.isEmpty()){
                output[j] = stack.pop();
                j++;
            }
        }

        return output;
    }
}