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
//  */
// class Solution {
    
//     public boolean hasPathSum(TreeNode root, int targetSum) {
//         if(root==null)
//             return false;
        
//         if(root.left == null &&root.right==null)
//         {
//             return root.val==targetSum;
//         }
//         int remainingSum = targetSum-root.val;
//         return hasPathSum(root.left,remainingSum)||hasPathSum(root.right,remainingSum);
        
//     }
    
// }

class Solution {
    private boolean res = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int sum =0;
        PathSum(root,sum,targetSum);
        return res;
               
    }
    private void PathSum(TreeNode root,int sum ,int k){
        if(root==null||res)
            return;
        sum+=root.val;
        if(root.left == null&&root.right==null)
        {
            if(sum == k)
                res = true;
            return;
        }
        PathSum(root.left,sum,k);
        PathSum(root.right,sum,k);

    }
    
}