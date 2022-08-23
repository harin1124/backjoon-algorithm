package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @title 분수찾기
 * @desc 무한히 큰 배열에 다음과 같이 분수들이 적혀있다.<br>
         1/1  1/2  1/3  1/4  1/5  …<br>
         2/1  2/2  2/3	2/4  …    …<br>
         3/1  3/2  3/3  …    …    …<br>
         4/1  4/2  …    …	 …    …<br>
         5/1  …    …    …    …    …<br>
         …    …    …    …    …    …<br>
         이와 같이 나열된 분수들을 1/1 → 1/2 → 2/1 → 3/1 → 2/2 → … 과 같은 지그재그 순서로 차례대로 1번, 2번, 3번, 4번, 5번, … 분수라고 하자.<br>
         X가 주어졌을 때, X번째 분수를 구하는 프로그램을 작성하시오.
 * @input 첫째 줄에 X(1 ≤ X ≤ 10,000,000)가 주어진다.
 * @output 첫째 줄에 분수를 출력한다.
 * @studyStartDate 2022-08-22
 * @studyEndDate 2022-08-
 */
public class problem1193 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//int num = Integer.valueOf(br.readLine());
		int num = 9;
		br.close();

		int row = 0;
		int col = 0;

		int a = 0;  // 수평 -> 이동
		int b = 0;  // 좌측 아래 대각선 이동
		int c = 0;  // 수직 이동
		int d = 0;  // 우측 위 대각선 이동

		int 몫 = num / 4;
		int 나머지 = num % 4;

		몫 = 2;
		나머지 = 2;

		System.out.println("몫 : "+몫);
		System.out.println("나머지 : "+나머지);

		if(몫 == 0){
			// 작게 나오면 어떻게해야 하나...?
			if(나머지 <= 1){
				a++;
			}
			if(나머지 <= 2){
				b = b+2;
			}
			if(나머지 <= 3){
				c++;
			}
		}else{
			// 몫 구하기
			a = 몫;
			c = 몫;

			b = 몫 * 몫; // 몫은 4라는 것으로 16까지 숫자 얻어내기
			d = b + 몫;

			System.out.println("=====================");
			System.out.println("a : "+a);
			System.out.println("b : "+b);
			System.out.println("c : "+c);
			System.out.println("d : "+d);

			if(나머지 > 0){
				if(나머지 >= 1){
					a++;
				}
				if(나머지 >= 2){
					b = b+2;
				}
				if(나머지 >= 3){
					c++;
				}
			}
			System.out.println("=====================");
			System.out.println("a : "+a);
			System.out.println("b : "+b);
			System.out.println("c : "+c);
			System.out.println("d : "+d);

			col = 1 + a + b - d;
			row = 1 + c + d - b;



			System.out.println("최종 결과 =====================");
			System.out.println("a : "+a);
			System.out.println("b : "+b);
			System.out.println("c : "+c);
			System.out.println("d : "+d);
		}

		System.out.println(row+"/"+col);
	}
}