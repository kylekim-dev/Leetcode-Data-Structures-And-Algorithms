class Solution {
    public int kthFactor(int n, int k) {
        int i = 0, f = 1;
        
        while(f <= n && i < k){
            if(n % f == 0){
                i += 1;
                
                if (k == i) return f;
            }
            
            f += 1;
        }
        
        return -1;
    }
}