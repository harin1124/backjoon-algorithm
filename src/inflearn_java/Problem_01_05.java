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
public class Problem_01_05 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		char[] strList = br.readLine().toCharArray();
		int leftPoint = 0;
		int rightPoint = strList.length-1;
		char temp = 0;
		for(leftPoint=0; leftPoint<rightPoint; leftPoint++){
			// 왼쪽 포인터의 문자가 영문자일 때
			if(65 <= strList[leftPoint] && strList[leftPoint] <= 122){
				// 오른쪽 포인터의 문자가 영문자가 될 때까지 왼쪽 방향으로 이동
				while(true){
					if(65 <= strList[rightPoint] && strList[rightPoint] <= 122){
						// 영문자면 해당 while문 종료
						break;
					} else {
						rightPoint--;
					}
				}
				// 왼쪽 포인터보다 오른쪽 포인터가 더 크다면
				if(leftPoint < rightPoint){
					// 값 교환
					temp = strList[leftPoint];
					strList[leftPoint] = strList[rightPoint];
					strList[rightPoint] = temp;
				}
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