package questions;

import java.util.Stack;

import util.GetTree;
import util.TreeNode;

/**
 * @author Azreal
 *	Z字形输出二叉树
 */
public class Q32_3 {
	public void Print(TreeNode root){
		if(root == null)
			return;
		Stack<TreeNode> stack1 = new Stack<>();
		Stack<TreeNode> stack2 = new Stack<>();
		int row = 1;
		stack1.push(root);
		while(!stack1.isEmpty() || !stack2.isEmpty()){
			TreeNode curNode = null;
			if((row & 1) == 1){
				curNode = stack1.peek();
				stack1.pop();
				System.out.print(curNode.val + " ");
				if(stack1.isEmpty()){
					System.out.print("\n");
					row++;
				}
				if(curNode.left != null)
					stack2.push(curNode.left);
				if(curNode.right != null)
					stack2.push(curNode.right);
				
			}
			else{
				curNode = stack2.peek();
				stack2.pop();
				System.out.print(curNode.val + " ");
				if(stack2.isEmpty()){
					System.out.print("\n");
					row++;
				}
				if(curNode.right != null)
					stack1.push(curNode.right);
				if(curNode.left != null)
					stack1.push(curNode.left);
				
			}
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = GetTree.getBinaryTreeNode();
		Q32_3 q32_3 = new Q32_3();
		q32_3.Print(root);
	}
}
