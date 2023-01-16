package inflearn_java;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * @title 1. 큰 수 출력하기
 * @desc N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.<br>
 *       (첫 번째 수는 무조건 출력한다)
 * @input 첫 줄에 자연수 N(1<=N<=100)이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.
 * @output 자신의 바로 앞 수보다 큰 수만 한 줄로 출력한다.
 * @studyStartDate 2023-01-16
 * @studyEndDate 2023-01-16
 */
public class Problem_02_01 {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int size = scan.nextInt();
		int num;
		int prev = 0;
		for(int i=0; i<size; i++){
			num = scan.nextInt();
			if(prev < num){
				bw.write(num+" ");
			}
			prev = num;
		}
		bw.close();
		scan.close();
	}
}