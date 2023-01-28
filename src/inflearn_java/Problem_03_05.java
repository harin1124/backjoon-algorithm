package inflearn_java;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * @title 5. 연속된 자연수의 합
 * @desc N입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로<br>
 *        정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.
 *        만약 N=15이면
 *        7+8=15
 *        4+5+6=15
 *        1+2+3+4+5=15
 *        와 같이 총 3가지의 경우가 존재한다.
 * @input 첫 번째 줄에 양의 정수 N(7<=N<1000)이 주어집니다.
 * @output 첫 줄에 총 경우수를 출력합니다.
 * @studyStartDate 2023-01-28
 * @studyEndDate 2023-01-28
 */
public class Problem_03_05 {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int num = scan.nextInt();
		int cnt = 0;

		int lt = 1;
		int rt = 1;
		int sum = 0;
		for(rt=1; rt<num; rt++){
			sum += rt;
			if(sum == num){
				cnt++;
			}
			while(sum >= num){
				sum -= lt;
				lt++;
				if(sum == num){
					cnt++;
				}
			}
		}
		bw.write(cnt+"");
		bw.close();
		scan.close();
	}
}