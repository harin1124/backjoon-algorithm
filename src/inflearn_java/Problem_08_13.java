package inflearn_java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @title 섬나라 아일랜드
 * @desc N*N의 섬나라 아일랜드의 지도가 격자판의 정보로 주어집니다.<br>
 * 각 섬은 1로 표시되어 상하좌우와 대각선으로 연결되어 있으며, 0은 바다입니다.<br>
 * 섬나라 아일랜드에 몇 개의 섬이 있는지 구하는 프로그램을 작성하세요.
 * 1 1 0 0 0 1 0<br>
 * 0 1 1 0 1 1 0<br>
 * 0 1 0 0 0 0 0<br>
 * 0 0 0 1 0 1 1<br>
 * 1 1 0 1 1 0 0<br>
 * 1 0 0 0 1 0 0<br>
 * 1 0 1 0 1 0 0<br>
 * 만약 위와 같다면 섬의 개수는 5개입니다.
 * @input 첫 번째 줄에 자연수 N(3<=N<=20)이 주어집니다.<br>
 * 두 번째 줄부터 격자판 정보가 주어진다.
 * @output 첫 번째 줄에 섬의 개수를 출력한다.
 * @studyStartDate 2025-07-27
 * @studyEndDate 2025-07-27
 */
public class Problem_08_13 {
	static int n; // 행&열
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	static int islandCount = 0;
	
	static void dfs(int x, int y, int[][] board) {
		board[x][y] = 0;
		for(int i = 0; i < 8; i ++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) {
				dfs(nx, ny, board);
			}
		}
	}
	
	static void solution(int[][] board) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(board[i][j] == 1) {
					islandCount++;
					dfs(i, j, board);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solution(arr);
		
		bw.write(String.valueOf(islandCount));
		
		bw.flush();
		bw.close();
		br.close();
	}
}