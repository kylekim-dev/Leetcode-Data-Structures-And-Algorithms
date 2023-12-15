class Solution {
    public int candy(int[] ratings) {
        /*
            Algorithms & DS: Two side Iterator
            Time: O(N), Extra Space: O(N)
        */
        int res = 0, prev = 1;
        int[] minCandies = new int[ratings.length];
        minCandies[0] = 1;
        
        for(int i = 1; i < ratings.length; i++){
            if(ratings[i - 1] < ratings[i]) prev++;
            else prev = 1;

            minCandies[i] = Math.max(minCandies[i], prev);
        }

        prev = 1;
        for(int i = ratings.length - 2; i >= 0; i--){
            if(ratings[i] > ratings[i + 1]) prev++;
            else prev = 1;

            minCandies[i] = Math.max(minCandies[i], prev);
        }

        for(int num : minCandies){
            res += num;
        }
        
        return res;
    }
}