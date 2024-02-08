/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        /*
            Algorithms & DS: #BFS, #Recursion
            Time: O(N), Extra Space: O(N)
        */
        List<List<Integer>> ans = new ArrayList<>();
        levelOrder(root, 1, ans);
        
        return ans;
    }
    private void levelOrder(TreeNode node, int depth, List<List<Integer>> ans){
        if(node == null){
            return;
        }
        
        while(ans.size() < depth){
            ans.add(new ArrayList<>());
        }
        
        ans.get(depth - 1).add(node.val);
        levelOrder(node.left, depth + 1, ans);
        levelOrder(node.right, depth + 1, ans);
    }
}