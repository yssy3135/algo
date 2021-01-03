package before_algo;

import javax.swing.tree.TreeNode;

class Solution12 {
    public int maxDepth(TreeNode root) {
    	if(root == null) return 0;
   

        	
    	return 1+Math.max(maxDepth(root.left), maxDepth(root.right)); // 
        
    }
}