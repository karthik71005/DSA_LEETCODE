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
// class Solution {
//     private ArrayList<Integer> temp = new ArrayList<>();
//     public boolean findTarget(TreeNode root, int k) {
//         traversal(root);
//         int i =0;
//         int j = temp.size()-1;
//         while(i<j)
//         {
//             int sum =temp.get(i)+temp.get(j);
//             if(sum==k)
//                 return true;
//             if(sum<k)
//                 i++;
//             else{
//                 j--;
//             }
//         }
//         return false;

//     }
//     private void traversal(TreeNode root)
//     {
//         if (root == null) 
//           return;
//         traversal(root.left);
//         temp.add(root.val);
//         traversal(root.right);
        
        
//     }
// }
import java.util.Stack;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;

        // Stacks to simulate forward and backward iterators
        Stack<TreeNode> ascStack = new Stack<>();
        Stack<TreeNode> descStack = new Stack<>();

        // Initialize both iterators
        pushLeft(root, ascStack);   // Starts at the smallest element
        pushRight(root, descStack); // Starts at the largest element

        TreeNode left = getNext(ascStack);
        TreeNode right = getPrev(descStack);

        // Standard 2-pointer approach using the iterators
        while (left != null && right != null && left != right) {
            int sum = left.val + right.val;

            if (sum == k) {
                return true;
            } else if (sum < k) {
                left = getNext(ascStack); // Move forward to a larger element
            } else {
                right = getPrev(descStack); // Move backward to a smaller element
            }
        }

        return false;
    }

    // Push all left children to get the next smallest elements (Inorder traversal)
    private void pushLeft(TreeNode node, Stack<TreeNode> stack) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    // Push all right children to get the next largest elements (Reverse Inorder traversal)
    private void pushRight(TreeNode node, Stack<TreeNode> stack) {
        while (node != null) {
            stack.push(node);
            node = node.right;
        }
    }

    // Retrieve the next smallest node
    private TreeNode getNext(Stack<TreeNode> stack) {
        if (stack.isEmpty()) return null;
        TreeNode node = stack.pop();
        pushLeft(node.right, stack);
        return node;
    }

    // Retrieve the next largest node
    private TreeNode getPrev(Stack<TreeNode> stack) {
        if (stack.isEmpty()) return null;
        TreeNode node = stack.pop();
        pushRight(node.left, stack);
        return node;
    }
}