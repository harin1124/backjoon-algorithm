package inflearn_java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @title 미로탐색(DFS)
 * @desc 7*7 격자판 미로를 탈출하는 경로의 가지수를 출력하는 프로그램을 작성하세요.<br>
 * 출발점은 격자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7)좌표이다.<br>
 * 격자판의 1은 벽이고, 0은 통로이다. 격자판의 움직임은 상하좌우로만 움직인다.<br>
 * 미로가 다음과 같다면 위의 지도에서 출발점에서 도착점까지 갈 수 있는 방법의 수는 8가지이다.<br>
 * 0 0 0 0 0 0 0<br>
 * 0 1 1 1 1 1 0<br>
 * 0 0 0 1 0 0 0<br>
 * 1 1 0 1 0 1 1<br>
 * 1 1 0 0 0 0 1<br>
 * 1 1 0 1 1 0 0<br>
 * 1 0 0 0 0 0 0
 * @input 7*7 격자판의 정보가 주어집니다.
 * @output 첫 번째 줄에 경로의 가지수를 출력한다.
 * @studyStartDate 2025-07-23
 * @studyEndDate 2025-07-23
 */
public class Problem_08_10 {
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] arr = new int[8][8];
	static int answer = 0;
	
	static void dfs(int x, int y) {
		if(x == 7 && y == 7) {
			answer++;
		} else {
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && arr[nx][ny] == 0) {
					arr[nx][ny] = 1;
					dfs(nx, ny);
					arr[nx][ny] = 0;
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
		
		arr[1][1] = 1;
		dfs(1, 1);
		
		bw.write(answer + "");
		
		br.close();
		bw.flush();
		bw.close();
	}
}
