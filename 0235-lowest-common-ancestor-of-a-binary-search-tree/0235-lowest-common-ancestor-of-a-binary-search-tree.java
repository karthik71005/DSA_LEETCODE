// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode(int x) { val = x; }
//  * }
//  */

// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         TreeNode temp = root;
//         while(temp!=null)
//         {
//             if(p.val<temp.val && q.val<temp.val)
//             {
//                 temp =temp.left;
//             }
//             else if(p.val>temp.val && q.val>temp.val)
//             {
//                 temp =temp.right;
//             }
//             else {
//                 return temp;
//             }
//         }
//       return null;
  
        
//     }
// }
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
 
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
 
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
    
        return root;
    }
}