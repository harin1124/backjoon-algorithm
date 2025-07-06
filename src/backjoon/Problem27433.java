package backjoon;

import java.io.*;
import java.util.Scanner;

/**
 * @title 팩토리얼 2
 * @desc 0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.
 * @input 첫째 줄에 정수 N(0 ≤ N ≤ 20)이 주어진다.
 * @output 첫째 줄에 N!을 출력한다.
 * @studyStartDate 2025-07-06
 * @studyEndDate 2025-07-06
 */
public class Problem27433 {
	public static long factorial(int n) {
		if(n <= 1){
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int number = scan.nextInt();
		long result = factorial(number);
		bw.write(String.valueOf(result));
		scan.close();
		bw.close();
	}
}
