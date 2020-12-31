package before_algo;

class Solution12 {
    public int maxDepth(TreeNode root) {
    	if(root == null) return 0;
   

        	
    	return 1+Math.max(maxDepth(root.left), maxDepth(root.right)); // ���� �������� 0�� ��ȯ�ϸ� �� root �� 1�� ���Ϲ޴´� ���� �������߿� max��
        
    }
}