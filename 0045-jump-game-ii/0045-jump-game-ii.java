class Solution {
    /*
        아이디어
            1. 최단 거리를 위한 배열 min을 선언한다.
            2. r = nums.length - 1;
            3. 가장 끝 배열을 1로 초기화 한다.
            4. r를 1 감소 시키고,
                nums[1 + r, ... , nums[r] + r] 중에 가장 작은 값을 찾는다.
            5. min[r] = 가장 작은 값 + 1을 해준다.
            6. r > -1면 3 - 5번을 반복한다.
            7. return min[0]미국 부채 한도 연장 6월

        알고리즘
            DP

        시간 복잡도
            O(N^2)
     */
    public int jump(int[] nums) {
        int[] min = new int[nums.length];
        int r = nums.length - 1;

        nums[r] = 0;
        r -= 1;

        while (r > -1){
            int localMin = 10000;

            for(int i = 1; i <= nums[r]; i++){
                if(r + i >= min.length){
                    break;
                }
                localMin = Math.min(localMin, min[r + i]);
            }

            min[r] = localMin + 1;
            r -= 1;
        }

        return min[0];
    }
}