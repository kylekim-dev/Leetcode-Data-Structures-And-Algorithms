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
import java.util.*;

class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        /*
            Algorithms & DS: #Tree
            Time: O(N), Extra Space: O(n)
         */

        Map.Entry<TreeNode, Integer> ans = lcaDeepestLeaves(root, 0);
        
        return ans.getKey();
    }

    public Map.Entry<TreeNode, Integer> lcaDeepestLeaves(TreeNode node, int level){
        if(node == null){
            return new AbstractMap.SimpleEntry<>(null, -1);
        }

        Map.Entry<TreeNode, Integer> l = lcaDeepestLeaves(node.left, level + 1);
        Map.Entry<TreeNode, Integer> r = lcaDeepestLeaves(node.right, level + 1);

        if(l.getValue() > r.getValue()){
            return new AbstractMap.SimpleEntry<>(l.getKey(), l.getValue());
        }
        else if(l.getValue() < r.getValue()){
            return new AbstractMap.SimpleEntry<>(r.getKey(), r.getValue());
        }
        else if(l.getValue() == -1 && r.getValue() == -1){
            return new AbstractMap.SimpleEntry<>(node, level);
        }

        return new AbstractMap.SimpleEntry<>(node, Math.max(l.getValue(), r.getValue()));
    }
}