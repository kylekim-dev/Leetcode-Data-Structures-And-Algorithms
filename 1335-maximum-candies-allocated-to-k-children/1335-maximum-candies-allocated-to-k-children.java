class Solution {
    public int maximumCandies(int[] candies, long k) {
        long sum = 0;
        for (int candy : candies) {
            sum += candy;
        }

        if(sum < k){
            return 0;
        }

        int l = 0, r = 10000000;

        while (l <= r){
            int m = (r + l) / 2;
            boolean isSuccess = false;
            sum = 0;

            for(int i = 0; i < candies.length; i++){
                sum += candies[i] / m;
                if(sum >= k){
                    isSuccess = true;
                    break;
                }
            }

            if(isSuccess) l = m + 1;
            else r = m - 1;
        }

        return r;
    }
}