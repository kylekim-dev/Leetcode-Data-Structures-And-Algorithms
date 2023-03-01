class Solution {
    /*
        1 2 3 4

        1
        1 2
        1 2 3 4
        1 2 x 4
        1 x 3 4
        1 x x 4
        x x x 4

        아이디어
            중복을 제외한 백트래킹을 사용하여 O(N!)의 시간 복잡도에 해결한다.
            1.

        시간복잡도
            O(N!) = 3,628,800 < 1 * 10 ^ 8
        자료구조 및 알고리즘
            1. 방문 체크용 Set 선언
            2. 중복 문자 체크 Set 선언
     */

    private HashSet<Integer> visit = new HashSet<>();
    private HashSet<List<Integer>> dict = new HashSet<>();

    public void backtracking(int[] nums, int depth, List<Integer> local, List<List<Integer>> output){
        if(nums.length == depth){
            return;
        }

        for(int i = depth; i < nums.length; i++){
            if(visit.contains(i)){
                continue;
            }

            visit.add(i);
            local.add(nums[i]);

            if(!dict.contains(local)){
                dict.add(new ArrayList<>(local));
                output.add(new ArrayList<>(local));
            }

            backtracking(nums, i + 1, local, output);

            visit.remove(i);
            local.remove(local.size() - 1);
        }
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(nums);
        output.add(new ArrayList<>());
        backtracking(nums, 0, new ArrayList<>(), output);

        return output;
    }
}