import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        /*
            Algorithms & DS: Monotonic Stack
            Time: O(M + N), Extra Space: O(N)
            M = nums1.length
            N = nums2.length
         */

        int[] ans = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int n2 : nums2){
            while (!stack.isEmpty() && stack.peek() < n2){
                int smaller = stack.pop();

                if(!map.containsKey(smaller)){
                    map.put(smaller, n2);
                }
            }

            stack.push(n2);
        }

        for(int i = 0; i < nums1.length; i++){
            ans[i] = map.getOrDefault(nums1[i], -1);
        }

        return ans;
    }
}