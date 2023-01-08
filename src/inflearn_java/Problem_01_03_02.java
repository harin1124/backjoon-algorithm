package inflearn_java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @title 3. 문장 속 단어
 * @desc 한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.<br>
 *       문장속의 각 단어는 공백으로 구분됩니다.
 * @input 첫 줄에 길이가 100을 넘지 않는 한 개의 문장이 주어집니다. 문장은 영어 알파벳으로만 구성되어 있습니다.
 * @output 첫 줄에 가장 긴 단어를 출력한다. 가장 길이가 긴 단어가 여러개일 경우 문장속에서 가장 앞쪽에 위치한 단어를 답으로 합니다.
 * @studyStartDate 2023-01-08
 * @studyEndDate 2023-01-08
 */
public class Problem_01_03_02 {
	public static void main(String[] args) throws Exception {
		// 강의에서 나온, 포인터 개념으로 푸는 방법
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		String tmp;
		String result = "";
		int minLength = 0;
		int pos = 0;

		while((pos = str.indexOf(" ")) != -1){
			tmp = str.substring(0, pos); // 0번째부터 pos의 값의 전까지 문자열 잘라내기
			if(tmp.length() > minLength){
				minLength = tmp.length();
				result = tmp;
			}
			// 포인터 기준으로 다음 번에 확인할 문자열 재정의
			str = str.substring(pos+1);
		}
		// 마지막 나머지 검사
		if(str.length() > minLength){
			result = str;
		}

		bw.write(result+"");
		br.close();
		bw.close();
	}
}