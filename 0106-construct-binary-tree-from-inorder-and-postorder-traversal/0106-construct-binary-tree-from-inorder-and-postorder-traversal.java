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
    private int index=0;
    private HashMap<Integer,Integer> inMap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         index = postorder.length-1;
        for(int i =0;i<inorder.length;i++)
            inMap.put(inorder[i],i);
        return Build(postorder,0,inorder.length-1);
        
    }
    private TreeNode Build(int [] postorder,int low,int high)
    {
        if(low>high)
            return null;
        TreeNode node = new TreeNode(postorder[index]);
        index--;
        int id = inMap.get(node.val);
        node.right = Build(postorder,id+1,high);
        node.left = Build(postorder,low,id-1);
    
        return node;

    }
    
}