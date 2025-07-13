package inflearn_java;

import java.util.Scanner;

/**
 * @title 경로 탐색(인접행렬)(DFS)
 * @desc 방향그래프가 주어지면 1번 정점에서 N번 정점으로 가는<br>
 * 모든 경로의 가지 수를 출력하는 프로그램을 작성하세요.<br>
 * 아래 그래프에서 1번 정점에서 5번 정점으로 가는 가지 수는 총 6가지입니다.
 * @input 첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M가 주어진다.<br>
 * 그 다음부터 M줄에 걸쳐 연결정보가 주어진다.
 * @output 총 가지수를 출력한다.
 * @studyStartDate 2025-07-13
 * @studyEndDate 2025-07-13
 */
public class Problem_07_12 {
	static int n = 0; // 정점 수
	static int m = 0; // 간선 수
	static int answer = 0;
	static int[][] graph; // 인접 행렬
	static int[] chkList;
	
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		
		// 1번 인덱스부터 처리하므로 +1처리
		graph = new int[n + 1][n + 1];
		chkList = new int[n + 1];
		
		for (int i = 0; i < m; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			graph[a][b] = 1;
		}
		
		scan.close();
		
		// 무조건 1부터 출발하므로, 기본 체크 처리
		chkList[1] = 1;
		
		dfs(1);
		
		System.out.println(answer);
	}
	
	public static void dfs(int v) {
		// v와 n이 동일하다는 것은 종착지에 도착했으므로, 가짓수를 한 개 더 발견한 것이다.
		if (v == n) {
			answer++;
		} else {
			// 갈 수 있는 간선에 대한 진행
			for (int i = 1; i <= n; i++) {
				// 방문한 적이 없으며, 갈 수 있는 간선이 존재하는 경우에
				if (chkList[i] == 0 && graph[v][i] == 1) {
					chkList[i] = 1;
					dfs(i);
					chkList[i] = 0;
				}
			}
		}
	}
}