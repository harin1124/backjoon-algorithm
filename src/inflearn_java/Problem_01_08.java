package inflearn_java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @title 8. 유효한 팰린드롬
 * @desc 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 팰린드롬이라고 합니다.<br>
 *       문자열이 입력되면 해당 문자열이 팰린드롬이면 "YES", 아니면 “NO"를 출력하는 프로그램을 작성하세요.<br>
 *       단 회문을 검사할 때 알파벳만 가지고 회문을 검사하며, 대소문자를 구분하지 않습니다.
 * @input 첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.
 * @output 첫 번째 줄에 회문 문자열인지의 결과를 YES 또는 NO로 출력합니다.
 * @studyStartDate 2023-01-11
 * @studyEndDate 2023-01-11
 */
public class Problem_01_08 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		char[] str = br.readLine().toUpperCase().toCharArray();
		int lt = 0;
		int rt = str.length-1;
		boolean sameWord = true;
		while(lt < rt){
			if(!(65 <= str[lt]) || !(str[lt] <= 90) ){ // 아스키 코드값 기준 알파벳이 아니면
				lt++;
			} else if( !(65 <= str[rt]) || !(str[rt] <= 90) ){ // 아스키 코드값 기준 알파벳이 아니면
				rt--;
			} else {
				// 알파벳일 경우
				if(str[lt] != str[rt]){
					// 알파벳이 서로 같지 않을 경우, while문 종료
					sameWord = false;
					break;
				}
				lt++;
				rt--;
			}
		}
		bw.write(sameWord ? "YES" : "NO");
		bw.close();
		br.close();
	}
}