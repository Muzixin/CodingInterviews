package questions;

class TreeNode {

	int val = 0;
	TreeNode left = null;
	TreeNode right = null;

	public TreeNode(int val) {
		this.val = val;

	}
}

/**
 * @author Azreal
 *	
 *	判斷一棵樹是否是对称的二叉树
 */
public class Q28 {
	public boolean isSymmetrical(TreeNode head){
		return isSymmetrical(head,head);
	}
	
	private boolean isSymmetrical(TreeNode root1, TreeNode root2){
		if(root1 == null && root2 == null)
			return true;
		if(root1 == null || root2 == null)
			return false;
		if(root1.val != root2.val)
			return false;
		return isSymmetrical(root1.left, root2.right) && 
			    isSymmetrical(root1.right, root2.left);
	}
}
