class Solution {    // O(N^2) O(N^2)
    int finalres=0;

    public static int maxDepth(TreeNode root) {
        if(root==null)
        return 0;
        return Math.max(maxDepth(root.left)+1,maxDepth(root.right)+1);
    }


    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)
            return 0;
        diameterOfBinaryTree(root.left);
        
        diameterOfBinaryTree(root.right);
        TreeNode temp=root;
        int left=maxDepth(temp.left);
        int right=maxDepth(temp.right);
        int res=left+right;
        finalres=Math.max(res,finalres);
        return finalres;

    }
}



class Solution {
    public int longestPath = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        longestPath(root);
        return longestPath;
    }
    
    public int longestPath(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int lheight = longestPath(root.left);
        int rheight = longestPath(root.right);
        
        longestPath = Math.max(longestPath, lheight + rheight);
        
        return Math.max(lheight, rheight) + 1;
    }
}
