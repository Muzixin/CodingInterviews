package questions;

public class Q14 {

	private int maxProductAfterCutting_solution(int length){
		if(length < 2)
			return 0;
		if(length == 2)
			return 1;
		if(length == 3)
			return 2;
		
		int[] products = new int[length+1];
		/*可以这么认为，绳子长度为1,2,3的时候，我们已经做了特殊情况判断；
		 *f数组中存的最优解，从4开始生效。所以，这也就是比较难的地方了。
		*/
		products[1] = 1;
		products[2] = 2;
		products[3] = 3;
		
		
		int max = 0;
		for(int i=4; i<=length; i++){
			max = 0;
			for(int j=1; j<=i/2;j++){
				int product = products[j] * products[i-j];
				if(max < product)
					max = product;
				products[i] = max;
			}
			
		}
		
		max = products[length];
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q14 q = new Q14();
		System.out.println(q.maxProductAfterCutting_solution(8));
	}

}
