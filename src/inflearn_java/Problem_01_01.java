package inflearn_java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @title 1. 문자 찾기
 * @desc 한 개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정문자가 입력받은 문자열에<br>
 *       몇 개 존재하는지 알아내는 프로그램을 작성하세요.<br>
 *       대소문자를 구분하지 않습니다.문자열의 길이는 100을 넘지 않습니다.
 * @input 첫 줄에 문자열이 주어지고, 두 번째 줄에 문자가 주어진다. 문자열은 영어 알파벳으로만 구성되어 있습니다.
 * @output 첫 줄에 해당 문자의 개수를 출력한다.
 * @studyStartDate 2023-01-02
 * @studyEndDate 2023-01-02
 */
public class Problem_01_01 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 대소문자의 차이는 아스키 코드값 기준 32
		String text = br.readLine();
		int findCode = br.readLine().charAt(0);
		int count = 0;

		// 대문자가 아니면, 대문자로 변환
		findCode = findCode < 96 ? findCode : findCode-32;
		for(int i=0; i<text.length(); i++){
			if(findCode == text.charAt(i) || findCode == text.charAt(i)-32){
				count++;
			}
		}

		bw.write(count+"");
		br.close();
		bw.close();
	}
}