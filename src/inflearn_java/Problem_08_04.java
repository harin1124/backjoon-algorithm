package inflearn_java;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * @title 중복순열 구하기
 * @desc 1부터 N까지 번호가 적힌 구슬이 있습니다.<br>
 * 이 중 중복을 허락하여 M번을 뽑아 일렬로 나열하는 방법을 모두 출력합니다.
 * @input 첫 번째 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N) 이 주어집니다.
 * @output 첫 번째 줄에 결과를 출력합니다.<br>
 * 출력순서는 사전순으로 오름차순으로 출력합니다.
 * @studyStartDate 2025-07-18
 * @studyEndDate 2025-07-18
 * 3 2
 */
public class Problem_08_04 {
	static int[] arr;
	static int n;
	static int m;
	
	static void dfs(int level) {
		if(level == m) {
			for(int i : arr){
				System.out.print(i + " ");
			}
			System.out.println();
		} else {
			for(int i = 1; i <= n; i++){
				arr[level] = i;
				System.out.println("➡️ 들어감: level = " + level + ", arr[" + level + "] = " + i);
				
				dfs(level + 1);
				System.out.println("⬅️ 돌아옴: level = " + level + ", arr[" + level + "] = " + i);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = scan.nextInt();
		m = scan.nextInt();
		arr = new int[m];
		
		dfs(0);
		
		scan.close();
		bw.close();
	}
}