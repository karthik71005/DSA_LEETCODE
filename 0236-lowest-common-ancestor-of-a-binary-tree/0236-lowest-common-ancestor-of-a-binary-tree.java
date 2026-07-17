/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         ans = null;
        commonAncestor(root,p, q);
        return ans;
    }
    private int commonAncestor(TreeNode root,TreeNode p,TreeNode q){
        if(root== null)
            return 0;
            int self =0;
          if((root==p) || (root ==q))
            self =1;
        int left = commonAncestor(root.left,p,q);
        int right = commonAncestor(root.right,p,q);

        int total = right+left+self;
        if(total == 2 && ans ==null)
            ans = root;
        return total;
            
    }
}