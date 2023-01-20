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
public class Problem_02_09_02 {
	public static void main(String[] args) throws Exception {
		// 강의를 보고 참고하여, 코드를 효율적으로 분리한 풀이법
		Scanner scan = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int size = Integer.parseInt(scan.nextLine());
		int[][] panel = new int[size][size];

		int i=0;
		int j=0;
		for(i=0; i<size; i++){
			for(j=0; j<size; j++){
				panel[i][j] = scan.nextInt();
			}
		}

		int max = 0;
		int temp1 = 0;
		int temp2 = 0;
		for(i=0; i<size; i++){
			temp1 = 0;
			temp2 = 0;
			for(j=0; j<size; j++){
				temp1 += panel[i][j];
				temp2 += panel[j][i];
			}
			if(max < temp1){
				max = temp1;
			}
			if(max < temp2){
				max = temp2;
			}
		}
		temp1 = 0;
		temp2 = 0;
		for(i=0; i<size; i++){
			temp1 += panel[i][i];
			temp2 += panel[i][size-1-i];
		}
		temp1 = temp1 < temp2 ? temp2 : temp1;
		max = max < temp1 ? temp1 : max;

		bw.write(max+"");
		bw.close();
		scan.close();
	}
}