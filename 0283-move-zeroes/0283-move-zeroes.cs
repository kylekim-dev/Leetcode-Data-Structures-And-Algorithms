public class Solution {
    public void MoveZeroes(int[] nums) {
        var q = new Queue<int>();
        foreach(var d in nums){
            if(d != 0){
                q.Enqueue(d);
            }
        }
        
        for(int i = 0; i < nums.Length; i++){
            if(q.Count > 0){
                nums[i] = q.Dequeue();
            }
            else {
                nums[i] = 0;
            }
        }
    }
}