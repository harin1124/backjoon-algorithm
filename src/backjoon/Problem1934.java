package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @title 최소공배수
 * @desc 두 자연수 A와 B에 대해서, A의 배수이면서 B의 배수인 자연수를 A와 B의 공배수라고 한다.<br>
 * 이런 공배수 중에서 가장 작은 수를 최소공배수라고 한다.<br>
 * 예를 들어, 6과 15의 공배수는 30, 60, 90등이 있으며, 최소 공배수는 30이다.<br>
 * 두 자연수 A와 B가 주어졌을 때, A와 B의 최소공배수를 구하는 프로그램을 작성하시오.
 * @input 첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 7)
 * @output 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다.<br>
 * 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.<br>
 * 수열은 사전 순으로 증가하는 순서로 출력해야 한다.
 * @studyStartDate 2025-09-06
 * @studyEndDate 2025-09-06
 */
public class Problem1934 {
	static BufferedWriter bw;
	
	private static void getLcm(int max, int min) throws Exception {
		boolean flag = true;
		int i = 1;
		while(flag) {
			int number = max * i;
			int result = number % min;
			if(result == 0) {
				bw.write(String.valueOf(number));
				bw.write('\n');
				flag = false;
			} else {
				i++;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int size = Integer.parseInt(st.nextToken());
		int a;
		int b;
		
		for(int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			if (a <= b) {
				getLcm(b, a);
			} else {
				getLcm(a, b);
			}
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}
