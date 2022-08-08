package backjoon;

import java.util.Scanner;

/**
 * @title 사칙연산
 * @desc 두 자연수 A와 B가 주어진다.<br>
 * 이때, A+B, A-B, A*B, A/B(몫), A%B(나머지)를 출력하는 프로그램을 작성하시오. 
 * @input 첫째 줄에 (1)의 위치에 들어갈 세 자리 자연수가, 둘째 줄에 (2)의 위치에 들어갈 세자리 자연수가 주어진다.
 * @output 첫째 줄부터 넷째 줄까지 차례대로 (3), (4), (5), (6)에 들어갈 값을 출력한다.
 * @studyStartDate 2022-01-15
 * @studyEndDate 2022-01-16
 */
public class problem2588 {
	/* ====================================
	예제 입력
	472
	385
	
	예제 출력
	2360
	3776
	1416
	181720
	==================================== */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Integer a = scanner.nextInt();
		String b = scanner.next();
		scanner.close();
		Integer c = 0;
		for(int i=2; i>=0; i--){
			c = Integer.valueOf(String.valueOf( b.charAt(i) )) * a;
			System.out.println(c);
		}
		System.out.println(a * Integer.valueOf(b));
	}
}