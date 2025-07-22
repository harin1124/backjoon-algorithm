package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @title 수 정렬하기
 * @desc N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 * @input 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다.<br>
 * 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
 * @output 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
 * @studyStartDate 2025-07-22
 * @studyEndDate 2025-07-22
 */
public class Problem2750 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int size = Integer.parseInt(br.readLine());
		int[] arr = new int[size];
		
		for(int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		// 정렬 수행
		int minValue = 0;
		for(int i = 0; i < size; i++) {
			for(int x = i + 1; x < size; x++) {
				if(arr[i] > arr[x]) {
					minValue = arr[x];
					arr[x] = arr[i];
					arr[i] = minValue;
					
				}
			}
		}
		
		for(int i : arr) {
			sb.append(i);
			sb.append("\n");
		}
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}
}
