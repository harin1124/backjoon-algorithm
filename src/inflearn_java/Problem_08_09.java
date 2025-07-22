package inflearn_java;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * @title 조합 구하기
 * @desc 1부터 N까지 번호가 적힌 구슬이 있습니다.<br>
 * 이 중 M개를 뽑는 방법의 수를 출력하는 프로그램을 작성하세요.
 * @input 첫 번째 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N) 이 주어집니다.
 * @output 첫 번째 줄에 결과를 출력합니다.<br>
 * 출력순서는 사전순으로 오름차순으로 출력합니다.
 * @studyStartDate 2025-07-22
 * @studyEndDate 2025-07-22
 */
public class Problem_08_09 {
	static int n;
	static int r;
	static int[] arr;
	static BufferedWriter bw;
	
	static void dfs(int level, int start) throws Exception {
		if(level == r) {
			for(int i : arr) {
				bw.write(i + " ");
			}
			bw.write("\n");
		} else {
			for(int i = start + 1; i <= n; i++) {
				arr[level] = i;
				dfs(level + 1, i);
			}
		}
	
	}
	
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = scan.nextInt();
		r = scan.nextInt();
		arr = new int[r];
		
		dfs(0, 0);
		
		scan.close();
		bw.flush();
		bw.close();
	}
}
