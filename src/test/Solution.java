package test;

public class Solution {
	//稳定的实现方法
	public void reOrderArray(int [] array) {
        int i = 0, j = array.length - 1;
        int[] temp = new int[array.length];
        for(int p1 = 0, p2 = array.length -1; p1 < array.length && p2 >=0; p1++,p2--){
            if((array[p1] & 1 ) == 1){
                temp[i++] = array[p1];
            }
            if((array[p2] & 1) == 0){
                temp[j--] = array[p2];
            }
        }
        for(int n = 0; n < array.length; n++){
            array[n] = temp[n];
        }
    }
	
	/*不稳定的实现方法
	 * public void reOrderArray(int [] array) {
        if(array == null || array.length < 2)
            return;
        int p1 = 0;
        int p2 = array.length - 1;
        
        while(p1 < p2){
            while(p1 < p2 && isEvent(array[p1])){
                p1 ++;
            }
            while(p1 <p2 && !isEvent(array[p2])){
                p2 --;
            }
            if(p1 < p2)
                swap(array, p1, p2);
        }
    }
    
    //奇数返回true
    private boolean isEvent(int n){
        boolean flag = false;
        if((n & 1) == 1)
            flag = true;
        return flag;
    }
    
    private void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }*/
    
    public static void main(String[] args) {
		int[] array = {4,6,5,7,9,1,2,3};
		Solution solution = new Solution();
		solution.reOrderArray(array);
		for (int i : array) {
			System.out.println(i);
		}
	}
}
