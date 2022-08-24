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
	static int row = 1;
	static int col = 1;
	static int moveCnt = 1;

	public static void GetPos(String arrow){ //→
		System.out.println("\t["+arrow+"] action after = [row="+row+" col="+col+"]");
	}
	public static void GetMoveCnt(){
		System.out.println("\t\tmoveCnt="+moveCnt);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//int num = Integer.valueOf(br.readLine());
		int num = 14;
		int temp = 0;
		br.close();

		if(num==1){
			System.out.println("1/1");
		}else{
			while(true){
				// 1. 수평이동
				col = col+1;
				row = row==0 ? 1 : row;
				moveCnt++;
				GetPos("→");
				GetMoveCnt();
				if(moveCnt == num){
					break;
				}

				// 2. 좌측 아래 대각선 이동
				if(moveCnt+(col-row) > num){
					System.out.println("\t\t if");
					//n번만큼 row 증가
					//n번만큼 col 감소
					row = row+(num-moveCnt);
					col = col-(num-moveCnt);
					break; //동일하기 때문에
				}else{
					System.out.println("\t\t else");
					moveCnt = moveCnt+(col-row);
					temp = row;
					row = col;
					col = temp;
				}

				GetPos("↙");
				GetMoveCnt();
				if(moveCnt == num){
					break;
				}

				// 3. 수직 이동
				row = row+1;
				moveCnt++;
				GetPos("↓");
				GetMoveCnt();


				// 4. 우측 위 대각선이동
				if(moveCnt+(row-col) > num){
					System.out.println("\t\t if");
					//n번만큼 row 감소
					//n번만큼 col 증가
					row = row-(num-moveCnt);
					col = col+(num-moveCnt);
					break; //동일하기 때문에
				}else{
					System.out.println("\t\t else");
					moveCnt = moveCnt+(row-col);
					temp = row;
					row = col;
					col = temp;
				}
				GetPos("↗");
				GetMoveCnt();
				if(moveCnt == num){
					break;
				}

			}
			System.out.println(row+"/"+col);
		}
	}
}