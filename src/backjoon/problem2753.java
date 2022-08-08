package backjoon;

import java.util.Scanner;

/**
 * @title 윤년
 * @desc 연도가 주어졌을 때, 윤년이면 1, 아니면 0을 출력하는 프로그램을 작성하시오.<br>
		 윤년은 연도가 4의 배수이면서, 100의 배수가 아닐 때 또는 400의 배수일 때이다.<br>
		 예를 들어, 2012년은 4의 배수이면서 100의 배수가 아니라서 윤년이다.<br>
		 1900년은 100의 배수이고 400의 배수는 아니기 때문에 윤년이 아니다.<br>
		 하지만, 2000년은 400의 배수이기 때문에 윤년이다.
 * @input 첫째 줄에 연도가 주어진다. 연도는 1보다 크거나 같고, 4000보다 작거나 같은 자연수이다.
 * @output 첫째 줄에 윤년이면 1, 아니면 0을 출력한다.
 * @studyStartDate 2022-01-16
 * @studyEndDate 2022-01-16
 */
public class problem2753 {
	/* ====================================
	예제 입력
	2000
	1999
	
	예제 출력
	1
	0
	==================================== */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Integer year = 1999;
		scanner.close();
		
		//윤년은 1 아니면 0
		if((year%4 == 0 && year % 100 != 0) || year % 400 == 0){ //4의 배수 && (100의 배수가 아님 || 400의 배수)
			System.out.println(1);
		}else{
			System.out.println(0);
		}
		
		
		
	}
}