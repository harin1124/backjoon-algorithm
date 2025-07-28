package inflearn_java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @title 피자 배달 거리(삼성 SW역량평가 기출문제 : DFS활용)
 * @desc N×N 크기의 도시지도가 있습니다. 도시지도는 1×1크기의 격자칸으로 이루어져 있습니다.<br>
 * 각 격자칸에는 0은 빈칸, 1은 집, 2는 피자집으로 표현됩니다.<br>
 * 각 격자칸은 좌표(행번호, 열 번호)로 표현됩니다.<br>
 * 행번호는 1번부터 N번까지이고, 열 번호도 1부터 N까지입니다.<br>
 * 도시에는 각 집마다 “피자배달거리”가 았는데 각 집의 피자배달거리는 해당 집과 도시의 존재하는 피자집들과의 거리 중 최소값을 해당 집의 “피자배달거리”라고 한다.<br>
 * 집과 피자집의 피자배달거리는 |x1-x2|+|y1-y2| 이다.<br>
 * 예를 들어, 도시의 지도가 아래와 같다면<br>
 * 0 1 0 0<br>
 * 0 0 2 1<br>
 * 0 0 1 0<br>
 * 1 2 0 2<br>
 * (1, 2)에 있는 집과 (2, 3)에 있는 피자집과의 피자 배달 거리는 |1-2| + |2-3| = 2가 된다.<br>
 * 최근 도시가 불경기에 접어들어 우후죽순 생겼던 피자집들이 파산하고 있습니다.
 * 도시 시장은 도시에 있는 피자집 중 M개만 살리고 나머지는 보조금을 주고 폐업시키려고 합니다.<br>
 * 시장은 살리고자 하는 피자집 M개를 선택하는 기준으로 도시의 피자배달거리가 최소가 되는 M개의 피자집을 선택하려고 합니다.<br>
 * 도시의 피자 배달 거리는 각 집들의 피자 배달 거리를 합한 것을 말합니다.
 * @input 첫째 줄에 N(2 ≤ N ≤ 50)과 M(1 ≤ M ≤ 12)이 주어진다.<br>
 * 둘째 줄부터 도시 정보가 입력된다.
 * @output 첫째 줄에 M개의 피자집이 선택되었을 때 도시의 최소 피자배달거리를 출력한다.
 * @studyStartDate 2025-07-28
 * @studyEndDate 2025-07-28
 */
public class Problem_08_15 {
	static int n; // 행&열
	static int m; // limit pizza store
	static ArrayList<Point> houseArray = new ArrayList<>();
	static ArrayList<Point> storeArray = new ArrayList<>();
	static int[] storePickArray;
	static int sum = Integer.MAX_VALUE;
	
	static class Point {
		public int x;
		public int y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static void dfs(int level, int index) {
		if(level == m) {
			int housesDistance = 0;
			for(Point house : houseArray) {
				Point store;
				int distance = Integer.MAX_VALUE;
				for(int storeIndex : storePickArray) {
					store = storeArray.get(storeIndex);
					int x = Math.abs(house.x - store.x);
					int y = Math.abs(house.y - store.y);
					distance = Math.min(distance, x + y);
				}
				housesDistance += distance;
			}
			sum = Math.min(sum, housesDistance);
		} else {
			for (int i = index, size = storeArray.size(); i < size; i++) {
				storePickArray[level] = i;
				dfs(level + 1, i + 1);
			}
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		storePickArray = new int[m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				int value = Integer.parseInt(st.nextToken());
				if(value == 1) {
					houseArray.add(new Point(i, j));
				} else if (value == 2) {
					storeArray.add(new Point(i, j));
				}
			}
		}
		
		dfs(0, 0);
		
		bw.write(String.valueOf(sum));
		
		bw.flush();
		bw.close();
		br.close();
	}
}