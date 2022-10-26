package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @title 오븐 시계
 * @desc KOI 전자에서는 건강에 좋고 맛있는 훈제오리구이 요리를 간편하게 만드는 인공지능 오븐을 개발하려고 한다.<br>
 		 인공지능 오븐을 사용하는 방법은 적당한 양의 오리 훈제 재료를 인공지능 오븐에 넣으면 된다.<br>
 		 그러면 인공지능 오븐은 오븐구이가 끝나는 시간을 분 단위로 자동적으로 계산한다.<br> 
		 또한, KOI 전자의 인공지능 오븐 앞면에는 사용자에게 훈제오리구이 요리가 끝나는 시각을 알려 주는 디지털 시계가 있다.<br>
		 훈제오리구이를 시작하는 시각과 오븐구이를 하는 데 필요한 시간이 분단위로 주어졌을 때,<br>
		 오븐구이가 끝나는 시각을 계산하는 프로그램을 작성하시오.
 * @input 첫째 줄에는 현재 시각이 나온다.<br>
 		  현재 시각은 시 A (0 ≤ A ≤ 23) 와 분 B (0 ≤ B ≤ 59)가 정수로 빈칸을 사이에 두고 순서대로 주어진다.<br>
 		  두 번째 줄에는 요리하는 데 필요한 시간 C (0 ≤ C ≤ 1,000)가 분 단위로 주어진다.
 * @output 첫째 줄에 종료되는 시각의 시와 분을 공백을 사이에 두고 출력한다.<br>
 		   (단, 시는 0부터 23까지의 정수, 분은 0부터 59까지의 정수이다.<br>
 		   디지털 시계는 23시 59분에서 1분이 지나면 0시 0분이 된다.)
 * @studyStartDate 2022-07-12
 * @studyEndDate 2022-07-18
 */
public class Problem2525 {
	/* ====================================
	예제 입력
	14 30
	20
	
	예제 출력
    14 50
	==================================== */ 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] nowTime = br.readLine().split(" ");
		int nowTimeH = Integer.valueOf(nowTime[0]);
		int nowTimeM = Integer.valueOf(nowTime[1]);
		int cookTime = Integer.valueOf(br.readLine());
		br.close();
		
		// 더해야되는 시간과 분 구하기
		int addTime = cookTime + nowTimeM;
		System.out.println("더할 시간 : "+addTime);
		int addTimeH = (addTime / 60);
		int addTimeM = (addTime % 60);
		
		System.out.println("+ 시간 : "+addTimeH+"시간 "+addTimeM+"분");
		
		// addTime이 60보다 크면 1시간 더하기
		System.out.println("addTimeM + nowTimeM = "+addTimeM);
		if(60 <= addTimeM){
			System.out.println("60보다 커서 진입");
			addTimeH++;
			addTimeM = addTimeM - 60;
		}
		// 분 계산은 끝
		
		addTimeH = addTimeH + nowTimeH;
		
		System.out.println("addTimeH : "+addTimeH);
		System.out.println("addTimeM : "+addTimeM);
		
		nowTimeH = (addTimeH % 24);
		nowTimeM = addTimeM;
		
		bw.write(nowTimeH+" "+nowTimeM);
		bw.close();
	}
}