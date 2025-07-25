package inflearn_java;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @title 동전교환
 * @desc 다음과 같이 여러 단위의 동전들이 주어져 있을때<br>
 * 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?<br>
 * 각 단위의 동전은 무한정 쓸 수 있다.
 * @input 첫 번째 줄에는 동전의 종류개수 N(1<=N<=12)이 주어진다.<br>
 * 두 번째 줄에는 N개의 동전의 종류가 주어지고,<br>
 * 그 다음줄에 거슬러 줄 금액 M(1<=M<=500)이 주어진다.<br>
 * 각 동전의 종류는 100원을 넘지 않는다.
 * @output 첫 번째 줄에 거슬러 줄 동전의 최소개수를 출력한다.
 * @studyStartDate 2025-07-18
 * @studyEndDate 2025-07-18
 */
public class Problem_08_05 {
	static Integer[] coinArr; // 코인 배열
	static int n;
	static int m;
	static int result = Integer.MAX_VALUE;
	
	static void dfs(int level, int sum) {
		if(sum > m || level >= result) {
			return;
		}
		
		if (sum == m) {
			result = Math.min(result, level);
		} else {
			for (int i : coinArr) {
				dfs(level + 1, sum + i);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = scan.nextInt();
		coinArr = new Integer[n];
		
		for (int i = 0; i < n; i++) {
			coinArr[i] = scan.nextInt();
		}
		
		Arrays.sort(coinArr, Collections.reverseOrder());
		
		m = scan.nextInt();
		
		dfs(0, 0);
		bw.write(result + "");
		
		scan.close();
		bw.close();
	}
}