package backjoon;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * @title 꼬마 정민
 * @desc 꼬마 정민이는 이제 A + B 정도는 쉽게 계산할 수 있다. 이제 A + B + C를 계산할 차례이다!
 * @input 첫 번째 줄에 A, B, C (1 ≤ A, B, C ≤ 1012)이 공백을 사이에 두고 주어진다.
 * @output A+B+C의 값을 출력한다.
 * @studyStartDate 2025-07-12
 * @studyEndDate 2025-07-12
 */
public class Problem11382 {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long a = scan.nextLong();
		long b = scan.nextLong();
		long c = scan.nextLong();
		
		bw.write(String.valueOf(a + b + c));
		
		bw.close();
		scan.close();
	}
}
