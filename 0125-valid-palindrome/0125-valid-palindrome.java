class Solution {
    /*
    0 1 2 3 4 5 6 7
    r a c e a c a r
    
    0 1 2 3 4 5 6
    c a r n c a r
    
    1. 홀 수 일땐 [n - 1, n + 1]
    2. 짝 수일땐  [n / 2, n + 1]
    
    */
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int n = s.length();
        int l, r;
        l = r = n / 2;

        if(n % 2 == 1) r += 1;
        l -= 1;

        while (r < n){
            if(s.charAt(l) != s.charAt(r)) return false;
            l -= 1;
            r += 1;
        }

        return true;
    }
}