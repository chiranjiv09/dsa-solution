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

// inorder of BST will give sorted order
class Solution {
    int count = 0;
    int ans = -1;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) {
            return -1;
        }
        kthSmallest(root.left, k);
        count++;
        if(k == count) {
            ans = root.val;
            return ans;
        }
        kthSmallest(root.right, k);
        return ans;
    }
}
