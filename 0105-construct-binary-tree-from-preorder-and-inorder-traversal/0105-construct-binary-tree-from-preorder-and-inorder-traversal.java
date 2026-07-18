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
    private int index =0;
    private HashMap<Integer,Integer> inMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i =0;i<inorder.length;i++)
            inMap.put(inorder[i],i);
        return Build(preorder,0,inorder.length-1);
        
    }
    private TreeNode Build(int [] preorder,int low,int high)
    {
        if(low>high)
            return null;
        TreeNode node = new TreeNode(preorder[index]);
        index++;
        int id = inMap.get(node.val);
        node.left = Build(preorder,low,id-1);
        node.right = Build(preorder,id+1,high);
        return node;

    }
}