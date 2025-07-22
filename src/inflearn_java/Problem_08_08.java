package inflearn_java;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @title 수열 추측하기
 * @desc 가장 윗줄에 1부터 N까지의 숫자가 한 개씩 적혀 있다.<br>
 * 그리고 둘째 줄부터 차례대로 파스칼의 삼각형처럼 위의 두개를 더한 값이 저장되게 된다.<br>
 * 예를 들어 N이 4 이고 가장 윗 줄에 3 1 2 4 가 있다고 했을 때, 다음과 같은 삼각형이 그려진다.<br>
 * 3 1 2 4<br>
 *  4 3 6<br>
 *   7 9<br>
 *   16<br>
 * N과 가장 밑에 있는 숫자가 주어져 있을 때 가장 윗줄에 있는 숫자를 구하는 프로그램을 작성하시오.<br>
 * 단, 답이 여러가지가 나오는 경우에는 사전순으로 가장 앞에 오는 것을 출력하여야 한다.
 * @input 첫째 줄에 두개의 정수 N(1≤N≤10)과 F가 주어진다.<br>
 * N은 가장 윗줄에 있는 숫자의 개수를 의미하며 F는 가장 밑에 줄에 있는 수로 1,000,000 이하이다.
 * @output 첫째 줄에 삼각형에서 가장 위에 들어갈 N개의 숫자를 빈 칸을 사이에 두고 출력한다.<br>
 * 답이 존재하지 않는 경우는 입력으로 주어지지 않는다.
 * @studyStartDate 2025-07-21
 * @studyEndDate 2025-07-21
 */
public class Problem_08_08 {
	static int n;
	static int f;
	static int[] combiArr;  // b
	static int[] resultArr; // p
	static int[] chkArr;    // ch
	static boolean flag = false;
	static int[][] dy = new int[35][35];
	
	static int combi(int n, int r) {
		if(dy[n][r] > 0) {
			return dy[n][r];
		}
		if(n == r || r == 0) {
			return 1;
		} else {
			return dy[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
		}
	}
	
	static void dfs(int level, int sum) {
		if (flag) {
			return;
		}
		if(level == n) {
			// 순열 완성
			if(sum == f) {
				for(int i : resultArr) {
					System.out.print(i + " ");
				}
				flag = true;
			}
		} else {
			for (int i = 1; i <= n; i++) {
				if(chkArr[i] == 0) {
					chkArr[i] = 1;
					resultArr[level] = i;
					dfs(level + 1, sum + (resultArr[level] * combiArr[level]));
					chkArr[i] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		n = scan.nextInt();
		f = scan.nextInt();
		
		combiArr = new int[n];
		resultArr = new int[n];
		chkArr = new int[n + 1];
		
		for(int i = 0; i < n; i++) {
			combiArr[i] = combi(n - 1, i);
		}
		
		dfs(0, 0);
		
		scan.close();
		bw.flush();
		bw.close();
	}
}
