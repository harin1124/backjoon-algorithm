package inflearn_java;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * @title 2. 특정 합을 만드는 부분집합 존재 여부(DFS)
 * @desc N개의 자연수가 주어졌을 때, 이들 중 몇 개를 골라서 부분집합을 만들었을 때,<br>
 * 해당 부분집합의 합이 정수 S가 되는 경우가 존재하는지 확인하는 프로그램을 작성하세요.<br>
 * 단, 모든 원소는 한 번만 사용할 수 있으며, 공집합은 제외합니다.<br>
 * 예를 들어, {2, 4, 5, 6, 8}이 주어지고, S = 14 라면<br>
 * {2, 4, 8} 또는 {6, 8} 같은 조합으로 14를 만들 수 있으므로 "YES"를 출력해야 합니다.
 * @input 첫 번째 줄에 자연수 N(1 <= N <= 10)과 S(1 <= S <= 1000)가 주어집니다.<br>
 * 두 번째 줄에 집합의 원소 N개가 주어진다. 각 원소는 중복되지 않는다.
 * @output 부분집합의 합이 S가 되는 경우가 존재하면 "YES", 그렇지 않으면 "NO"를 출력한다.
 * @studyStartDate 2025-07-15
 * @studyEndDate 2025-07-15
 */

/*
5 14
2 4 5 6 8

5 21
2 4 5 6 18
*/
public class Problem_08_01_practice {
	static String result = "NO";
	static int size;
	static boolean flag = false;
	static int[] arr;
	static int total = 0;
	
	public static void dfs(int level, int sum, int[] arr) {
		if (flag) {
			return;
		}
		
		if(sum > total) {
			return;
		}
		
		if(total == sum) {
			result = "YES";
			flag = true;
			return;
		}
		
		if(level == size) {
			return;
		}
		
		dfs(level + 1, sum + arr[level], arr);
		dfs(level + 1, sum, arr);
	}
	
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		size = scan.nextInt();
		total = scan.nextInt();
		
		arr = new int[size];
		
		for (int i = 0; i < size; i++) {
			arr[i] = scan.nextInt();
		}
		
		dfs(0, 0, arr);
		
		bw.write(result);
		bw.flush();
		
		scan.close();
		bw.close();
	}
}