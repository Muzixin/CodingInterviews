package util;

public class GetTree {
	public static TreeNode getBinaryTreeNode() {
		TreeNode node1 = new TreeNode(8);
		TreeNode node2 = new TreeNode(6);
		TreeNode node3 = new TreeNode(10);
		TreeNode node4 = new TreeNode(5);
		TreeNode node5 = new TreeNode(7);
		TreeNode node6 = new TreeNode(9);
		TreeNode node7 = new TreeNode(11);
		
		
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		node1.left = node2;
		node1.right = node3;
		
		TreeNode root = null;
		root = node1;
		
		return root;
	}
}
