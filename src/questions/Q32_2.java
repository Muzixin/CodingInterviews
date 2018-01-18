package questions;

import java.util.LinkedList;
import java.util.Queue;

import util.GetTree;
import util.TreeNode;

/**
 * @author Azreal
 * 
 * 按层遍历二叉树，换行输出
 */
public class Q32_2 {
	private void PrintToptoBottom(TreeNode root){
		if(root == null)
			return;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int nextLevel = 0;
		int toBePrint = 1;
		while(!queue.isEmpty()){
			TreeNode temp = queue.remove();
			toBePrint--;
			System.out.print(temp.val + " ");
			if(temp.left != null){
				queue.offer(temp.left);
				++nextLevel;
			}
			if(temp.right != null){
				queue.offer(temp.right);
				++nextLevel;
			}
			if(toBePrint == 0){
				System.out.print("\n");
				toBePrint = nextLevel;
				nextLevel = 0;
			}
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = GetTree.getBinaryTreeNode();
		Q32_2 q32_2 = new Q32_2();
		q32_2.PrintToptoBottom(root);
	}
}
