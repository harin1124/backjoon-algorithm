package backjoon;

import java.io.IOException;
import java.util.Scanner;

/**
 * @title 별 찍기 - 2
 * @desc 정수 N개로 이루어진 수열 A와 정수 X가 주어진다. 이때, A에서 X보다 작은 수를 모두 출력하는 프로그램을 작성하시오.
 * @input 첫째 줄에 N과 X가 주어진다. (1 ≤ N, X ≤ 10,000)<br>
		  둘째 줄에 수열 A를 이루는 정수 N개가 주어진다. 주어지는 정수는 모두 1보다 크거나 같고, 10,000보다 작거나 같은 정수이다.
 * @output X보다 작은 수를 입력받은 순서대로 공백으로 구분해 출력한다. X보다 작은 수는 적어도 하나 존재한다.
 * @studyStartDate 2022-01-18
 * @studyEndDate 2022-01-18
 */
public class problem10871 {
	/* ====================================
	예제 입력
	10 5
	1 10 4 9 2 3 8 5 7 6
	
	예제 출력
	1 4 2 3
	==================================== */ 
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		
		int size = scan.nextInt();
		int target = scan.nextInt();
		int num;
		String result = "";
		for(int i=0; i<size; i++){
			num = scan.nextInt();
			if(num < target){
				result = result + num + " ";
			}
		}
		scan.close();
		System.out.println(result);
	}
}