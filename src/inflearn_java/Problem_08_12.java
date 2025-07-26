package inflearn_java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

/**
 * @title 토마토(BFS 활용)
 * @desc 현수의 토마토 농장에서는 토마토를 보관하는 큰 창고를 가지고 있다.<br>
 * 토마토는 아래의 그림과 같이 격자 모양 상자의 칸에 하나씩 넣어서 창고에 보관한다.<br>
 * 창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다.<br>
 * 보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다.<br>
 * 하나의 토마토의 인접한 곳은 왼쪽, 오른쪽, 앞, 뒤 네 방향에 있는 토마토를 의미한다.<br>
 * 대각선 방향에 있는 토마토들에게는 영향을 주지 못하며, 토마토가 혼자 저절로 익는 경우는 없다고 가정한다.<br>
 * 현수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수를 알고 싶어 한다.<br>
 * 토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때,<br>
 * 며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라.<br>
 * 단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.
 * @input 첫 줄에는 상자의 크기를 나타내는 두 정수 M, N이 주어진다.<br>
 * M은 상자의 가로 칸의 수, N은 상자의 세로 칸의 수를 나타낸다. 단, 2 ≤ M, N ≤ 1,000 이다.<br>
 * 둘째 줄부터는 하나의 상자에 저장된 토마토들의 정보가 주어진다.<br>
 * 즉, 둘째 줄부터 N개의 줄에는 상자에 담긴 토마토의 정보가 주어진다.<br>
 * 하나의 줄에는 상자 가로줄에 들어있는 토마토의 상태가 M개의 정수로 주어진다.<br>
 * 정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.
 * @output 여러분은 토마토가 모두 익을 때까지의 최소 날짜를 출력해야 한다.<br>
 * 만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고, 토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.
 * @studyStartDate 2025-07-26
 * @studyEndDate 2025-07-26
 */
public class Problem_08_12 {
	static int n; // 행
	static int m; // 열
	static int[][] board;
	static int[][] dis;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static boolean isAllCompleteTomato = true;
	static Queue<Point> q = new LinkedList<>();
	
	static class Point {
		public int x;
		public int y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static void bfs() {
		while(!q.isEmpty()) {
			Point temp = q.poll();
			for(int i = 0; i < 4; i++) {
				int nx = temp.x + dx[i];
				int ny = temp.y + dy[i];
				if(nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
					board[nx][ny] = 1;
					dis[nx][ny] = dis[temp.x][temp.y] + 1;
					q.offer(new Point(nx, ny));
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		board = new int[n+1][m+1];
		dis = new int[n+1][m+1];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				int value = Integer.parseInt(st.nextToken());
				board[i][j] = value;
				if(value == 0) {
					isAllCompleteTomato = false;
				} else if (value == 1) {
					q.offer(new Point(i, j));
				} else {
					// -1 인 경우
					dis[i][j] = -1;
				}
			}
		}
		
		if(isAllCompleteTomato) {
			bw.write("0");
		} else {
			bfs();
			int minDay = Integer.MIN_VALUE;
			boolean processFlag = true;
			for(int i = 0; i < n; i++) {
				if(!processFlag) {
					break;
				}
				for(int j = 0; j < m; j++) {
					int value = board[i][j];
					if (value == 0) {
						processFlag = false;
						break;
					} else if(dis[i][j] > minDay) {
						minDay = dis[i][j];
					}
				}
			}
			bw.write(String.valueOf(processFlag ? minDay : -1));
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}
