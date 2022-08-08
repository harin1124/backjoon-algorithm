package backjoon;

import java.util.Scanner;

/**
 * @title 사칙연산
 * @desc 두 자연수 A와 B가 주어진다.<br>
 * 이때, A+B, A-B, A*B, A/B(몫), A%B(나머지)를 출력하는 프로그램을 작성하시오. 
 * @input 두 자연수 A와 B가 주어진다. (1 ≤ A, B ≤ 10,000)
 * @output 첫째 줄에 A+B, 둘째 줄에 A-B, 셋째 줄에 A*B, 넷째 줄에 A/B, 다섯째 줄에 A%B를 출력한다.
 * @studyStartDate 2022-01-15
 * @studyEndDate 2022-01-15
 */
public class problem10869 {
	/* ====================================
	예제 입력
	7 3
	
	예제 출력
	10
	4
	21
	2
	1
	==================================== */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Integer a = scanner.nextInt();
		Integer b = scanner.nextInt();
		scanner.close();
		
		System.out.println(a+b); //A+B
		System.out.println(a-b); //A-B
		System.out.println(a*b); //A*B
		System.out.println(a/b); //A/B 몫
		System.out.println(a%b); //A%B 나머지
		
	}
}