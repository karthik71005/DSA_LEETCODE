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
    private int res =0;
    public int sumNumbers(TreeNode root) {
        int sum =0;
        Numbers(root,sum);
        return res;
    }
    private void Numbers(TreeNode root,int sum)
    {
        if(root==null)
            return;
        sum = sum*10+root.val;
        if(root.left ==null&&root.right==null){
            res+=sum;
            return;
        }
        Numbers(root.left,sum);
        Numbers(root.right,sum);
    }
}