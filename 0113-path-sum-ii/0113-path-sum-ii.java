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
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        int sum =0;
        List<Integer> diary = new ArrayList<>();
        PathSum(root,sum,targetSum,diary);
        return res;
               
    }
    private void PathSum(TreeNode root,int sum ,int k,List<Integer>diary){
        if(root==null)
            return;
        List<Integer> myDiary = new ArrayList<>(diary);
        sum+=root.val;
        myDiary.add(root.val);
        if(root.left == null&&root.right==null)
        {
            if(sum == k)
                res.add(myDiary);
            return;
        }
        PathSum(root.left,sum,k,myDiary);
        PathSum(root.right,sum,k,myDiary);
        myDiary.remove(myDiary.size() - 1);
        
    }
}