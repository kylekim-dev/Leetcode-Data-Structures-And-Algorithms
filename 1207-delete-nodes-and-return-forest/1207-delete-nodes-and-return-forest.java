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
        Algorithm & DS: PostOrder & HashSet
        Time: O(N), Space: O(M) M = to_delete size
    */
    public TreeNode postOrder(TreeNode node, HashSet<Integer> nodeDelete, List<TreeNode> output){
        if(node == null)
            return node;

        node.left = postOrder(node.left, nodeDelete, output);
        node.right = postOrder(node.right, nodeDelete, output);

        if(nodeDelete.contains(node.val)){
            if(node.left != null) output.add(node.left);
            if (node.right != null) output.add(node.right);
            return null;
        }

        return node;
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> nodeDelete = new HashSet<>();
        List<TreeNode> output = new ArrayList<>();

        for (int del : to_delete) nodeDelete.add(del);
        root = postOrder(root, nodeDelete, output);

        if(root != null) output.add(root);

        return output;
    }
}