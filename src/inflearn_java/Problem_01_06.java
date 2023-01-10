package inflearn_java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @title 6. 중복문자제거
 * @desc 소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.<br>
 *       중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.
 * @input 첫 줄에 문자열이 입력됩니다. 문자열의 길이는 100을 넘지 않는다.
 * @output 첫 줄에 중복문자가 제거된 문자열을 출력합니다.
 * @studyStartDate 2023-01-09
 * @studyEndDate 2023-01-10
 */
public class Problem_01_06 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		for(int i=0; i<str.length(); i++){
			if(i == str.indexOf(str.charAt(i))){
				bw.write(str.charAt(i));
			}
		}
		bw.close();
		br.close();
	}
}