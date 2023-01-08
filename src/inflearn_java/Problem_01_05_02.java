package inflearn_java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @title 5. 특정 문자 뒤집기
 * @desc 영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,<br>
 *       특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.
 * @input 첫 줄에 길이가 100을 넘지 않는 문자열이 주어집니다.
 * @output 첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다.
 * @studyStartDate 2023-01-08
 * @studyEndDate 2023-01-08
 */
public class Problem_01_05_02 {
	public static void main(String[] args) throws Exception {
		// 강의에서 나온, if else 문 방법으로 푸는 법
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		char[] strList = br.readLine().toCharArray();
		int leftPoint = 0;
		int rightPoint = strList.length-1;
		char temp = 0;

		while(leftPoint < rightPoint){
			if(!(65 <= strList[leftPoint] && strList[leftPoint] <= 122)){
				leftPoint++;
			} else if(!(65 <= strList[rightPoint] && strList[rightPoint] <= 122)){
				rightPoint--;
			} else {
				temp = strList[leftPoint];
				strList[leftPoint] = strList[rightPoint];
				strList[rightPoint] = temp;
				leftPoint++;
				rightPoint--;
			}
		}
		for(char c : strList){
			bw.write(c);
		}
		bw.close();
		br.close();
	}
}