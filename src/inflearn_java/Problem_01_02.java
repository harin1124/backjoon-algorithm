package inflearn_java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @title 2. 대소문자 변환
 * @desc 대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.
 * @input 첫 줄에 문자열이 입력된다. 문자열의 길이는 100을 넘지 않습니다. 문자열은 영어 알파벳으로만 구성되어 있습니다.
 * @output 첫 줄에 대문자는 소문자로, 소문자는 대문자로 변환된 문자열을 출력합니다.
 * @studyStartDate 2023-01-06
 * @studyEndDate 2023-01-06
 */
public class Problem_01_02 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		StringBuilder result = new StringBuilder();
		char abc;
		for(int i=0; i<str.length(); i++){
			abc = str.charAt(i);
			abc = (char)((abc > 93) ? abc - 32 : abc + 32);
			result.append(abc);
		}
		bw.write(result+"");
		br.close();
		bw.close();
	}
}