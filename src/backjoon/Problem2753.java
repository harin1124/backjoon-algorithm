package backjoon;

import java.util.Scanner;

/**
 * @title ����
 * @desc ������ �־����� ��, �����̸� 1, �ƴϸ� 0�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.<br>
		 ������ ������ 4�� ����̸鼭, 100�� ����� �ƴ� �� �Ǵ� 400�� ����� ���̴�.<br>
		 ���� ���, 2012���� 4�� ����̸鼭 100�� ����� �ƴ϶� �����̴�.<br>
		 1900���� 100�� ����̰� 400�� ����� �ƴϱ� ������ ������ �ƴϴ�.<br>
		 ������, 2000���� 400�� ����̱� ������ �����̴�.
 * @input ù° �ٿ� ������ �־�����. ������ 1���� ũ�ų� ����, 4000���� �۰ų� ���� �ڿ����̴�.
 * @output ù° �ٿ� �����̸� 1, �ƴϸ� 0�� ����Ѵ�.
 * @studyStartDate 2022-01-16
 * @studyEndDate 2022-01-16
 */
public class Problem2753 {
	/* ====================================
	���� �Է�
	2000
	1999
	
	���� ���
	1
	0
	==================================== */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Integer year = 1999;
		scanner.close();
		
		//������ 1 �ƴϸ� 0
		if((year%4 == 0 && year % 100 != 0) || year % 400 == 0){ //4�� ��� && (100�� ����� �ƴ� || 400�� ���)
			System.out.println(1);
		}else{
			System.out.println(0);
		}
		
		
		
	}
}