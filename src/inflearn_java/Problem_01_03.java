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
 * @studyStartDate 2023-01-07
 * @studyEndDate 2023-01-06
 */
public class Problem_01_03 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 문자열을 받아서 공백 기준으로 문자열 배열 생성
		String[] words = br.readLine().split(" ");
		int len = 0;
		int idx = 0;
		// 뒤에서부터 반복문으로 값 찾기 => 가장 길이가 긴 단어가 여러개일 때 문장속에서 가장 앞쪽에 위치한 단어가 답이므로, 뒤에서부터 찾음
		for(int i=words.length-1; i>=0; i--){
			if(words[i].length() >= len){
				len = words[i].length();
				idx = i;
			}
		}
		bw.write(words[idx]+"");
		br.close();
		bw.close();
	}
}