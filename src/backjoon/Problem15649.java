package backjoon;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * @title N과 M (1)
 * @desc 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.<br>
 * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 * @input 첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
 * @output 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.<br>
 * 수열은 사전 순으로 증가하는 순서로 출력해야 한다.
 * @studyStartDate 2025-07-19
 * @studyEndDate 2025-07-19
 */
public class Problem15649 {
	static int n;
	static int m;
	static int[] numberArr;
	static int[] outputArr;
	static int[] flagArr;
	static BufferedWriter bw;
	
	static void dfs (int level) throws Exception {
		if (level == m) {
			for (int i : outputArr) {
				bw.write(i + " ");
			}
			bw.write("\n");
		} else {
			for (int i = 0; i < n; i++) {
				if (flagArr[i] == 0) {
					outputArr[level] = numberArr[i];
					flagArr[i] = 1;
					dfs(level + 1);
					flagArr[i] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = scan.nextInt();
		m = scan.nextInt();
		
		numberArr = new int[n];
		outputArr = new int[m];
		flagArr = new int[n];
		
		for(int i = 0; i < n; i++) {
			numberArr[i] = i + 1;
		}
		
		dfs(0);
		
		scan.close();
		bw.flush();
		bw.close();
		
	}
}