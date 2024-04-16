class Solution {
    public int findRoot(int num, HashMap<Integer, Integer> parent){
        if(!parent.containsKey(num)){
            return num;
        }

        if(parent.get(num) != num){
            return findRoot(parent.get(num), parent);
        }

        return parent.get(num);
    }
    
    public int longestConsecutive(int[] nums) {
        /*
            Algorithms & DS: #HashMap, #Union Find
            Time: O(N), Space: O(N)
         */

        int ans = 0;
        HashMap<Integer, Integer> parent = new HashMap<>();
        HashMap<Integer, Integer> count = new HashMap<>();

        for(int num : nums){
            if(parent.containsKey(num))
                continue;

            int rootL = findRoot(num - 1, parent);
            int rootR = findRoot(num + 1, parent);

            int c = 1;

            if(count.containsKey(rootL)){
                parent.put(rootL, num);
                c += count.get(rootL);
            }

            if(count.containsKey(rootR)){
                parent.put(rootR, num);
                c += count.get(rootR);
            }

            parent.put(num, num);
            count.put(num, c);

            ans = Math.max(ans, c);
        }
        
        return ans;
    }
}