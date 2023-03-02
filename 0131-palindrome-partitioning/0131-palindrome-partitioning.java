class Solution {
    public void backtracking(String s, int depth, List<Integer> ranges, List<List<String>> result){
        if(s.length() <= depth){
            if(s.length() == depth){
                int start = 0;
                List<String> palindromes = new ArrayList<>();
                for (int range : ranges) {
                    String str =  s.substring(start, start + range);
                    if(isPalindrome(str)){
                        palindromes.add(str);
                    }
                    else {
                        return;
                    }

                    start += range;
                }

                result.add(palindromes);
            }
            return;
        }
        for(int i = 1; i < s.length(); i++){
            ranges.add(i);
            backtracking(s, depth + i, ranges, result);
            ranges.remove(ranges.size() - 1);
        }
    }

    // O(N)
    public boolean isPalindrome(String s){
        int len = s.length();
        int left = 0;
        int right = len - 1;

        while (left <= right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<Integer> ranges = new ArrayList<>();

        backtracking(s, 0, ranges, result);
        if(isPalindrome(s)){
            List<String> p = new ArrayList<>();
            p.add(s);
            result.add(p);
        }

        return result;
    }
}