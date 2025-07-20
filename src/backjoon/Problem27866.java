package backjoon;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * @title 문자와 문자열
 * @desc 단어 S와 정수i가 주어졌을 때, S의 i번째 글자를 출력하는 프로그램을 작성하시오.
 * @input 첫째 줄에 영어 소문자와 대문자로만 이루어진 단어 S가 주어진다. 단어의 길이는 최대 1,000이다.<br>
 * 둘째 줄에 정수 i가 주어진다. (1 <= i <= |S|)
 * @output S의 i번째 글자를 출력한다.
 * @studyStartDate 2025-07-20
 * @studyEndDate 2025-07-20
 */
public class Problem27866 {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		char[] c = scan.nextLine().toCharArray();
		int n = scan.nextInt();
		
		bw.write(String.valueOf(c[n - 1]));
		
		scan.close();
		bw.flush();
		bw.close();
	}
}
