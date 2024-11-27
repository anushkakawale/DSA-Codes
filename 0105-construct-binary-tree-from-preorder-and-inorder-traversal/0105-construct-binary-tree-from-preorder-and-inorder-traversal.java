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
import java.util.HashMap;
import java.util.Map;
class Solution {
    int preOrderIndex; 
    Map<Integer, Integer> inorderMap; 

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preOrderIndex = 0; 
        inorderMap = new HashMap<>();
        
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return arrayToTree(preorder, 0, inorder.length - 1);
    }

    public TreeNode arrayToTree(int[] preorder, int left, int right){
        if (left > right) {
            return null;
        }
        int rootValue = preorder[preOrderIndex++];
        TreeNode root = new TreeNode(rootValue);
        root.left = arrayToTree(preorder, left, inorderMap.get(rootValue) - 1);
        root.right = arrayToTree(preorder, inorderMap.get(rootValue) + 1, right);

        return root;
    }
}