package backjoon;

import java.util.Scanner;

/**
 * @title 곱셈
 * @desc (A+B)%C는 ((A%C) + (B%C))%C 와 같을까?<br>
		 (A×B)%C는 ((A%C) × (B%C))%C 와 같을까?<br>
		 세 수 A, B, C가 주어졌을 때, 위의 네 가지 값을 구하는 프로그램을 작성하시오.
 * @studyStartDate 2022-01-15
 * @studyEndDate
 */
public class problem10430 {
	/* ====================================
	예제 입력
	5 8 4
	
	예제 출력
	1
	1
	0
	0
	==================================== */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Integer a = scanner.nextInt();
		Integer b = scanner.nextInt();
		Integer c = scanner.nextInt();
		scanner.close();
		
		System.out.println( (a+b)%c );
		System.out.println( ((a%c) + (b%c))%c );
		System.out.println( (a*b)%c );
		System.out.println( ((a%c) * (b%c))%c );
	}
}