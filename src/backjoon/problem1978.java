package backjoon;

import java.io.*;
import java.util.Scanner;
/**
 * @title 소수 찾기
 * @desc 주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
 * @input 첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.
 * @output 주어진 수들 중 소수의 개수를 출력한다.
 * @studyStartDate 2022-10-17
 * @studyEndDate 2022-10-17
 */
public class problem1978 {
	public static void main(String[] args) throws Exception {
		// 메모리 절약을 위해 BufferedReader와 StringTokenizer 사용
		Scanner scan = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int size = Integer.parseInt(scan.nextLine());
		int resultCount = 0;
		int number = 0;
		boolean primeNumChecker = true;

		for(int i=0; i<size; i++){
			primeNumChecker = true;
			number = scan.nextInt();
			System.out.println(number+"의 소수 확인");
			if(number == 1){
				System.out.println("\t1은 소수가 아닙니다.");
				continue;
			} else {
				for(int j=1; j<=number; j++){
					System.out.println("\t"+j+"로 확인을 진행합니다.");
					if(number % j == 0 && j != 1 && number != j){
						System.out.println("\tj"+"로 나누었을 때, 나머지가 없으므로 소수가 아닙니다.");
						primeNumChecker = false;
						break;
					}
				}
			}

			if(primeNumChecker){
				resultCount++;
			}
		}
		bw.write(resultCount+"");

		scan.close();
		bw.close();

	}
}
