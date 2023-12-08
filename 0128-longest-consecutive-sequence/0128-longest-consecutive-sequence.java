class Solution {
    public int longestConsecutive(int[] nums) {
        // Algorithm & DS: HashMap
        // Time: O(n), Extra Space: O(n)
        HashSet<Integer> setNum = new HashSet<>();

        for (int n : nums)
            setNum.add(n);

        int longest = 0;

        for (int n : nums){
            if(!setNum.contains(n - 1)){
                int i = 0;

                while (setNum.contains(n + i))
                    i++;

                longest = Math.max(longest, i);
            }
        }

        return longest;
    }
}