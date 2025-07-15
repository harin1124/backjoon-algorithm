package inflearn_java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @title 그래프 최단거리(BFS)
 * @desc 다음 그래프에서 1번 정점에서 각 정점으로 가는 최소 이동 간선 수를 출력하세요.
 * @input 첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M가 주어진다.<br>
 * 그 다음부터 M줄에 걸쳐 연결정보가 주어진다.
 * @output 1번 정점에서 각 정점으로 가는 최소 간선 수를 2번 정점부터 차례대로 출력하세요.
 * @studyStartDate 2025-07-14
 * @studyEndDate 2025-07-14
 */
public class Problem_07_14 {
	static int n = 0; // 정점 수
	static int m = 0; // 간선 수
	static ArrayList<ArrayList<Integer>> graph; // 인접 행렬
	static int[] chkList;
	static int[] dis;
	
	public static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		
		chkList[v] = 0;
		dis[v] = 0;
		
		q.offer(v);
		
		while(!q.isEmpty()) {
			// 현재 지점
			int currentVertex = q.poll();
			for (int nv : graph.get(currentVertex)) {
				if(chkList[nv] == 0) {
					chkList[nv] = 1;
					q.offer(nv);
					dis[nv] = dis[currentVertex] + 1;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		
		// 1번 인덱스부터 처리하므로 +1처리
		graph = new ArrayList<>();
		chkList = new int[n + 1];
		dis = new int[n + 1];
		
		// n만큼 리스트에 add 처리
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < m; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			graph.get(a).add(b);
		}
		
		bfs(1);
		
		for (int i = 2; i <= n; i++) {
			System.out.printf("%s : %s\r\n", i, dis[i]);
		}
		
		scan.close();
	}
}