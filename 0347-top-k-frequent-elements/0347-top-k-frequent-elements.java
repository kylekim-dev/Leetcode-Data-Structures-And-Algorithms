class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        /*
            Algorithms & DS: #Hashing
            Time: O(N), Space: O(N)
         */

        HashMap<Integer, Integer> count = new HashMap<>();
        HashMap<Integer, Integer> rank = new HashMap<>();
        int[] ans = new int[k];

        for(int num : nums){
            if(!rank.containsKey(num)){
                int initRank = rank.size();
                rank.put(num, initRank);

                if(initRank < k){
                    ans[initRank] = num;
                }
            }

            count.put(num, count.getOrDefault(num, 0) + 1);

            int currRank = rank.get(num);
            int currCount = count.get(num);
            int betterRank = Math.min(k - 1, currRank - 1);

            while (betterRank > -1 && count.get(ans[betterRank]) < currCount){
                int nextNum = ans[betterRank];
                rank.put(nextNum, currRank);
                rank.put(num, betterRank);

                // swap rank
                ans[betterRank] = num;

                if(currRank < k){
                    ans[currRank] = nextNum;
                }

                currRank = betterRank;
                betterRank = currRank - 1;
            }
        }
        
        return ans;
    }
}