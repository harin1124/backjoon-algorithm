package backjoon;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * @title 문자열
 * @desc 문자열을 입력으로 주면 문자열의 첫 글자와 마지막 글자를 출력하는 프로그램을 작성하시오.
 * @input 입력의 첫 줄에는 테스트 케이스의 개수 T(1 ≤ T ≤ 10)가 주어진다.<br>
 * 각 테스트 케이스는 한 줄에 하나의 문자열이 주어진다.<br>
 * 문자열은 알파벳 A~Z 대문자로 이루어지며 알파벳 사이에 공백은 없으며 문자열의 길이는 1000보다 작다.
 * @output 각 테스트 케이스에 대해서 주어진 문자열의 첫 글자와 마지막 글자를 연속하여 출력한다.
 * @studyStartDate 2025-07-21
 * @studyEndDate 2025-07-21
 */
public class Problem9086 {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int line = scan.nextInt();
		scan.nextLine();

		for (int i = 0; i < line; i++) {
			String[] str = scan.nextLine().split("");
			bw.write(str[0] + str[str.length - 1] + "\n");
		}

		scan.close();
		bw.flush();
		bw.close();
	}
}
