package inflearn_java;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @title 6. 공주 구하기
 * @desc 정보 왕국의 이웃 나라 외동딸 공주가 숲속의 괴물에게 잡혀갔습니다.<br>
 * 정보 왕국에는 왕자가 N명이 있는데 서로 공주를 구하러 가겠다고 합니다.<br>
 * 정보왕국의 왕은 다음과 같은 방법으로 공주를 구하러 갈 왕자를 결정하기로 했습니다.<br>
 * 왕은 왕자들을 나이 순으로 1번부터 N번까지 차례로 번호를 매긴다.<br>
 * 그리고 1번 왕자부터 N번 왕자까지 순서대로 시계 방향으로 돌아가며 동그랗게 앉게 한다.<br>
 * 그리고 1번 왕자부터 시계방향으로 돌아가며 1부터 시작하여 번호를 외치게 한다.<br>
 * 한 왕자가 K(특정숫자)를 외치면 그 왕자는 공주를 구하러 가는데서 제외되고 원 밖으로 나오게 된다.<br>
 * 그리고 다음 왕자부터 다시 1부터 시작하여 번호를 외친다.<br>
 * 이렇게 해서 마지막까지 남은 왕자가 공주를 구하러 갈 수 있다.<br>
 * 예를 들어 총 8명의 왕자가 있고, 3을 외친 왕자가 제외된다고 하자. 처음에는 3번 왕자가 3을 외쳐 제외된다.<br>
 * 이어 6, 1, 5, 2, 8, 4번 왕자가 차례대로 제외되고 마지막까지 남게 된 7번 왕자에게 공주를 구하러갑니다.<br>
 * N과 K가 주어질 때 공주를 구하러 갈 왕자의 번호를 출력하는 프로그램을 작성하시오.
 * @input 첫 줄에 자연수 N(5<=N<=1,000)과 K(2<=K<=9)가 주어진다.
 * @output 첫 줄에 마지막 남은 왕자의 번호를 출력합니다.
 * @studyStartDate 2023-03-05
 * @studyEndDate 2023-03-05
 */
public class Problem_05_06 {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int princes = scan.nextInt();
		int num = scan.nextInt();
		int i = 0;

		Queue<Integer> q = new LinkedList<>();
		for(i=1; i<=princes; i++){
			q.add(i);
		}

		i=1;
		while(true){
			// 하나만 남았을 때, 왕자의 번호를 출력하기 위해 while문을 종료한다.
			if(q.size() == 1){
				break;
			} else {
				// 왕자 번호와 num이 같으면, 해당 왕자는 제외한다.
				// 초기화하기 위해서 카운트를 1로 초기화한다. 또 큐에서 첫 번째 값을 제거한다.
				if(i == num){
					i = 1;
					q.poll();
				} else {
					// 카운트를 1 증가하고, 큐에 현재 큐의 맨 앞에 값을 뒤에 넣어준다.
					// 그리고 큐의 맨 앞 값은 제거한다.
					i++;
					q.add(q.peek());
					q.poll();
				}
			}
		}
		bw.write(q.peek()+"");
		bw.close();
		scan.close();
	}
}