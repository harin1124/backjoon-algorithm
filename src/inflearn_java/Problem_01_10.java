package inflearn_java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @title 10. 가장 짧은 문자거리
 * @desc 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.
 * @input 첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.<br>
 *        문자열의 길이는 100을 넘지 않는다.
 * @output 첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.
 * @studyStartDate 2023-01-12
 * @studyEndDate 2023-01-15
 */
public class Problem_01_10 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] data = br.readLine().split(" ");
		char t = data[1].charAt(0);
		char[] s = data[0].toCharArray();
		int[] result = new int[s.length];
		int p = 110;

		// 왼쪽기준으로 훑어서, 타겟 문자열(t) 와의 거리 구하기
		for(int i=0; i<s.length; i++){
			if( s[i] == t ){
				p = 0;
			} else {
				p++;
			}
			result[i] = p;
		}

		p = 110;
		// 오른쪽기준으로 훑어서, 타겟 문자열(t) 와의 거리 구하기
		for(int i=s.length-1; i>=0; i--){
			if( s[i] == t ){
				p = 0;
			} else {
				p++;
				// 왼쪽기준으로 본 거리가, 현재의 거리보다 크면 바꿔준다. => 최소한의 거리가 조건이므로
				if(result[i] > p){
					result[i] = p;
				}
			}
		}

		for(int i : result){
			bw.write(i+" ");
		}
		bw.close();
		br.close();
	}
}