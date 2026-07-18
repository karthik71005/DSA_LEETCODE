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
    TreeNode first =null;
    TreeNode second = null;
    TreeNode prev = null;
    public void recoverTree(TreeNode root) {
        Inorder(root);
        if (first != null && second != null) {
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    }
    private void Inorder(TreeNode temp)
    {
        if(temp == null)
            return;
        Inorder(temp.left);
        if(prev == null)
            prev=temp;
        else{
            if(temp.val<prev.val)
            {
                if(first==null)
                    first = prev;
                second = temp;
            }
          
        }
          prev=temp;
        Inorder(temp.right);
    }

}