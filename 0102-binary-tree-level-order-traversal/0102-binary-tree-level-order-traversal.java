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
    List<List<Integer>> result;
    public void levelOrder(TreeNode root, int level) {
        if(root == null) return;
        
        List<Integer> group;
        
        if(level == result.size()){
            group = new ArrayList<>();
            result.add(group);
        }
        else {
            group = result.get(level);
        }
        
        group.add(root.val);
        
        levelOrder(root.left, level + 1);
        levelOrder(root.right, level + 1);
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        levelOrder(root, 0);
        return result;
    }
    
    /*public List<List<Integer>> levelOrder(TreeNode root) {
        // Algorithm: BFS, Queue
        // Time: O(N), Space: O(N)
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if(root == null){
            return ans;
        }

        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> childs = new ArrayList<>();

            for(int s = 0; s < size; s++){
                TreeNode node = q.remove();
                childs.add(node.val);

                if(node.left != null){
                    q.add(node.left);
                }

                if(node.right != null){
                    q.add(node.right);
                }
            }

            ans.add(childs);
        }

        return ans;
    }*/
}