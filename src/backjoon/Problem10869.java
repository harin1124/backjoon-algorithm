package backjoon;

import java.util.Scanner;

/**
 * @title ��Ģ����
 * @desc �� �ڿ��� A�� B�� �־�����.<br>
 * �̶�, A+B, A-B, A*B, A/B(��), A%B(������)�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�. 
 * @input �� �ڿ��� A�� B�� �־�����. (1 �� A, B �� 10,000)
 * @output ù° �ٿ� A+B, ��° �ٿ� A-B, ��° �ٿ� A*B, ��° �ٿ� A/B, �ټ�° �ٿ� A%B�� ����Ѵ�.
 * @studyStartDate 2022-01-15
 * @studyEndDate 2022-01-15
 */
public class Problem10869 {
	/* ====================================
	���� �Է�
	7 3
	
	���� ���
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
		System.out.println(a/b); //A/B ��
		System.out.println(a%b); //A%B ������
		
	}
}