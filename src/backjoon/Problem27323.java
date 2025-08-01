package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @title 직사각형
 * @desc 정수 A, B 가 주어진다.<br>
 * 세로 길이가 A cm, 가로 길이가 B cm 인 아래와 같은 직사각형의 넓이를 cm2 단위로 구하시오.
 * @input 표준 입력에 다음과 같은 형태로 입력이 주어진다.<br>
 * A<br>
 * B
 * @output 세로 길이가 A cm, 가로 길이가 B cm인 직사각형의 넓이를 cm2 단위로 구하고, 단위 (cm2)를 생략하여 출력한다.
 * @studyStartDate 2025-08-01
 * @studyEndDate 2025-08-01
 */
public class Problem27323 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		bw.write(String.valueOf(a*b));
		
		br.close();
		bw.flush();
		bw.close();
	}
}
