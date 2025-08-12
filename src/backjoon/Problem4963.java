package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @title 섬의 개수
 * @desc 정사각형으로 이루어져 있는 섬과 바다 지도가 주어진다.<br>
 * 섬의 개수를 세는 프로그램을 작성하시오.<br>
 * 한 정사각형과 가로, 세로 또는 대각선으로 연결되어 있는 사각형은 걸어갈 수 있는 사각형이다.<br>
 * 두 정사각형이 같은 섬에 있으려면, 한 정사각형에서 다른 정사각형으로 걸어서 갈 수 있는 경로가 있어야 한다.<br>
 * 지도는 바다로 둘러싸여 있으며, 지도 밖으로 나갈 수 없다.
 * @input 입력은 여러 개의 테스트 케이스로 이루어져 있다.<br>
 * 각 테스트 케이스의 첫째 줄에는 지도의 너비 w와 높이 h가 주어진다.<br>
 * w와 h는 50보다 작거나 같은 양의 정수이다.<br>
 * 둘째 줄부터 h개 줄에는 지도가 주어진다. 1은 땅, 0은 바다이다.<br>
 * 입력의 마지막 줄에는 0이 두 개 주어진다.
 * @output 각 테스트 케이스에 대해서, 섬의 개수를 출력한다.
 * @studyStartDate 2025-08-12
 * @studyEndDate 2025-08-12
 */
public class Problem4963 {
	static int w; // 열
	static int h; // 행
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	static int islandCount = 0;
	
	protected static class Point {
		public int x;
		public int y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static void bfs(Point point, int[][] board) {
		Queue<Point> q = new LinkedList<>();
		q.offer(point);
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int i = 0; i < 8; i ++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if(nx >= 0 && nx < h && ny >= 0 && ny < w && board[nx][ny] == 1) {
					board[nx][ny] = 0;
					q.offer(new Point(nx, ny));
				}
			}
		}
	}
	
	static void solution(int[][] board) {
		islandCount = 0;
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				if(board[i][j] == 1) {
					islandCount++;
					board[i][j] = 0;
					bfs(new Point(i, j), board);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		boolean flag = true;
		
		while(flag) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w == 0 && h == 0) {
				flag = false;
			} else {
				int[][] arr = new int[h][w];
				
				for(int i = 0; i < h; i++) {
					st = new StringTokenizer(br.readLine());
					for(int j = 0; j < w; j++) {
						arr[i][j] = Integer.parseInt(st.nextToken());
					}
				}
				
				solution(arr);
				
				bw.write(String.valueOf(islandCount));
				bw.write('\n');
			}
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}
