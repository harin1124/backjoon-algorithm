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
 * @studyStartDate 2023-01-16
 * @studyEndDate 2023-01-16
 */
public class Problem_01_11_02 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 강의의 풀이와 동일하게 for문을 한 번만 사용하도록 풀이
		char[] str = br.readLine().toCharArray();
		int cnt = 1; // 모든 문자는 1번이 나오는 것이므로 1로 초기값을 둔다

		// 문자열 하나씩 조회하면서
		for(int i=0; i<str.length-1; i++){
			System.out.println(str[i]);
			// 같은 문자열이면 cnt 계속 증가
			if(str[i] == str[i+1]){
				cnt++;
				System.out.println("카운트 증가");
			} else {
				// 같은 문자열이 아니면, 결과에 해당 문자 넣고
				bw.write(String.valueOf(str[i]));
				// cnt가 1보다 크면 최소 2번 이상 나왔다는 것이므로 cnt 값도 추가
				if(cnt > 1){
					bw.write(String.valueOf(cnt));
					// 이제 다음 문자를 압축하기 위해 cnt 초기화
					cnt=1;
				}
			}
		}

		// 기존 풀이에 없는 부분
		if(cnt > 0){
			bw.write(String.valueOf(str[str.length-1]));
			bw.write(String.valueOf(cnt));
		}

		bw.close();
		br.close();
	}
}