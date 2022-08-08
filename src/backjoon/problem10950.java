package backjoon;

import java.io.IOException;
import java.util.Scanner;

/**
 * @title A+B - 3
 * @desc 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
 * @input 첫째 줄에 테스트 케이스의 개수 T가 주어진다.<br>
		  각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다.<br>
		  (0 < A, B < 10)
 * @output 각 테스트 케이스마다 A+B를 출력한다.
 * @studyStartDate 2022-01-16
 * @studyEndDate 2022-01-16
 */
public class problem10950 {
	/* ====================================
	예제 입력
	5
	1 1
	2 3
	3 4
	9 8
	5 2
	
	예제 출력
	2
	5
	7
	17
	7
	==================================== */
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		Integer cnt = scan.nextInt();
		Integer[] result=new Integer[cnt];
		for(int i=0; i<cnt; i++){
			Integer a = scan.nextInt();
			Integer b = scan.nextInt();
			result[i]=a + b;
		}
		scan.close();
		for(int i=0; i<cnt; i++){
			System.out.println(result[i]);
		}
	}
}