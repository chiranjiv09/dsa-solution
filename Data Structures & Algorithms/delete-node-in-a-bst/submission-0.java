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

    // finding the last right of left of the key
    public TreeNode lastRightOfDeletesLeft(TreeNode delLeftKey) {
        while(delLeftKey.right != null) {
            delLeftKey = delLeftKey.right;
        }
        return delLeftKey;
    }

    // Arranging the key in a way of that if either of them is not null
    // so instead of key add left side of key
    // and key.right will eqauls to most right of key.left
    public TreeNode arrangeKeysOfBothSide(TreeNode deleteKey) {
        if(deleteKey.right == null) {
            return deleteKey.left;
        }
        if(deleteKey.left == null) {
            return deleteKey.right;
        }
        // TreeoNode delRight = deleteKey.right;
        TreeNode leftsMostRight = lastRightOfDeletesLeft(deleteKey.left);
        leftsMostRight.right = deleteKey.right;
        return deleteKey.left;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
            return root;
        }
        TreeNode currHead = root;
        if(root.val == key) {
            return arrangeKeysOfBothSide(root);
        }
        while(root != null) {
            if(key < root.val) { // left Side
                if(root.left != null && root.left.val == key) {
                    root.left = arrangeKeysOfBothSide(root.left); // storing as prev key
                } else {
                    root = root.left;
                }
            } else { // right side of tree
                if(root.right != null && root.right.val == key) {
                    root.right = arrangeKeysOfBothSide(root.right); // storing as prev key
                } else {
                    root = root.right;
                }          
            }
        }
        return currHead;
    }
}