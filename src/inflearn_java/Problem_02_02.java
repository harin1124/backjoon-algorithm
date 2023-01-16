package inflearn_java;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * @title 2. 보이는 학생
 * @desc 선생님이 N명의 학생을 일렬로 세웠습니다.<br>
 *       일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때,<br>
 *       맨 앞에 서 있는 선생님이 볼 수 있는 학생의 수를 구하는 프로그램을 작성하세요.<br>
 *       (앞에 서 있는 사람들보다 크면 보이고, 작거나 같으면 보이지 않습니다.)
 * @input 첫 줄에 정수 N(5<=N<=100,000)이 입력된다. 그 다음줄에 N명의 학생의 키가 앞에서부터 순서대로 주어진다.
 * @output 선생님이 볼 수 있는 최대학생수를 출력한다.
 * @studyStartDate 2023-01-16
 * @studyEndDate 2023-01-16
 */
public class Problem_02_02 {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int size = scan.nextInt();
		int nowHeight;
		int prevMaxHeight = 0;
		int cnt = 0;
		for(int i=0; i<size; i++){
			nowHeight = scan.nextInt();
			if(prevMaxHeight < nowHeight){
				cnt++;
				prevMaxHeight = nowHeight;
			}
		}
		bw.write(cnt+"");
		bw.close();
		scan.close();
	}
}