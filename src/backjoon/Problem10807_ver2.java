package backjoon;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * @title 개수 세기
 * @desc 총 N개의 정수가 주어졌을 때, 정수 v가 몇 개인지 구하는 프로그램을 작성하시오.
 * @input 첫째 줄에 정수의 개수 N(1 ≤ N ≤ 100)이 주어진다.<br>
 * 둘째 줄에는 정수가 공백으로 구분되어져있다.<br>
 * 셋째 줄에는 찾으려고 하는 정수 v가 주어진다.<br>
 * 입력으로 주어지는 정수와 v는 -100보다 크거나 같으며, 100보다 작거나 같다.
 * @output 첫째 줄에 입력으로 주어진 N개의 정수 중에 v가 몇 개인지 출력한다.
 * @studyStartDate 2025-07-16
 * @studyEndDate 2025-07-16
 */
public class Problem10807_ver2 {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		scan.nextLine();
		String str = scan.nextLine();
		String[] strArr = str.split(" ");
		
		String keyword = String.valueOf(scan.nextInt());
		
		int result = 0;
		
		for(String s : strArr){
			if (s.equals(keyword)) {
				result++;
			}
		}
		bw.write(result + "");
		
		scan.close();
		bw.flush();
		bw.close();
	}
}