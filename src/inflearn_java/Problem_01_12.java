package inflearn_java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @title 12. 암호
 * @desc 현수는 영희에게 알파벳 대문자로 구성된 비밀편지를 매일 컴퓨터를 이용해 보냅니다.<br>
 *       비밀편지는 현수와 영희가 서로 약속한 암호로 구성되어 있습니다.
 * @input 첫 줄에는 보낸 문자의 개수(10을 넘지 안습니다)가 입력된다. 다음 줄에는 문자의 개수의 일곱 배 만큼의 #또는 * 신호가 입력됩니다.<br>
 *        현수는 항상 대문자로 해석할 수 있는 신호를 보낸다고 가정합니다.
 * @output 영희가 해석한 문자열을 출력합니다.
 * @studyStartDate 2023-01-14
 * @studyEndDate 2023-01-15
 */
public class Problem_01_12 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int size = Integer.parseInt(br.readLine())*7;
		String str = br.readLine().replaceAll("#", "1").replaceAll("\\*", "0");
		char c;

		for(int i=0; i<size; i=i+7){
			// 문자열의 시작지점부터 7자리를 잘라서, 2진법의 int형으로 숫자 생성한 것을 char 형에 담는다 => 하나의 문자로 변환 가능 상태
			c = (char)Integer.parseInt(str.substring(i, i+7), 2);
			// 하나의 문자를 버퍼에 추가
			bw.write(String.valueOf(c));
		}
		bw.close();
		br.close();
	}
}