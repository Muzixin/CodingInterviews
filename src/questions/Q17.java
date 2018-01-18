package questions;

/**
 * @author Azreal
 *	打印从1到最大的N位数
 */
public class Q17 {
	private void print1ToMaxofNDigits(int n){
		if(n <= 0)
			return;
		int[] numbers = new int[n];
		for(int i=0; i<10; i++){
			numbers[0] = i;
			print1ToMaxofNdigitsRecursively(numbers, n, 0);
		}
	}
	
	private void print1ToMaxofNdigitsRecursively(int[] numbers, int n, int index){
		if(index == n-1){
			PrintNumbers(numbers);
			return;
		}
		
		for(int i=0; i<10; i++){
			numbers[index+1] = i;
			print1ToMaxofNdigitsRecursively(numbers, n, index+1);
		}
	}
	
	private void PrintNumbers(int[] numbers){
		boolean flag = true;
		int nLength = numbers.length;
		
		for(int i=0; i<nLength; i++){
			if(flag && numbers[i] != 0)
				flag = false;
			if(!flag)
				System.out.print(numbers[i]);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Q17 q = new Q17();
		q.print1ToMaxofNDigits(3);
	}

}
