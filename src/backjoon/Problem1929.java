package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @title 소수 구하기
 * @desc M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.
 * @input 첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다.<br>
           (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.
 * @output 한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.
 * @studyStartDate 2022-10-30
 * @studyEndDate 2022-10-
 */
public class Problem1929 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer numbers = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(numbers.nextToken());
		int b = Integer.parseInt(numbers.nextToken());

		if(a == 1 && b == 1){
			return;
		}
		if(a == 1 && b == 2){
			bw.write("2");
			return;
		}

		boolean primeChecker = true;

		for(int i=a; i<=b; i++){
			// i가 소수인지 확인
			System.out.println(i+"가 소수인지 확인");
			for(int j=1; j<=i; j++){
				System.out.println("\t"+j+"로 나누어지는지 확인");
				if(i%j == 0 && j!=1 && i!=j){
					primeChecker = false;
					break;
				}
			}
			if(primeChecker){
				bw.write(i+"\n");
			}
			primeChecker = true;
		}

		br.close();
		bw.close();
	}
}