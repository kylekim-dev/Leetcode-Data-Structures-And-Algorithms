class Solution {
    public int partitionString(String s) {
        int output = 0;
        int l,r;
        l = r = 0;
        
        HashSet<Character> set = new HashSet<>();
        
        while(r < s.length()){
            if(set.contains(s.charAt(r))){
                output += 1;
                set = new HashSet<>(); 
            }
            
            set.add(s.charAt(r));
            r += 1;
        }
        
        return output + 1;
    }
}