package inflearn_java;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * @title 3. 최대 매출
 * @desc 현수의 아빠는 제과점을 운영합니다.<br>
 *        현수 아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 최대 매출액이 얼마인지 구하라고 했습니다.<br>
 *        만약 N=10이고 10일 간의 매출기록이 아래와 같습니다. 이때 K=3이면<br>
 *        12 1511 20 2510 20 19 13 15<br>
 *        연속된 3일간의 최대 매출액은 11+20+25=56만원입니다.<br>
 *        여러분이 현수를 도와주세요.
 * @input 첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.<br>
 *         두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.
 * @output 첫 줄에 최대 매출액을 출력합니다.
 * @studyStartDate 2023-01-26
 * @studyEndDate 2023-01-26
 */
public class Problem_03_03 {
	public static void main(String[] args) throws Exception {
		// 정답은 맞는 것 같으나, 시간 초과
		Scanner scan = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] days = new int[scan.nextInt()];
		int range = scan.nextInt();

		int i=0;
		for(i=0; i<days.length; i++){
			days[i] = scan.nextInt();
		}

		// 최대 매출 찾기
		int max = 0;
		int temp = 0;
		int r;
		int j;
		for(i=0; i<days.length; i++){
			temp = 0;
			r = i+range-1;
			if(r < days.length){
				System.out.printf("days[%d] = %d", i, days[i]);
				System.out.println();
				for(j=i; j<=r; j++){
					System.out.println("\tdays["+j+"] = "+days[j]);
					temp += days[j];
				}
				if(max < temp){
					max = temp;
				}
			}
		}
		bw.write(max+"");

		bw.close();
		scan.close();
	}
}