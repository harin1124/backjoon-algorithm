package backjoon;

import java.util.Scanner;

/**
 * @title �� �� ���ϱ�
 * @desc �� ���� A�� B�� �־����� ��, A�� B�� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * @input ù° �ٿ� A�� B�� �־�����. A�� B�� ���� �� ĭ���� ���еǾ��� �ִ�.
 * @output ù° �ٿ� ���� �� ���� �� �ϳ��� ����Ѵ�.<br>
		   A�� B���� ū ��쿡�� '>'�� ����Ѵ�.<br>
		   A�� B���� ���� ��쿡�� '<'�� ����Ѵ�.<br>
		   A�� B�� ���� ��쿡�� '=='�� ����Ѵ�.
 * @studyStartDate 2022-01-16
 * @studyEndDate 2022-01-16
 */
public class problem1330 {
	/* ====================================
	���� �Է�
	1 2
	10 2
	5 5
	
	���� ���
	<
	>
	==
	==================================== */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Integer a = scanner.nextInt();
		Integer b = scanner.nextInt();
		scanner.close();
		
		if(a < b){
			System.out.println("<");
		}else if(a > b){
			System.out.println(">");
		}else{
			System.out.println("==");
		}
	}
}