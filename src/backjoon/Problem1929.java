package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @title 소수 구하기
 * @desc M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.
 * @input 첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다.<br>
           (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.
 * @output 한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.
 * @studyStartDate 2025-08-04
 * @studyEndDate 2025-08-04
 */
public class Problem1929 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		boolean[] isNotPrime = new boolean[n + 1];
		isNotPrime[0] = true;
		isNotPrime[1] = true;
		
		for (int i = 2; i * i <= n; i++) {
			if(!isNotPrime[i]) {
				for(int j = i * i; j <= n; j += i) {
					isNotPrime[j] = true;
				}
			}
		}
		
		for(int i = m; i <= n; i++) {
			if(!isNotPrime[i]) {
				bw.write(String.valueOf(i));
				bw.write('\n');
			}
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}