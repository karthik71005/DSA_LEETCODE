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
    private List<Integer> res = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        Inorder(root);
        for(int i =0;i<res.size()-1;i++)
        {
            if(res.get(i)>=res.get(i+1))
                return false;
        }
        return true;
    }
    private void Inorder(TreeNode temp)
    {
        if(temp == null)
            return;
        Inorder(temp.left);
        res.add(temp.val);
        Inorder(temp.right);
    }
}