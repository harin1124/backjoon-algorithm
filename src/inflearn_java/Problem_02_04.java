package inflearn_java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @title 4. 피보나치 수열
 * @desc 1) 피보나키 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.<br>
 *       2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.
 * @input 첫 줄에 총 항수 N(3<=N<=45)이 입력된다.
 * @output 첫 줄에 피보나치 수열을 출력합니다.
 * @studyStartDate 2023-01-17
 * @studyEndDate 2023-01-17
 */
public class Problem_02_04 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int size = Integer.parseInt(br.readLine());
		int p1 = 0;
		int p2 = 1;
		int now = 0;

		for(int i=0; i<size; i++){
			now = p1 + p2;
			bw.write(now+" ");
			p2 = p1;
			p1 = now;
		}
		br.close();
		bw.close();
	}
}