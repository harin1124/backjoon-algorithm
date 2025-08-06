package backjoon;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @title 안전 영역
 * @desc 재난방재청에서는 많은 비가 내리는 장마철에 대비해서 다음과 같은 일을 계획하고 있다.<br>
 * 먼저 어떤 지역의 높이 정보를 파악한다.<br>
 * 그 다음에 그 지역에 많은 비가 내렸을 때 물에 잠기지 않는 안전한 영역이 최대로 몇 개가 만들어 지는 지를 조사하려고 한다.<br>
 * 이때, 문제를 간단하게 하기 위하여, 장마철에 내리는 비의 양에 따라 일정한 높이 이하의 모든 지점은 물에 잠긴다고 가정한다.<br>
 * 물에 잠기지 않는 안전한 영역이라 함은 물에 잠기지 않는 지점들이 위, 아래, 오른쪽 혹은 왼쪽으로 인접해 있으며 그 크기가 최대인 영역을 말한다.<br>
 * 위의 경우에서 물에 잠기지 않는 안전한 영역은 5개가 된다(꼭짓점으로만 붙어 있는 두 지점은 인접하지 않는다고 취급한다).<br>
 * 어떤 지역의 높이 정보가 주어졌을 때, 장마철에 물에 잠기지 않는 안전한 영역의 최대 개수를 계산하는 프로그램을 작성하시오.
 * @input 첫째 줄에는 어떤 지역을 나타내는 2차원 배열의 행과 열의 개수를 나타내는 수 N이 입력된다.<br>
 * N은 2 이상 100 이하의 정수이다. 둘째 줄부터 N개의 각 줄에는 2차원 배열의 첫 번째 행부터 N번째 행까지 순서대로 한 행씩 높이 정보가 입력된다.<br>
 * 각 줄에는 각 행의 첫 번째 열부터 N번째 열까지 N개의 높이 정보를 나타내는 자연수가 빈 칸을 사이에 두고 입력된다.<br>
 * 높이는 1이상 100 이하의 정수이다.
 * @output 첫째 줄에 장마철에 물에 잠기지 않는 안전한 영역의 최대 개수를 출력한다.
 * @studyStartDate 2025-08-05
 * @studyEndDate 2025-08-06
 */
public class Problem2468 {
	static int N;
	static int[][] BOARD;
	static int[][] CHECK_BOARD;
	static int MAX_POINT = 0;
	static int[] DX = {-1, 0, 1, 0};
	static int[] DY = {0, 1, 0, -1};
	static int MAX_RESULT = 0;
	
	
	static void dfs(int x, int y, boolean[][] visited, int rainHeight) {
		visited[x][y] = true;  // 현재 위치 방문 표시
		
		for(int i = 0; i < 4; i++) {
			int nx = x + DX[i];
			int ny = y + DY[i];
			if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
				if (!visited[nx][ny] && BOARD[nx][ny] > rainHeight) {
					dfs(nx, ny, visited, rainHeight);
				}
			}
		}
	}
	
	static void solution(int rainHeight) {
		boolean[][] visited = new boolean[N][N];
		int result = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if (!visited[i][j] && BOARD[i][j] > rainHeight) {
					dfs(i, j, visited, rainHeight);
					result++;
				}
			}
		}
		MAX_RESULT = Math.max(MAX_RESULT, result);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		BOARD = new int[N][N];
		CHECK_BOARD = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int value = Integer.parseInt(st.nextToken());
				BOARD[i][j] = value;
				
				if(value > MAX_POINT) {
					MAX_POINT = value;
				}
			}
		}
		
		for(int p = 0; p <= MAX_POINT; p++) {
			solution(p);
		}
		
		bw.write(String.valueOf(MAX_RESULT));
		
		br.close();
		bw.flush();
		bw.close();
	}
}
