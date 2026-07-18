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



 //one method you can do is do inoreder rtrvaersla and then get k-1 th element from the lis here the time and sppace complexity is o(n)
class Solution {
    public int kthSmallest(TreeNode root, int k) {

        Stack <TreeNode> stck = new Stack<>();
        TreeNode curr = root;
        while(curr!=null || !stck.isEmpty())
        {
            
             while(curr!=null)
             {
                stck.push(curr);
                curr = curr.left;
             }
              curr = stck.pop();
             k--;
             if(k==0)
                return curr.val;
            curr = curr.right;
        }
    return -1;    
    }
    

}