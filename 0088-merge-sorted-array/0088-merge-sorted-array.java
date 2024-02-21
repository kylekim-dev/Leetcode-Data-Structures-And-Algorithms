class Solution {
    // Algorithm & DS: Iterative
    // Time: O(n + m), Extra Space: O(1)
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int n1 = m - 1;
        int n2 = n - 1;
        int n3 = m + n -1;

        // 모든 배열을 뒤에서부터 크기를 비교한다.
        // 비교해서 더 큰 수를 nums1의 가장자리부터 위치시켜준다.
        while (n1 >= 0 && n2 >= 0){
            if(nums1[n1] >= nums2[n2]) nums1[n3--] = nums1[n1--];
            else nums1[n3--] = nums2[n2--];
        }

        // 하나의 배열을 다 탐색 한 후에 남아있는 데이터들은
        // nums1에 위치시켜준다.
        while (n1 >= 0) nums1[n3--] = nums1[n1--];
        while (n2 >= 0) nums1[n3--] = nums2[n2--];   
    }
}