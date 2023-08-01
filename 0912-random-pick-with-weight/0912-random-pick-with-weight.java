class Solution {

    int total;
    int[] range;
    Random random = new Random();

    public Solution(int[] w) {
        range = new int[w.length];
        total = 0;
        
        for(int i = 0; i < w.length; i++){
            total += w[i];
            range[i] = total; 
        }
    }
    
    public int pickIndex() {
        int target = random.nextInt(total) + 1;
        int l = 0, r = range.length - 1;
        int m = 0;

        while(l < r){
            m = (r + l) / 2;
            if(range[m] < target) l = m + 1;
            else r = m;
        }

        return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */