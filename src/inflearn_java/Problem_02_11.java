package inflearn_java;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * @title 11. 임시반장 정하기
 * @desc 김갑동 선생님은 올해 6학년 1반 담임을 맡게 되었다.<br>
 *        김갑동 선생님은 우선 임시로 반장을 정하고 학생들이 서로 친숙해진 후에 정식으로 선거를 통해 반장을 선출하려고 한다.<br>
 *        그는 자기반 학생 중에서 1학년부터 5학년까지 지내오면서 한번이라도 같은 반이었던 사람이 가장 많은 학생을 임시 반장으로 정하려 한다.<br>
 *        그래서 김갑동 선생님은 각 학생들이 1학년부터 5학년까지 몇 반에 속했었는지를 나타내는 표를 만들었다.<br>
 *        예를 들어 학생 수가 5명일 때의 표를 살펴보자.<br>
 *        위 경우에 4번 학생을 보면 3번 학생과 2학년 때 같은 반이었고, 3번 학생 및 5번 학생과 3학년 때 같은 반이었으며,<br>
 *        2번 학생과는 4학년 때 같은 반이었음을 알 수 있다. 그러므로 이 학급에서 4번 학생과 한번이라도<br>
 *        같은 반이었던 사람은 2번 학생, 3번 학생과 5번 학생으로 모두 3명이다.<br>
 *        이 예에서 4번 학생이 전체 학생 중에서 같은 반이었던 학생 수가 제일 많으므로 임시 반장이 된다.<br>
 *        각 학생들이 1학년부터 5학년까지 속했던 반이 주어질 때, 임시 반장을 정하는 프로그램을 작성하시오.
 * @input 첫째 줄에는 반의 학생 수를 나타내는 정수가 주어진다. 학생 수는 3 이상 1000 이하이다.<br>
 *         둘째 줄부터는 1번 학생부터 차례대로 각 줄마다 1학년부터 5학년까지<br>
 *         몇 반에 속했었는지를 나타내는 5개의 정수가 빈칸 하나를 사이에 두고 주어진다.<br>
 *         주어지는 정수는 모두 1 이상 9 이하의 정수이다.
 * @output 첫 줄에 임시 반장으로 정해진 학생의 번호를 출력한다.<br>
 *          단, 임시 반장이 될 수 있는 학생이 여러 명인 경우에는 그 중 가장 작은 번호만 출력한다.
 * @studyStartDate 2023-01-22
 * @studyEndDate 2023-01-
 */
public class Problem_02_11 {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int size = Integer.parseInt(scan.nextLine());
		int[][] panel = new int[size][5];

		int x=0;
		int y=0;
		int k=0;
		for(x=0; x<size; x++){
			for(y=0; y<5; y++){
				panel[x][y] = scan.nextInt();
			}
		}

/*
3
5 4 4 2 1
1 2 3 4 5
1 2 3 7 8

5
2 3 1 7 3
4 1 9 6 8
5 5 2 4 4
6 5 2 6 7
8 4 2 2 2

5
9 8 7 6 5
5 6 7 8 9
1 2 3 7 8
4 5 3 4 2
6 2 8 4 2
*/
		int cnt=0;
		int[] result = new int[size];
		for(x=0; x<size; x++){
			for(y=0; y<5; y++){
				System.out.printf("panel[%d][%d] = %d", x, y, panel[x][y]);
				System.out.println();
				cnt=0;
				for(k=0; k<size; k++) {
					if(x != k){
						System.out.printf("\tpanel[%d][%d] = %d", k, y, panel[k][y]);
						System.out.println();
						if(panel[x][y] == panel[k][y]){
							cnt++;
						}
					}
				}
				System.out.println("\tcnt = "+cnt);
				if(cnt > 0){
					result[x]++;
					System.out.println("result["+x+"] = "+result[x]);
				}
				System.out.println("--------------------------------------------------");
			}
		}
		int maxCnt = 0;
		int maxCntIdx = 0;
		for(int u=0; u<size; u++){
			System.out.println((u+1)+"번째 학생의 겹친 반 수 : "+result[u]);
			if(result[u] > maxCnt){
				maxCnt = result[u];
				maxCntIdx = u;
			}
		}
		System.out.println();
		System.out.println("===================================================");
		bw.write((maxCntIdx+1)+"");
		bw.close();
		scan.close();
	}
}