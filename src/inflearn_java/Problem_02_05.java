package inflearn_java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @title 5. 소수(에라토스테네스 체)
 * @desc 자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.<br>
 *       만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.
 * @input 첫 줄에 자연수의 개수 N(2<=N<=200,000)이 주어집니다.
 * @output 첫 줄에 소수의 개수를 출력합니다.
 * @studyStartDate 2023-01-17
 * @studyEndDate 2023-01-17
 */
public class Problem_02_05 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int size = Integer.parseInt(br.readLine());
		int[] arr = new int[size+1];
		int i=2;
		int j=0;
		int cnt = 0;
		for(i=2; i<=size; i++){
			if(arr[i] == 0){
				// 0이면, 지우지 않은 수로 소수임을 뜻하므로 cnt 증가
				cnt++;
				// j가 i+i인 것은, 본인은 지우지 않기 위함
				for(j=i+i; j<=size; j=j+i){
					arr[j] = 1;
				}
			}
		}
		bw.write(cnt+"");
		br.close();
		bw.close();
	}
}