package algo;

class Solution12 {
    public int maxDepth(TreeNode root) {
    	if(root == null) return 0;
   

        	
    	return 1+Math.max(maxDepth(root.left), maxDepth(root.right)); // 제일 마지막이 0을 반환하면 그 root 는 1을 리턴받는다 왼쪽 오른쪽중에 max값
        
    }
}