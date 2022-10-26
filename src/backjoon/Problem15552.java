package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @title 빠른 A+B
 * @desc 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
 * @input Java를 사용하고 있다면, Scanner와 System.out.println 대신<br>
		  BufferedReader와 BufferedWriter를 사용할 수 있다.<br>
		  BufferedWriter.flush는 맨 마지막에 한 번만 하면 된다.<br>
		  Python을 사용하고 있다면, input 대신 sys.stdin.readline을 사용할 수 있다.<br>
		  단, 이때는 맨 끝의 개행문자까지 같이 입력받기 때문에<br>
		  문자열을 저장하고 싶을 경우 .rstrip()을 추가로 해 주는 것이 좋다.
		  또한 입력과 출력 스트림은 별개이므로,<br>
		  테스트케이스를 전부 입력받아서 저장한 뒤 전부 출력할 필요는 없다.<br>
		  테스트케이스를 하나 받은 뒤 하나 출력해도 된다.
 * @output 각 테스트케이스마다 A+B를 한 줄에 하나씩 순서대로 출력한다.
 * @studyStartDate 2022-01-16
 * @studyEndDate 2022-01-16
 */
public class Problem15552 {
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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T=Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++){
			st=new StringTokenizer(br.readLine());
			bw.write((Integer.parseInt(st.nextToken())) + Integer.parseInt(st.nextToken())+"\n");
		}
		bw.close();
	}
}