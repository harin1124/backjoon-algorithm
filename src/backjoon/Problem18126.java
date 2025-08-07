package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @title 너구리 구구
 * @desc 텔레토비 동산에 사는 너구리 구구는 입구, 거실, 주방, 안방, 공부방, 운동실, 음악실, 음식 창고 등 N개의 방을 가지고 있다.<br>
 * 입구를 포함한 모든 방은 1부터 N까지의 번호가 있고, 입구는 1번이다.<br>
 * 구구의 집으로 들어가는 입구는 한 개이며 입구과 모든 방들은 총 N-1개의 길로 서로 오고 갈 수 있다.<br>
 * 구구는 스머프 동산에서 멜론아 아이스크림을 발견했다.<br>
 * 구구는 무더운 여름 햇살을 피해 최대한 입구에서 먼 방에 아이스크림을 숨기려고 한다.<br>
 * 구구가 집 입구에서 멜론아 아이스크림을 숨기려고 하는 방까지 이동하는 거리를 구하여라.
 * @input 첫째 줄에 정수 N(1 ≤ N ≤ 5,000)이 주어진다.<br>
 * 다음 N-1개의 줄에 구구의 집의 모든 길의 정보가 정수 A, B, C(1 ≤ A, B ≤ N, 1 ≤ C ≤ 1,000,000,000)로 주어진다.<br>
 * A번 방과 B번 방 사이를 양방향으로 연결하는 길의 길이가 C임을 의미한다.
 * @output 구구가 집 입구에서 멜론아 아이스크림을 숨기려고 하는 방까지 이동하는 거리를 구하여라.
 * @studyStartDate 2025-08-07
 * @studyEndDate 2025-08-07
 */
public class Problem18126 {
	static int N;
	static List<List<Room>> graph;
	static long RESULT = Long.MIN_VALUE;
	static boolean[] visited;
	
	static class Room {
		int endPoint;
		long distance;
		
		public Room(int endPoint, long distance) {
			this.endPoint = endPoint;
			this.distance = distance;
		}
	}
	
	static void dfs(int level, long totalDistance) {
		visited[level] = true;
		RESULT = Math.max(RESULT, totalDistance);
		
		for(Room next : graph.get(level)) {
			if(!visited[next.endPoint]) {
				dfs(next.endPoint, totalDistance + next.distance);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		graph = new ArrayList<>(N + 1);
		visited = new boolean[N + 1];
		
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		int room;
		int endPoint;
		int distance;
		
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			room = Integer.parseInt(st.nextToken());
			endPoint = Integer.parseInt(st.nextToken());
			distance = Integer.parseInt(st.nextToken());
			graph.get(room).add(new Room(endPoint, distance));
			graph.get(endPoint).add(new Room(room, distance));
		}
		
		dfs(1, 0);
		
		bw.write(String.valueOf(RESULT));
		
		br.close();
		bw.flush();
		bw.close();
	}
}
