package inflearn_java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @title 다익스트라 알고리즘
 * @desc 아래의 가중치 방향그래프에서 1번 정점에서 모든 정점으로의 최소 거리비용을 출력하는 프로그램을 작성하세요.<br>
 * (경로가 없으면 Impossible를 출력한다)
 * @input 첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M가 주어진다.<br>
 * 그 다음부터 M줄에 걸쳐 연결정보와 거리비용이 주어진다.
 * @output 1번 정점에서 각 정점으로 가는 최소비용을 2번 정점부터 차례대로 출력하세요.
 * @example
 * 6 9
 * 1 2 12
 * 1 3 4
 * 2 1 2
 * 2 3 5
 * 2 5 5
 * 3 4 5
 * 4 2 2
 * 4 5 5
 * 6 4 5
 * @studyStartDate 2025-10-20
 * @studyEndDate 2025-10-20
 */
public class Problem_09_05 {
	static int vertexCount;
	static int edgeCount;
	static ArrayList<ArrayList<Edge>> graph;
	static int[] dis;
	
	static class Edge implements Comparable<Edge> {
		/** 정점 */
		public int vex;
		/** 간선의 가중치 */
		public int cost;
		
		Edge(int vex, int cost) {
			this.vex = vex;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge ob) {
			return this.cost - ob.cost;
		}
	}
	
	static void solution(int v) {
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		pQ.offer(new Edge(v, 0));
		dis[v] = 0;
		
		while(!pQ.isEmpty()) {
			Edge tmp = pQ.poll();
			int now = tmp.vex;
			int nowCost = tmp.cost;
			
			if(nowCost > dis[now]) {
				continue;
			}
			
			for(Edge ob : graph.get(now)) {
				if(dis[ob.vex] > nowCost + ob.cost) {
					dis[ob.vex] = nowCost + ob.cost;
					pQ.offer(new Edge(ob.vex, nowCost + ob.cost));
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		vertexCount = Integer.parseInt(st.nextToken());
		edgeCount = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>();
		
		for(int i = 0; i <= vertexCount; i++) {
			graph.add(new ArrayList<>());
		}
		
		dis = new int[vertexCount + 1];
		
		Arrays.fill(dis, Integer.MAX_VALUE);
		
		for(int i = 0; i < edgeCount; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph.get(start).add(new Edge(end, cost));
		}
		
		solution(1);
		
		for(int i = 2; i <= vertexCount; i++) {
			bw.write(String.valueOf(i));
			bw.write(" : ");
			if(dis[i] != Integer.MAX_VALUE) {
				bw.write(String.valueOf(dis[i]));
			} else {
				bw.write("impossible");
			}
			bw.write("\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}
