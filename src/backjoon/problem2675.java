package backjoon;

import java.util.Scanner;

/**
 * @title 문자열 반복
 * @desc 문자열 S를 입력받은 후에, 각 문자를 R번 반복해 새 문자열 P를 만든 후 출력하는 프로그램을 작성하시오.<br>
		 즉, 첫 번째 문자를 R번 반복하고, 두 번째 문자를 R번 반복하는 식으로 P를 만들면 된다.<br>
		 S에는 QR Code "alphanumeric" 문자만 들어있다.<br>
		 QR Code "alphanumeric" 문자는 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ\$%*+-./: 이다.
 * @input 첫째 줄에 테스트 케이스의 개수 T(1 ≤ T ≤ 1,000)가 주어진다.<br>
		  각 테스트 케이스는 반복 횟수 R(1 ≤ R ≤ 8), 문자열 S가 공백으로 구분되어 주어진다.<br>
		  S의 길이는 적어도 1이며, 20글자를 넘지 않는다.
 * @output 각 테스트 케이스에 대해 P를 출력한다.
 * @studyStartDate 2022-08-08
 * @studyEndDate 2022-08-
 */
public class problem2675 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int len = 0;
		String[] r = new String[size];
		String str;
		String t;
		String t2 = "";
		String t3 = "";
		for(int i=0; i<size; i++){
			len = s.nextInt();
			str = s.nextLine();
			for(int j=1; j<str.length(); j++){
				System.out.println(str.charAt(j));
				t = String.valueOf(str.charAt(j));
				for(int x=0; x<len; x++){
					t2 += t;
				}
				t3 += t2;
				t2 = "";
			}
			t3 = "";
			r[i] = t3;

			// 배열 합치기

		}

		System.out.println(">>> "+r[0]);

		s.close();
	}
}