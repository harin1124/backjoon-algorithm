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
 * @studyEndDate 2023-01-
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
		int rowMax = 0;
		int rowMaxTemp = 0;
		// 2. 세로값 중 최고값 찾기
		int colMax = 0;
		int colMaxTemp = 0;
		for(int i=0; i<size; i++){
			// 1.
			for(j=0; j<size; j++){
				rowMaxTemp += panel[i][j];
			}
			if(rowMax < rowMaxTemp){
				rowMax = rowMaxTemp;
			}
			rowMaxTemp = 0;

			// 2,
			System.out.printf("i[%d][%d]", i, j);
			System.out.println();


		}


		System.out.println("가로값 중 최고값 : "+rowMax);


		System.out.println(panel[1][2]);

		bw.close();
		scan.close();
	}
}