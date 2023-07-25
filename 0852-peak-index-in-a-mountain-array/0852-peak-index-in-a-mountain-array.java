class Solution {
    /*
        find pivot index:
        pivot은 a < b > c
        
        1 2 3 4 5 6 1
        a < b < c: pivot이 오른쪽에 있다
        a > b > c: pivot이 왼쪽에 있다
        
        0 1 2 3 4 5 6
        1 2 3 4 5 6 1
        
        3, 4, 5
        
         0   1  2  3  4  5  6   7  8
        [18,29,38,59,98,100,99,98,90]
        
    */
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0, r = arr.length - 1, i;
        
        while(l < r){
            i = (r + l) / 2;
            
            if(arr[i] < arr[i + 1]){
                l = i + 1;
            }
            else {
                r = i;
            }
        }
        
        return l;
    }
}