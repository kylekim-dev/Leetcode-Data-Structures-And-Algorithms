class Solution {
    /*

        1번 바꿀 수 있음
        가장 앞에 작은 숫자와
        그 뒤에나오는 가장 큰수를 바꿔야됨

        2736

        27936
        97236

        9937 >> 9973


        01234
        27936

        0   4   2 < 6, prevMaxIndex 4 
        0   3   2 < 3, prevMaxIndex 4
        0   2   2 < 9, prevMaxIndex 2
        2   7   2 < 7, prevMaxIndex 2 
        swap 0 and 2

        0123
        9937

        0   3   9 > 7
        1   3   9 > 7
        2   3   3 < 7   p = 3
        2   2 >> swap 2 and 3

    */
    public int maximumSwap(int num) {
        char[] digit = Integer.toString(num).toCharArray();
        int[] max = new int[digit.length];

        max[digit.length - 1] = digit.length - 1;

        for(int i = max.length - 2; i >= 0; i--){
            max[i] = max[i + 1];
            if(digit[i] > digit[max[i]])
                max[i] = i;
        }

        int l = 0, r = 0;

        for(int i = 0; i < digit.length ; i++){
            if(digit[i] < digit[max[i]]){
                l = i;
                r = max[i];
                break;
            }
        }

        char temp = digit[r];
        digit[r] = digit[l];
        digit[l] = temp;

        int output = Integer.parseInt(new String(digit));

        return output;
    }
}