package inflearn_java;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * @title 6. 뒤집은 소수
 * @desc N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력하는 프로그램을 작성하세요.<br>
 *       예를 들어 32를 뒤집으면 23이고, 23은 소수이다. 그러면 23을 출력한다.<br>
 *       단 910를 뒤집으면 19로 숫자화 해야 한다.
 * 첫 자리부터의 연속된 0은 무시한다.
 * @input 첫 줄에 자연수의 개수 N(3<=N<=100)이 주어지고, 그 다음 줄에 N개의 자연수가 주어진다.<br>
 *        각 자연수의 크기는 100,000를 넘지 않는다.
 * @output 첫 줄에 뒤집은 소수를 출력합니다. 출력순서는 입력된 순서대로 출력합니다.
 * @studyStartDate 2023-01-18
 * @studyEndDate 2023-01-18
 */
public class Problem_02_06 {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int size = Integer.parseInt(scan.nextLine());
		int num;
		int temp;
		int j;
		boolean chk = true;
		for(int i=0; i<size; i++){
			// 숫자 뒤집기
			num = scan.nextInt();
			temp = 0;
			while(num != 0){
				temp = temp * 10 + num % 10;
				num /= 10;
			}
			num = temp;
			if(num > 1){
				// 소수 판별
				for(j=2; j<=num; j++){
					// 숫자를 하나씩 증가시켜 나눠서 나누어 떨어지는지 확인
					// 이 때, 나누어떨어지는 수는 num과 동일하지 않아야 한다.
					if(num != j && num % j == 0){
						chk = false;
						break;
					}
				}
			} else {
				chk = false;
			}
			// chk가 true이면 소수라는 의미이므로 출력할 수 있게 함
			if(chk){
				bw.write(num+" ");
			}
			chk = true;
		}
		scan.close();
		bw.close();
	}
}