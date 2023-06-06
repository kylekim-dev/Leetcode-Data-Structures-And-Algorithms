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
    /*
        contraints: where the values of exactly two nodes 
        a1: 오름차순을 따르지 않는 첫번째 요소
        a2: 오름차순을 따르지 않는 두번째 요소 
        
        1 7 3 4 5 6 2 8
        
        a1: 7
        a2: 2
        
    */
    TreeNode n1 = null, n2 = null, prev = null;
    
    private void inorder(TreeNode curr){
        if (curr == null) return;

        inorder(curr.left);
        if(prev != null && prev.val >= curr.val){
            if(n1 == null) n1 = prev;
            n2 = curr;   
        }
        
        prev = curr;
        inorder(curr.right);
    }
    
    public void recoverTree(TreeNode root) {
        // Algorithm: Inorder-Traversal, Reccursion
        // Time: O(N), Space: O(N) [Stack]
        inorder(root);
        
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }
}