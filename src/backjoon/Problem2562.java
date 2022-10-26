package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @title 최댓값
 * @desc 9개의 서로 다른 자연수가 주어질 때, 이들 중 최댓값을 찾고 그 최댓값이 몇 번째 수인지를 구하는 프로그램을 작성하시오.<br>
		 예를 들어, 서로 다른 9개의 자연수 3, 29, 38, 12, 57, 74, 40, 85, 61 이 주어지면,<br>
		 이들 중 최댓값은 85이고, 이 값은 8번째 수이다.
 * @input 첫째 줄부터 아홉 번째 줄까지 한 줄에 하나의 자연수가 주어진다. 주어지는 자연수는 100 보다 작다.
 * @output 첫째 줄에 최댓값을 출력하고, 둘째 줄에 최댓값이 몇 번째 수인지를 출력한다.
 * @studyStartDate 2022-07-22
 * @studyEndDate 2022-07-22
 */
public class Problem2562 {
	/* ====================================
	예제 입력
	3
	29
	38
	12
	57
	74
	40
	85
	61
	예제 출력
	85
	8
	==================================== */ 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n;
		Integer[] result = new Integer[2];
		result[0] = 0;
		result[1] = 0;
		for(int i=0; i<9; i++){
			n = Integer.valueOf(br.readLine());
			if(result[0] <= n){
				result[0] = n;
				result[1] = i+1;
			}
		}
		br.close();
		System.out.println(result[0]);
		System.out.println(result[1]);
	}
}
