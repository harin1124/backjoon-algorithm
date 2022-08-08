package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * @title 나머지
 * @desc 두 자연수 A와 B가 있을 때, A%B는 A를 B로 나눈 나머지 이다.<br>
		 예를 들어, 7, 14, 27, 38을 3으로 나눈 나머지는 1, 2, 0, 2이다. 
		 수 10개를 입력받은 뒤, 이를 42로 나눈 나머지를 구한다.<br>
		 그 다음 서로 다른 값이 몇 개 있는지 출력하는 프로그램을 작성하시오.
 * @input 첫째 줄부터 열번째 줄 까지 숫자가 한 줄에 하나씩 주어진다.<br>
		  이 숫자는 1,000보다 작거나 같고, 음이 아닌 정수이다.
 * @output 첫째 줄에, 42로 나누었을 때, 서로 다른 나머지가 몇 개 있는지 출력한다.
 * @studyStartDate 2022-07-26
 * @studyEndDate 2022-07-26
 */
public class problem3052 {
	/* ====================================
	예제 입력
	1
	2
	3
	4
	5
	6
	7
	8
	9
	10
	
	예제 출력
	10
	==================================== */
	public static void main(String[] args) throws Exception {
		// Garbage Collection으로 메모리 초기화
		Runtime.getRuntime().gc();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		int n = 0;
		for(int i=0; i<10; i++){
			n = Integer.valueOf(br.readLine()) % 42;
			if(map.containsKey(n)){
				map.put(n, map.get(n)+1);
			}else{
				map.put(n, 1);
			}
		}
		br.close();
		
		//System.out.println("map : "+map);
		System.out.println(map.size());
		
		long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		System.out.println("used memory is " + used + " bytes");

		//used memory is 651312 bytes
	}
}