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
		int num = 6;
		br.close();

		int row = 1;
		int col = 1;

		// ->  col++
		// /   row++ col--
		// \   row-- col++
		// |   row++ col

		// 패턴
		// -> 1 / 1

		System.out.println(num);

		int 몫 = num / 4;
		int 나머지 = num % 4;

		System.out.println("몫 : "+몫);
		System.out.println("나머지 : "+나머지);

		// -> 방향
		col = col + 6;
		// /
		//row =

		System.out.println(row+"/"+col);
	}
}