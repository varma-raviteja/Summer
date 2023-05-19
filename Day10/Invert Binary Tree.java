class Solution {  // O(N) O(N)
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
        return null;
        invertTree(root.left);
        invertTree(root.right);
        if(root.left!=null && root.right!=null)
        {
            TreeNode temp=root.left;
            root.left=root.right;
            root.right=temp;
        }else if(root.left!=null && root.right==null)
        {
            root.right=root.left;
            root.left=null;
        }else if(root.right!=null && root.left==null)
        {
            root.left=root.right;
            root.right=null;
        }   
        return root;
    }
}


class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }
}
