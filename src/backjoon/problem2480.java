package backjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * @title 주사위 세개
 * @desc 1에서부터 6까지의 눈을 가진 3개의 주사위를 던져서 다음과 같은 규칙에 따라 상금을 받는 게임이 있다.<br>
		 같은 눈이 3개가 나오면 10,000원+(같은 눈)×1,000원의 상금을 받게 된다.<br>
		 같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)×100원의 상금을 받게 된다.<br>
		 모두 다른 눈이 나오는 경우에는 (그 중 가장 큰 눈)×100원의 상금을 받게 된다.<br>
		 예를 들어, 3개의 눈 3, 3, 6이 주어지면 상금은 1,000+3×100으로 계산되어 1,300원을 받게 된다.<br>
		 또 3개의 눈이 2, 2, 2로 주어지면 10,000+2×1,000 으로 계산되어 12,000원을 받게 된다.<br>
		 3개의 눈이 6, 2, 5로 주어지면 그중 가장 큰 값이 6이므로 6×100으로 계산되어 600원을 상금으로 받게 된다.<br>
		 3개 주사위의 나온 눈이 주어질 때, 상금을 계산하는 프로그램을 작성 하시오.
 * @input 첫째 줄에 3개의 눈이 빈칸을 사이에 두고 각각 주어진다.
 * @output 첫째 줄에 게임의 상금을 출력 한다.
 * @studyStartDate 2022-07-19
 * @studyEndDate 2022-07-
 */
public class problem2480 {
	/* ====================================
	예제 입력		출력
	3 3 6			1300
	2 2 2			12000
	6 2 5			600
	==================================== */ 
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] n = new int[3];
		n[0] = s.nextInt();
		n[1] = s.nextInt();
		n[2] = s.nextInt();
		s.close();
		
		System.out.println("n[0]="+n[0]+"  n[1]="+n[1]+"  n[2]="+n[2]);

		// 모든 수 같은 거 찾기 if문 사용 해결
		if(n[0] == n[1] && n[1] == n[2] && n[0] == n[2]){
			//10,000원+(같은 눈)×1,000
			bw.write(10000+(n[0] * 1000)+"");
		}else{
			//두 수가 같음 | 1,000원+(같은 눈)×100
			if(n[0] == n[1]){
				bw.write(1000+(n[0] * 100)+"");
			}else if(n[1] == n[2]){
				bw.write(1000+(n[1] * 100)+"");
			}else if(n[0] == n[2]){
				bw.write(1000+(n[0] * 100)+"");
				System.out.println();
			}else{
				//모두 다른 수
				int maxNum = n[0];
				if(maxNum <= n[1]){
					maxNum = n[1];
				}
				if(maxNum <= n[2]){
					maxNum = n[2];
				}
				//(그 중 가장 큰 눈)×100
				bw.write((maxNum * 100)+"");
			}
		}
		
		bw.close();
		
	}
}