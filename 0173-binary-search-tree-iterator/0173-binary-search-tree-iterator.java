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
class BSTIterator {
    /*
        Algorithm: Inorder Traversal with Iterator
        Time: O(N), Space: O(H)
    */
    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        TreeNode node = root;
        while(node != null){
            stack.push(node);
            node = node.left;
        }
    }
    
    public int next() {
        TreeNode node = stack.pop();
        TreeNode curr = node.right;
        
        while(curr != null){
            stack.push(curr);
            curr = curr.left;
        }
        
        return node.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */