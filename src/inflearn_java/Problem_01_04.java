package inflearn_java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @title 4. 단어 뒤집기
 * @desc N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.
 * @input 첫 줄에 자연수 N(3<=N<=20)이 주어집니다.<br>
 *        두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다. 단어는 영어 알파벳으로만 구성되어 있습니다.
 * @output N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집어서 출력합니다.
 * @studyStartDate 2023-01-08
 * @studyEndDate 2023-01-08
 */
public class Problem_01_04 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str;
		int size = Integer.parseInt(br.readLine());
		char[] strList;
		int strLen;
		int j=0;

		char a;
		char b;
		for(int i=0; i<size; i++){
			str = br.readLine();
			strList = str.toCharArray();
			strLen = strList.length;
			for(j=0; j<strLen/2; j++){
				a = strList[j];
				b = strList[strLen - 1 - j];
				strList[j] = b;
				strList[strLen - 1 - j] = a;
			}
			for(char c : strList){
				bw.write(c);
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}