package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @title A+B - 8
 * @desc 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
 * @input 첫째 줄에 테스트 케이스의 개수 T가 주어진다.
		  각 테스트 케이스는 한 줄로 이루어져 있으며,<br>
		  각 줄에 A와 B가 주어진다. (0 < A, B < 10)
 * @output 각 테스트 케이스마다 "Case #x: A + B = C" 형식으로 출력한다.<br>
		   x는 테스트 케이스 번호이고 1부터 시작하며, C는 A+B이다.
 * @studyStartDate 2022-01-16
 * @studyEndDate 2022-01-16
 */
public class Problem11022 {
	/* ====================================
	예제 입력
	5
	1 1
	2 3
	3 4
	9 8
	5 2
	
	예제 출력
	Case #1: 1 + 1 = 2
	Case #2: 2 + 3 = 5
	Case #3: 3 + 4 = 7
	Case #4: 9 + 8 = 17
	Case #5: 5 + 2 = 7
	==================================== */ 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T=Integer.parseInt(br.readLine());
		String[] l=new String[T];
		String a;
		Integer b;
		Integer c;
		for(int i=0; i<T; i++){
			a=br.readLine();
			b=Integer.valueOf(a.split(" ")[0]);
			c=Integer.valueOf(a.split(" ")[1]);
			l[i]=String.format("Case #%d: %d + %d = %d\n", i+1, b, c, b+c);
		}
		br.close();
		for(int i=0; i<T; i++){
			bw.write(l[i]);
		}
		bw.close();
	}
}