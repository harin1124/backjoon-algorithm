package backjoon;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * @title 코딩은 체육과목 입니다
 * @desc 오늘은 혜아의 면접 날이다. 면접 준비를 열심히 해서 앞선 질문들을 잘 대답한 혜아는 이제 마지막으로 칠판에 직접 코딩하는 문제를 받았다.<br>
 * 혜아가 받은 문제는 두 수를 더하는 문제였다.<br>
 * C++ 책을 열심히 읽었던 혜아는 간단히 두 수를 더하는 코드를 칠판에 적었다.<br>
 * 코드를 본 면접관은 다음 질문을 했다. “만약, 입출력이 N바이트 크기의 정수라면 프로그램을 어떻게 구현해야 할까요?”<br>
 * 혜아는 책에 있는 정수 자료형과 관련된 내용을 기억해 냈다.<br>
 * 책에는 long int는 4바이트 정수까지 저장할 수 있는 정수 자료형이고 long long int는 8바이트 정수까지 저장할 수 있는 정수 자료형이라고 적혀 있었다.<br>
 * 혜아는 이런 생각이 들었다. “int 앞에 long을 하나씩 더 붙일 때마다 4바이트씩 저장할 수 있는 공간이 늘어나는 걸까?<br>
 * 분명 long long long int는 12바이트, long long long long int는 16바이트까지 저장할 수 있는 정수 자료형일 거야!”<br>
 * 그렇게 혜아는 당황하는 면접관의 얼굴을 뒤로한 채 칠판에 정수 자료형을 써 내려가기 시작했다.<br>
 * 혜아가 N바이트 정수까지 저장할 수 있다고 생각해서 칠판에 쓴 정수 자료형의 이름은 무엇일까?
 * @input 첫 번째 줄에는 문제의 정수 N이 주어진다. (4 <= N <= 1000; N은 4의 배수)
 * @output 혜아가 N바이트 정수까지 저장할 수 있다고 생각하는 정수 자료형의 이름을 출력하여라.
 * @studyStartDate 2025-07-12
 * @studyEndDate 2025-07-12
 */
public class Problem25314 {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = scan.nextInt();
		int value = n - 4;
		
		if(value == 0){
			bw.write("long int");
		} else {
			StringBuilder sb = new StringBuilder();
			int longCount = value / 4;
			for(int i = 0; i < longCount; i++){
				sb.append("long ");
			}
			sb.append("long int");
			bw.write(sb.toString());
		}
		
		bw.close();
		scan.close();
	}
}
