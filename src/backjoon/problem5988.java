package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @title 홀수일까 짝수일까
 * @desc 짝이 없는 경재는 매일 홀로 있다보니 홀수를 판별할 수 있는 능력이 생겼다.<br>
 		 창식이는 경재의 말이 사실인지 그 능력을 시험해보려 한다.<br>
 		 창식이의 의심이 끝이 없을 것 같아 N개만 확인하기로 정했다.
 		 N개의 정수가 주어지면 홀수인지 짝수인지를 출력하는 프로그램을 만들어 경재의 능력을 검증할 수 있게 도와주자.
 * @input 첫 번째 줄에 숫자의 개수 N(1 <= N <= 100)이 주어진다.<br>
		  두 번째 줄부터 N+1번째 줄에 걸쳐 홀수인지 짝수인지 확인할 정수 K (1 &lt;= K &lt;= 10^60)가 주어진다.
 * @output N개의 줄에 걸쳐 한 줄씩 정수 K가 홀수라면 'odd'를, 짝수라면 'even'을 출력한다.
 * @studyStartDate 2022-08-01
 * @studyEndDate 2022-08-01
 */
public class problem5988 {
	/* ====================================
	예제 입력
	2
	1024
	5931
	
	예제 출력
	even
	odd
	==================================== */
	public static void main(String[] args)throws Exception{
		// Garbage Collection으로 메모리 초기화
		Runtime.getRuntime().gc();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int size = Integer.valueOf(br.readLine());
		String[] x = null;
		for(int i=0; i<size; i++){
			x = br.readLine().split("");
			System.out.println((Integer.valueOf(x[x.length-1]) % 2) == 0 ? "even" : "odd");
		}
		br.close();
		
		long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		System.out.println("used memory is " + used + " bytes");
		
		// 결과 30 OOOOXOOOOXOOOOX => 651368 bytes // 651344
	}
}
