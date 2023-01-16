package inflearn_java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @title 3. 가위 바위 보
 * @desc A, B 두 사람이 가위바위보 게임을 합니다.<br>
 *       총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다.<br>
 *       비길 경우에는 D를 출력합니다.<br>
 *       가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다.<br>
 *       두 사람의 각 회의 가위, 바위, 보 정보가 주어지면 각 회를 누가 이겼는지 출력하는 프로그램을 작성하세요.
 * @input 첫 번째 줄에 게임 횟수인 자연수 N(1<=N<=100)이 주어집니다.<br>
 *        두 번째 줄에는 A가 낸 가위, 바위, 보 정보가 N개 주어집니다.<br>
 *        세 번째 줄에는 B가 낸 가위, 바위, 보 정보가 N개 주어집니다.
 * @output 각 줄에 각 회의 승자를 출력합니다. 비겼을 경우는 D를 출력합니다.
 * @studyStartDate 2023-01-16
 * @studyEndDate 2023-01-16
 */
public class Problem_02_03_02 {
	public static void main(String[] args) throws Exception {
		// FOR문을 한 번만 사용하여 푸는 풀이
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int size = Integer.parseInt(br.readLine())*2;
		int result = 0;
		String a = br.readLine();
		String b = br.readLine();
		for(int i=0; i<size; i+=2){
			result = (int) a.charAt(i) - (int) b.charAt(i);
			if(result == 0){
				bw.write("D\n");
			} else if(result == 1 || result == -2){
				bw.write("A\n");
			} else if(result == 2 || result == -1){
				bw.write("B\n");
			}
		}
		bw.close();
		br.close();
	}
}