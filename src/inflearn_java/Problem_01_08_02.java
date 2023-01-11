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
public class Problem_01_08_02 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// for문에서 포인터 개념을 사용하지 않고, 정규식으로 [문자가 아닌 것 && 숫자]를 찾아서 제거한 채로 탐색
		char[] str = br.readLine().replaceAll("[\\W\\d]", "").toUpperCase().toCharArray();
		int size = str.length;
		boolean sameWord = true;
		for(int i=0; i<size/2; i++){
			if(str[i] != str[size - 1 - i]){
				sameWord = false;
				break;
			}
		}
		bw.write(sameWord ? "YES" : "NO");
		bw.close();
		br.close();
	}
}