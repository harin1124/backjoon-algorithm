package backjoon;

import java.util.Scanner;

/**
 * @title ��Ģ����
 * @desc �� �ڿ��� A�� B�� �־�����.<br>
 * �̶�, A+B, A-B, A*B, A/B(��), A%B(������)�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�. 
 * @input ù° �ٿ� (1)�� ��ġ�� �� �� �ڸ� �ڿ�����, ��° �ٿ� (2)�� ��ġ�� �� ���ڸ� �ڿ����� �־�����.
 * @output ù° �ٺ��� ��° �ٱ��� ���ʴ�� (3), (4), (5), (6)�� �� ���� ����Ѵ�.
 * @studyStartDate 2022-01-15
 * @studyEndDate 2022-01-16
 */
public class Problem2588 {
	/* ====================================
	���� �Է�
	472
	385
	
	���� ���
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