class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        /*
            Algorithms & DS: #Two Pointer
            Time: O(m + n), Extra Space: O(1)
         */
        m -= 1; n -= 1;

        while (m >= 0 && n >= 0){
            if(nums1[m] < nums2[n])  {
                nums1[m + n + 1] = nums2[n--];
            }
            else {
                nums1[m + n + 1] = nums1[m--];
            }
        }

        while (n >= 0){
            nums1[n] = nums2[n--];
        }
    }
}