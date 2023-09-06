class Solution {
    /*
        Algorithm & DS: Greedy
        Time: O(N), Space: O(N)
    */
    public int maximumSwap(int num) {
        char[] digit = Integer.toString(num).toCharArray();
        int[] max = new int[digit.length];

        max[digit.length - 1] = digit.length - 1;

        // num = 2736 
        // max = 1133 뒤에서부터의 최대값의 인덱스 배열
        for(int i = max.length - 2; i >= 0; i--){
            max[i] = max[i + 1];
            if(digit[i] > digit[max[i]])
                max[i] = i;
        }

        int l = 0, r = 0;

        // 배열의 왼쪽부터 탐색, max의 값과 비교
        // 만약 현재 숫자가 max의 숫자보다 작은경우 반복문 종료
        for(int i = 0; i < digit.length ; i++){
            if(digit[i] < digit[max[i]]){
                l = i;
                r = max[i];
                break;
            }
        }
        // Swap
        char temp = digit[r];
        digit[r] = digit[l];
        digit[l] = temp;

        int output = Integer.parseInt(new String(digit));

        return output;
    }
}