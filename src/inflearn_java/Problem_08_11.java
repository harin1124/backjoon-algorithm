package inflearn_java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	public int x;
	public int y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

/**
 * @title 미로의 최단거리 통로(BFS)
 * @desc 7*7 격자판 미로를 탈출하는 최단경로의 길이를 출력하는 프로그램을 작성하세요.<br>
 * 경로의 길이는 출발점에서 도착점까지 가는데 이동한 횟수를 의미한다.<br>
 * 출발점은 격자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7)좌표이다.<br>
 * 격자판의 1은 벽이고, 0은 도로이다.<br>
 * 격자판의 움직임은 상하좌우로만 움직인다.
 * 미로가 다음과 같다면 위와 같은 경로가 최단 경로의 길이는 12이다.
 * 0 0 0 0 0 0 0<br>
 * 0 1 1 1 1 1 0<br>
 * 0 0 0 1 0 0 0<br>
 * 1 1 0 1 0 1 1<br>
 * 1 1 0 0 0 0 1<br>
 * 1 1 0 1 1 0 0<br>
 * 1 0 0 0 0 0 0
 * @input 첫 번째 줄부터 7*7 격자의 정보가 주어집니다.
 * @output 첫 번째 줄에 최단으로 움직인 칸의 수를 출력한다. 도착할 수 없으면 -1를 출력한다.
 * @studyStartDate 2025-07-24
 * @studyEndDate 2025-07-24
 */
public class Problem_08_11 {
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] arr = new int[8][8];
	static int[][] dis = new int[8][8];
	static int count = Integer.MAX_VALUE;
	
	static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(x, y));
		// 출발점 체크 위함
		arr[x][y] = 1;
		
		while(!q.isEmpty()) {
			Point temp = q.poll();
			for(int i = 0; i < 4; i++) {
				int nx = temp.x + dx[i];
				int ny = temp.y + dy[i];
				if(nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && arr[nx][ny] == 0) {
					arr[nx][ny] = 1;
					q.offer(new Point(nx, ny));
					dis[nx][ny] = dis[temp.x][temp.y] + 1;
				}
			}
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		
		for(int i = 1; i <= 7; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= 7; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		bfs(1, 1);
		
		bw.write(((dis[7][7]) == 0 ? -1 : dis[7][7]) + "");
		
		br.close();
		bw.flush();
		bw.close();
	}
}
