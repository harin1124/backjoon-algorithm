package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @title OX퀴즈
 * @desc OOXXOXXOOO"와 같은 OX퀴즈의 결과가 있다.<br>
		 O는 문제를 맞은 것이고, X는 문제를 틀린 것이다.<br>
		 문제를 맞은 경우 그 문제의 점수는 그 문제까지 연속된 O의 개수가 된다.<br>
		 예를 들어, 10번 문제의 점수는 3이 된다.<br>
		 "OOXXOXXOOO"의 점수는 1+2+0+0+1+0+0+1+2+3 = 10점이다.<br>
		 OX퀴즈의 결과가 주어졌을 때, 점수를 구하는 프로그램을 작성하시오.
 * @input 첫째 줄에 테스트 케이스의 개수가 주어진다.<br>
		  각 테스트 케이스는 한 줄로 이루어져 있고, 길이가 0보다 크고 80보다 작은 문자열이 주어진다.<br>
		  문자열은 O와 X만으로 이루어져 있다.
 * @output 각 테스트 케이스마다 점수를 출력한다.
 * @studyStartDate 2022-07-27
 * @studyEndDate 2022-07-27
 */
public class problem8958 {
	/* ====================================
	예제 입력
	5
	OOXXOXXOOO
	OOXXOOXXOO
	OXOXOXOXOXOXOX
	OOOOOOOOOO
	OOOOXOOOOXOOOOX
	
	예제 출력
	10
	9
	7
	55
	30
	==================================== */
	public static void main(String[] args)throws Exception{
		// Garbage Collection으로 메모리 초기화
		Runtime.getRuntime().gc();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] r = new String[Integer.valueOf(br.readLine())];
		int cnt = 0;
		int score = 0;
		for(int i=0, len=r.length; i<len; i++){
			r[i] = br.readLine();
			for(int j=0, l=r[i].length(); j<l; j++){
				if(String.valueOf(r[i].charAt(j)).equals("O")){
					if(cnt == 0){
						cnt++;
						score++;
					}else{
						score = score + cnt + 1;
						cnt++;
					}
				}else{
					cnt = 0;
				}
			}
			r[i] = String.valueOf(score);
			cnt = 0;
			score = 0;
		}
		br.close();
		
		for(String i : r){
			System.out.println(i);
		}
		
		
		
		long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		System.out.println("used memory is " + used + " bytes");
		
		// 결과 30 OOOOXOOOOXOOOOX => 651368 bytes // 651344
	}
}
