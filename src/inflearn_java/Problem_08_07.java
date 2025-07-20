package inflearn_java;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * @title 조합의 경우수(메모이제이션)
 * @desc nCr = n! / ((n - r)! * r!)<br>
 * 하지만 여러분은 이 공식을 쓰지않고 다음 공식을 사용하여 재귀를 이용해 조합수를 구해주는 프로그램을 작성하세요.<br>
 * C(n, r) = C(n - 1, r - 1) + C(n - 1, r)
 * @input 첫째 줄에 자연수 n(3<=n<=33)과 r(0<=r<=n)이 입력됩니다.
 * @output 첫째 줄에 조합수를 출력합니다.
 * @studyStartDate 2025-07-20
 * @studyEndDate 2025-07-20
 */
public class Problem_08_07 {
	static int[][] dy;
	
	static int dfs(int n, int r) {
		if(dy[n][r] > 0) {
			return dy[n][r];
		}
		if(n == r || r == 0) {
			return 1;
		} else {
			int a = dfs(n - 1, r - 1);
			int b = dfs(n - 1, r);
			dy[n][r] = a + b;
			return dy[n][r];
		}
	}
	
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = scan.nextInt();
		int r = scan.nextInt();
		dy = new int[35][35];
		
		int result = dfs(n, r);
		
		bw.write(result + "");
		
		scan.close();
		bw.flush();
		bw.close();
	}
}
