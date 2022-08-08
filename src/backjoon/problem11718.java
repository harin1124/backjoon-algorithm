package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @title 나머지
 * @desc 입력 받은 대로 출력하는 프로그램을 작성하시오.
 * @input 입력이 주어진다. 입력은 최대 100줄로 이루어져 있고, 알파벳 소문자, 대문자, 공백, 숫자로만 이루어져 있다.<br>
		  각 줄은 100글자를 넘지 않으며, 빈 줄은 주어지지 않는다.<br>
		  또, 각 줄은 공백으로 시작하지 않고, 공백으로 끝나지 않는다.
 * @output 입력받은 그대로 출력한다.
 * @studyStartDate 2022-07-26
 * @studyEndDate 2022-07-26
 */
public class problem11718 {
	public static void main(String[] args) throws Exception {
		// Garbage Collection으로 메모리 초기화
		Runtime.getRuntime().gc();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = "";
		while(true){
			s = br.readLine();
			if(s==null || "".equals(s)){
				break;
			}
			System.out.println(s);
		}
		
		long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		System.out.println("used memory is " + used + " bytes");

		//used memory is 651312 bytes
	}
}