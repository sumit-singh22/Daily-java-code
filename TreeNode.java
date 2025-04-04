import java.util.HashMap;
public class TreeNode {
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
class Solution {
    private HashMap<TreeNode, Integer> heightMap = new HashMap<>();
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        computeHeight(root);  
        return findLCA(root); 
    }
    private int computeHeight(TreeNode node) {
        if (node == null) return 0;
        int leftHeight = computeHeight(node.left);
        int rightHeight = computeHeight(node.right);
        int height = Math.max(leftHeight, rightHeight) + 1;
        heightMap.put(node, height);
        return height;
    }
    private TreeNode findLCA(TreeNode node) {
        if (node == null) return null;
        
        int leftHeight = heightMap.getOrDefault(node.left, 0);
        int rightHeight = heightMap.getOrDefault(node.right, 0);

        if (leftHeight == rightHeight) {
            return node;
        } 
        return leftHeight > rightHeight ? findLCA(node.left) : findLCA(node.right);
    }
}