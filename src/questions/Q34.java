package questions;

import java.util.ArrayList;

/**
 * @author Azreal
 *	二叉树中和为某一值的路径
 */
public class Q34 {
	
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
		
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
		
		int currentSum = 0;
		FindPathProcess(root, target, currentSum, list, lists);

		return lists;
		
        
    }
	
	public void FindPathProcess(TreeNode root, int target, int currentSum, 
			ArrayList<Integer> list, ArrayList<ArrayList<Integer>> lists){
		
		if(root == null)
			return;
		
		currentSum += root.val;
		list.add(root.val);
		
		boolean isLeaf = root.left == null && root.right == null;
		if(isLeaf && currentSum == target){
			ArrayList<Integer> templist  = new ArrayList<>();
			for(Integer n : list){
				templist.add(n);
			}
			lists.add(templist);
		}
		if(root.left != null)
			FindPathProcess(root.left, target, currentSum, list, lists);
		if(root.right != null)
			FindPathProcess(root.right, target, currentSum, list, lists);
		
		list.remove(list.size()-1);
		
	}
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(4);
		TreeNode node2 = new TreeNode(7);
		TreeNode node3 = new TreeNode(5);
		TreeNode node4 = new TreeNode(12);
		TreeNode node5 = new TreeNode(10);
		node3.left = node1;
		node3.right = node2;
		node5.left = node3;
		node5.right = node4;
		
		TreeNode root = node5;
		
		TreeNode root2 = null;
		Q34 q34 = new Q34();
		ArrayList<ArrayList<Integer>> lists = q34.FindPath(root2, 0);
		
		for (ArrayList<Integer> arrayList : lists) {
			for (Integer integer : arrayList) {
				System.out.print(integer + " " );
			}
			System.out.print("\n");
		}
	}
}
