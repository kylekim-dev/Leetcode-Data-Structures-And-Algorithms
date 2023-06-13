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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> nums = new ArrayList<>();
        if(root != null)
            stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode node = stack.peek();
            
            if(node.left != null && node.left.val != Integer.MIN_VALUE){
                stack.push(node.left);
                continue;
            }
            
            nums.add(node.val);
            node.val = Integer.MIN_VALUE;
            stack.pop();
            
            if(node.right != null && node.right.val != Integer.MIN_VALUE){
                stack.push(node.right);
            }
        }
        
        
        return nums;
    }
}