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
    public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
        postOrder(root,res);
        return res;
                
    }
    private void postOrder(TreeNode temp,List<Integer> res)
    {
        if(temp == null)
            return;
        
        postOrder(temp.left,res);
        postOrder(temp.right,res);
        res.add(temp.val);
    }
    
}