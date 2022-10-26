package backjoon;

import java.util.Scanner;

/**
 * @title 두 수 비교하기
 * @desc 두 정수 A와 B가 주어졌을 때, A와 B를 비교하는 프로그램을 작성하시오.
 * @input 첫째 줄에 A와 B가 주어진다. A와 B는 공백 한 칸으로 구분되어져 있다.
 * @output 첫째 줄에 다음 세 가지 중 하나를 출력한다.<br>
		   A가 B보다 큰 경우에는 '>'를 출력한다.<br>
		   A가 B보다 작은 경우에는 '<'를 출력한다.<br>
		   A와 B가 같은 경우에는 '=='를 출력한다.
 * @studyStartDate 2022-01-16
 * @studyEndDate 2022-01-16
 */
public class Problem1330 {
	/* ====================================
	예제 입력
	1 2
	10 2
	5 5
	
	예제 출력
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