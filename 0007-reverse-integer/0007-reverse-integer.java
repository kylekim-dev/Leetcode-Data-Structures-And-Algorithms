class Solution {
    public int reverse(int x) {
        long ans = 0;

        while (x != 0){
            ans *= 10;
            ans += x % 10;
            x /= 10;
        }
        
        if(ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE){
            ans = 0;
        }

        return (int)ans;
    }
}