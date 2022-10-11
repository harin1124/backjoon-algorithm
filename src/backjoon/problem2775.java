package backjoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @title 부녀회장이 될테야
 * @desc 평소 반상회에 참석하는 것을 좋아하는 주희는 이번 기회에 부녀회장이 되고 싶어<br>
         각 층의 사람들을 불러 모아 반상회를 주최하려고 한다.<br>
         이 아파트에 거주를 하려면 조건이 있는데,<br>
         “a층의 b호에 살려면 자신의 아래(a-1)층의 1호부터 b호까지 사람들의 수의 합만큼 사람들을 데려와 살아야 한다” 는 계약 조항을 꼭 지키고 들어와야 한다.<br>
         아파트에 비어있는 집은 없고 모든 거주민들이 이 계약 조건을 지키고 왔다고 가정했을 때,<br>
         주어지는 양의 정수 k와 n에 대해 k층에 n호에는 몇 명이 살고 있는지 출력하라.<br>
         단, 아파트에는 0층부터 있고 각층에는 1호부터 있으며, 0층의 i호에는 i명이 산다.
 * @input 첫 번째 줄에 Test case의 수 T가 주어진다.<br>
          그리고 각각의 케이스마다 입력으로 첫 번째 줄에 정수 k, 두 번째 줄에 정수 n이 주어진다
 * @output 각각의 Test case에 대해서 해당 집에 거주민 수를 출력하라.
 * @limit 1 ≤ k, n ≤ 14
 * @studyStartDate 2022-10-11
 * @studyEndDate 2022-10-
 */
public class problem2775 {
	// space 확인용 메소드
	public static void spacePrint(int[][] space, int floor, int ho){
		for(int row=0; row<floor; row++){
			for(int col=0; col<ho; col++){
				System.out.println("space["+row+"]["+col+"] = "+space[row][col]);
			}
			System.out.println("==================");
		}
	}

	public static void main(String[] args) throws IOException {
		// 메모리 절약을 위해 BufferedReader와 StringTokenizer 사용
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int size = Integer.parseInt(br.readLine());
		int[][] request = new int[size][2];
		int[][] space = null;
		int maxFloor = 0;
		int maxHo = 0;

		// 최대 층수, 호수 구하기 & 요청 온 층수와 호수를 이중배열에 저장
		for(int i=0; i<size; i++){
			request[i][0] = Integer.parseInt(br.readLine());
			request[i][1] = Integer.parseInt(br.readLine());
			if(maxFloor < request[i][0]){
				maxFloor = request[i][0];
			}
			if(maxHo < request[i][1]){
				maxHo = request[i][1];
			}
		}


		// 배열 만들기
		maxFloor++; // 0층도 계산해야되기 때문
		space = new int[maxFloor][maxHo];
		for(int row=0; row<maxFloor; row++){
			for(int col=0; col<maxHo; col++){
				if(row == 0){ // 0번째 row의 컬럼은 무조건 컬럼의 넘버+1 이므로
					space[row][col] = col+1;
				} else {
					if(col == 0){
						space[row][col] = 1; // 0번째 컬럼은 무조건 값이 0이므로
					} else {
						space[row][col] = space[row][col-1] + space[row-1][col];
					}
				}
			}
		}
		
		// 만든 배열 기준으로 request 값 도출
		for(int i=0; i<size; i++){
			bw.write(( space[ request[i][0] ][ request[i][1]-1 ] )+"\n");
		}
		
		br.close();
		bw.close();
	}
}