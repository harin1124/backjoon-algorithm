package backjoon;

import java.util.Scanner;

/**
 * @title ����
 * @desc (A+B)%C�� ((A%C) + (B%C))%C �� ������?<br>
		 (A��B)%C�� ((A%C) �� (B%C))%C �� ������?<br>
		 �� �� A, B, C�� �־����� ��, ���� �� ���� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * @studyStartDate 2022-01-15
 * @studyEndDate
 */
public class Problem10430 {
	/* ====================================
	���� �Է�
	5 8 4
	
	���� ���
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