package questions;

import java.util.LinkedList;
import java.util.Queue;

import util.GetTree;
import util.TreeNode;


/**
 * @author Azreal 按层遍历二叉树，不换行输出
 */

public class Q32_1 {
	
	
	private void PrintToptoBottom(TreeNode root){
		if(root == null)
			return;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()){
			TreeNode temp = queue.remove();
			System.out.print(temp.val + " ");
			if(temp.left != null)
				queue.offer(temp.left);
			if(temp.right != null)
				queue.offer(temp.right);
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = GetTree.getBinaryTreeNode();
		Q32_1 q32_1 = new Q32_1();
		q32_1.PrintToptoBottom(root);
	}
}
