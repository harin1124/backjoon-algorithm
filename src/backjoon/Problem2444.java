package backjoon;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * @title 별 찍기 - 7
 * @desc 예제를 보고 규칙을 유추한 뒤에 별을 찍어 보세요.
 * @input 첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.
 * @output 첫째 줄부터 2×N-1번째 줄까지 차례대로 별을 출력한다.
 * @studyStartDate 2025-07-21
 * @studyEndDate 2025-07-21
 */
public class Problem2444 {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String star = "*";
		int n = scan.nextInt();
		scan.close();

		if(n == 1) {
			bw.write(star);
		} else {
			String[] arr = new String[n];
			int maxStarCount = n + (n - 1);

			for(int i = 0; i < n; i++) {
				int starCount = i + (i + 1);
				int spaceCount = (maxStarCount - starCount) / 2;
				String a = " ".repeat(spaceCount) + star.repeat(starCount) + "\n";
				arr[i] = a;
				bw.write(a);
			}
			for(int i = n - 2; i >= 0; i--) {
				bw.write(arr[i]);
			}
		}
		bw.flush();
		bw.close();
	}
}
