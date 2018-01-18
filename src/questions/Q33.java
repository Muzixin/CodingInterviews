package questions;


/**
 * @author Azreal
 * 二叉搜索树的后序遍历序列
 */
public class Q33 {
	public boolean VertifySquenceofBST(int[] sequence){
		if(sequence == null || sequence.length < 2)
			return false;
		
		return VertifySequenceofBSTProcess(sequence, 0, sequence.length-1);
		
	}
	
	private boolean VertifySequenceofBSTProcess(int[] sequence, int startIndex, int endIndex){
		
		int length = endIndex - startIndex + 1;
		
		int root = sequence[length - 1];
		
		int i = 0;
		for(i = 0; i < endIndex; i++){
			if(sequence[i] > root)
				break;
		}
		int j = 0;
		for(j = i; j < endIndex; j++){
			if(sequence[j] < root)
				return false;
		}
		
		boolean left = true;
		if(i > 0){
			left = VertifySequenceofBSTProcess(sequence, 0, i-1);
		}
		
		boolean right = true;
		if(i < length - 1){
			right = VertifySequenceofBSTProcess(sequence, i, endIndex-1);
		}
		return (left && right);
	}
	
	public static void main(String[] args) {
		int[] arr = null;
			//{7,4,6,5};
			//{5,7,6,9,11,10,8};
		Q33 q33 = new Q33();
		System.out.println(q33.VertifySquenceofBST(arr));
	}
}
