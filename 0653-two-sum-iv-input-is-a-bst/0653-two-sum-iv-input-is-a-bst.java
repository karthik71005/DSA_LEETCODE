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
    private ArrayList<Integer> temp = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        traversal(root);
        int i =0;
        int j = temp.size()-1;
        while(i<j)
        {
            int sum =temp.get(i)+temp.get(j);
            if(sum==k)
                return true;
            if(sum<k)
                i++;
            else{
                j--;
            }
        }
        return false;

    }
    private void traversal(TreeNode root)
    {
        if (root == null) 
          return;
        traversal(root.left);
        temp.add(root.val);
        traversal(root.right);
        
        
    }
}