package questions;

/**
 * @author Azreal
 *	栈的压入、弹出序列
 */
public class Q31 {
	
	public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length != popA.length)
            return false;
        boolean flag = false;
        int pushLength = pushA.length;
        int pushIndex = 0;
        int popIndex = 0;
        for(popIndex = 0; popIndex < popA.length && pushIndex < pushLength;){
            if(pushA[pushIndex] != popA[popIndex]){
                pushIndex++;
                continue;
            }
            else{
                if(pushIndex == 0 && popIndex == popA.length-1){
                    flag = true;
                    break;
                }
                if(pushIndex < pushLength){
                	for(int i = pushIndex; i < pushLength-1; i++){
                		pushA[i] = pushA[i + 1];
                	}
                }
                pushLength--;
                pushIndex--;
                popIndex++;
                continue;
            }
        }
        return flag;
    }
	
	public static void main(String[] args) {
		int[] A = {1,2,3,4,5};
		int[] B = {3,5,4,2,1};
		Q31 q31 = new Q31();
		System.out.println(q31.IsPopOrder(A, B));
	}
}
