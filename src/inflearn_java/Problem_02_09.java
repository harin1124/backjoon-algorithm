package inflearn_java;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * @title 9. 격자판 최대합
 * @desc 5*5 격자판에 아래롸 같이 숫자가 적혀있습니다.<br>
 *       N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력합니다.
 * @input 첫 줄에 자연수 N이 주어진다.(2<=N<=50)<br>
 *        두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.
 * @output 최대합을 출력합니다.
 * @studyStartDate 2023-01-20
 * @studyEndDate 2023-01-20
 */
public class Problem_02_09 {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int size = Integer.parseInt(scan.nextLine());
		int[][] panel = new int[size][size];

		int j=0;
		for(int i=0; i<size; i++){
			for(j=0; j<size; j++){
				panel[i][j] = scan.nextInt();
			}
		}
		// 최고값 찾기
		int max = 0;
		// 1. 가로값 중 최고값 찾기
		int rowMaxTemp = 0;
		// 2. 세로값 중 최고값 찾기
		int colMaxTemp = 0;
		// 3. 왼쪽에서 오른쪽으로 가는 대각선 값
		int leftSlashTemp = 0;
		// 4, 오른쪽에서 왼쪽으로 가는 대각선 값
		int rightSlashTemp = 0;
		for(int i=0; i<size; i++){
			for(j=0; j<size; j++){
				rowMaxTemp += panel[i][j];
				colMaxTemp += panel[j][i];
			}
			if(max < rowMaxTemp){
				max = rowMaxTemp;
			}
			if(max < colMaxTemp){
				max = colMaxTemp;
			}
			leftSlashTemp += panel[i][i];
			rightSlashTemp += panel[i][size-1-i];
			rowMaxTemp = 0;
			colMaxTemp = 0;
		}

		if(leftSlashTemp < rightSlashTemp){
			leftSlashTemp = rightSlashTemp;
		}
		if(max < leftSlashTemp){
			max = leftSlashTemp;
		}

		bw.write(max+"");
		bw.close();
		scan.close();
	}
}