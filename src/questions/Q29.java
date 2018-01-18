package questions;

import java.util.ArrayList;

/**
 * @author Azreal
 *  顺时针打印矩阵
 */
public class Q29 {
	public ArrayList<Integer> printMatrix(int[][] matrix) {
		if (matrix == null)
			return null;
		int rows = matrix.length;
		int cols = matrix[0].length;
		int start = 0;
		ArrayList<Integer> list = new ArrayList<>();

		while (cols > 2 * start && rows > 2 * start) {
			list = getElements(list, matrix, rows, cols, start);
			start++;
		}
		return list;
	}

	private ArrayList<Integer> getElements(ArrayList<Integer> list, int[][] matrix, int rows, int cols, int start) {
		int endX = cols - 1 - start;
		int endY = rows - 1 - start;
		for (int i = start; i <= endX; i++) {
			list.add(matrix[start][i]);
		}
		if (start < endY) {
			for (int i = start + 1; i <= endY; i++) {
				list.add(matrix[i][endX]);
			}
		}
		if (start < endX && start < endY) {
			for (int i = endX - 1; i >= start; i--) {
				list.add(matrix[endY][i]);
			}
		}
		if (start < endX && start < endY - 1) {
			for (int i = endY - 1; i >= start + 1; i--) {
				list.add(matrix[i][start]);
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		Q29 q29 = new Q29();
		ArrayList<Integer> list = q29.printMatrix(matrix);
		for (Integer integer : list) {
			System.out.println(integer);
		}
	}
}
