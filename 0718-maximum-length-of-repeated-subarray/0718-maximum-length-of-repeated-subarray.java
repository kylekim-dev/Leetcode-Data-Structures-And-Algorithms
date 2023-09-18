class Solution {
    /*
        Algorithms & Data Structure: Brute-force
        Time: O(N^3), Space: O(1)
    */
    public int findLength(int[] nums1, int[] nums2) {
        int max = 0;

        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                if(nums1[i] == nums2[j]) {
                    int localMax = 0;

                    for(int k = 0; k < nums1.length - i && k < nums2.length - j; k++){
                        if(nums1[i + k] != nums2[j + k])
                            break;
                        localMax++;
                    }

                    if(max < localMax) max = localMax;
                }
            }
        }
        
        return max;
    }
}