class Solution {
    /*

        [0, 0] [0, 1] [0, 2] [1, 0] [1, 2] << HashMap을 사용해서

        digits index,
        백트래킹 탈출 조건
            - digit index == digit.length
            - StringBuilder에 값을 output에 넣어줌

        char[digitindex][] = {''} 문자

        아이디어
            비중복 백트래킹 알고리즘을 사용한다 O(N!)
        자료구조
            백트래킹

        시간복잡도
            O((N + M)!) = 12! = 479,001,600, 약 5초

     */
    private char[][] keypads = new char[][]{
            { 'a', 'b', 'c' },
            { 'd', 'e', 'f' },
            { 'g', 'h', 'i' },
            { 'j', 'k', 'l' },
            { 'm', 'n', 'o' },
            { 'p', 'q', 'r', 's' },
            { 't', 'u', 'v' },
            { 'w', 'x', 'y', 'z' }
    };

    public void backtracking(String digits, int digitIndex, StringBuilder history, List<String> result){
        if(digitIndex == digits.length()){
            result.add(history.toString());
            return;
        }
        int key = Character.getNumericValue(digits.charAt(digitIndex)) - 2;
        for(int i = 0; i < keypads[key].length; i++){
            history.append(keypads[key][i]);
            backtracking(digits, digitIndex + 1, history, result);
            history.deleteCharAt(history.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length() == 0){
            return result;
        }

        backtracking(digits, 0, new StringBuilder(), result);

        return result;
    }
}