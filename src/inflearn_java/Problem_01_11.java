package inflearn_java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @title 11. 문자열 압축
 * @desc 알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는<br>
 *       문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.<br>
 *       단 반복횟수가 1인 경우 생략합니다.
 * @input 첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.
 * @output 첫 줄에 압축된 문자열을 출력한다.
 * @studyStartDate 2023-01-14
 * @studyEndDate 2023-01-14
 */
public class Problem_01_11 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		char[] str = br.readLine().toCharArray();
		int cnt = 0;

		// 문자열 하나씩 조회하면서
		for(int i=0; i<str.length; i++){
			// 문자열 앞의 문자열을 또 조회하면서
			for(int j=i; j<str.length; j++){
				// 현재 보고 있는 문자열의 앞 문자열이 동일하면, cnt 증가
				if(str[i] == str[j]){
					cnt++;
				} else {
					// 동일하지 않으면 압축을 하기 위한 카운트 하는 for문 종료
					break;
				}
			}
			// 압축 카운트만큼 i를 증가시켜 그 다음 문자열을 조회
			i = i + cnt - 1;
			// cnt가 1이면 cnt를 굳이 추가하지 않음
			bw.write(String.valueOf(str[i])+(cnt == 1 ? "" : cnt)+"");
			cnt = 0;
		}
		bw.close();
		br.close();
	}
}