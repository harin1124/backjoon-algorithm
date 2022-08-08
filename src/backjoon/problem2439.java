package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @title 별 찍기 - 2
 * @desc 첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제<br>
		 하지만, 오른쪽을 기준으로 정렬한 별(예제 참고)을 출력하시오.
 * @input 첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.
 * @output 첫째 줄부터 N번째 줄까지 차례대로 별을 출력한다.
 * @studyStartDate 2022-01-18
 * @studyEndDate 2022-01-18
 */
public class problem2439 {
	/* ====================================
	예제 입력
	5
	
	예제 출력
	    *
	   **
	  ***
	 ****
	*****
	==================================== */ 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T=Integer.parseInt(br.readLine());
		//int T=5;
		br.close();
		for(int i=1; i<=T; i++){
			for(int space=1; space<=T-i; space++){ //공백
				bw.write(" ");
			}
			for(int star=1; star<=i; star++){ //별
				bw.write("*");
			}
			bw.write("\n");
		}
		bw.close();
	}
}