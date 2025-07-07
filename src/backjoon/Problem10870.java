package backjoon;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * @title 피보나치 수 5
 * @desc 피보나치 수는 0과 1로 시작한다. 0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1이다.<br>
 * 그 다음 2번째 부터는 바로 앞 두 피보나치 수의 합이 된다.<br>
 * 이를 식으로 써보면 Fn = Fn-1 + Fn-2 (n ≥ 2)가 된다.<br>
 * n=17일때 까지 피보나치 수를 써보면 다음과 같다.<br>
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597<br>
 * n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.
 * @input 첫째 줄에 n이 주어진다. n은 20보다 작거나 같은 자연수 또는 0이다.
 * @output 첫째 줄에 n번째 피보나치 수를 출력한다.
 * @studyStartDate 2025-07-07
 * @studyEndDate 2025-07-07
 */
public class Problem10870 {
	public static int fibo(int n) {
		if (n <= 1) {
			return n;
		} else {
			return fibo(n - 2) + fibo(n - 1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int number = scan.nextInt();
		bw.write(String.valueOf(fibo(number)));
		scan.close();
		bw.close();
	}
}