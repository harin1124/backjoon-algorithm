package inflearn_java;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.*;

/**
 * @title 3. 크레인 인형뽑기(카카오)
 * @desc 크레인을 모두 작동시킨 후 터트려져 사라진 인형의 개수를 구하는 프로그램을 작성하세요.
 * @input
 * @output 첫 줄에 터트려져 사라진 인형의 개수를 출력합니다.
 * @studyStartDate 2023-02-21
 * @studyEndDate 2023-02-
 */
public class Problem_05_03 {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Stack<Integer> basket = new Stack<>();
		int bomb = 0;

		int boardSize = scan.nextInt();
		int x = 0;
		int y = 0;

		int[][] board = new int[boardSize][boardSize];
		for(x=0; x<boardSize; x++){
			for(y=0; y<boardSize; y++){
				board[x][y] = scan.nextInt();
			}
		}

		int[] moves = new int[scan.nextInt()];
		for(x=0; x<moves.length; x++){
			moves[x] = scan.nextInt();
		}

		int selectCol = 0;
		for(x=0; x<moves.length; x++){
			selectCol = moves[x]-1;
			for(y=0; y<boardSize; y++){
				if(board[y][selectCol] > 0){
					// basket이 비어있지 않다면, 이전값과 현재 값이 같은지 확인
					if(!basket.isEmpty()){
						// basket에서 꺼낸 값과 현재 집은 값이 같으면 바구니에서 터져야 한다. (즉 pop 처리)
						if(basket.peek() == board[y][selectCol]){
							basket.pop();
							bomb = bomb + 2;
						} else {
							basket.push(board[y][selectCol]);
						}
					} else {
						basket.push(board[y][selectCol]);
					}
					// 넣은 다음에는 0으로 만들어주어야 함
					board[y][selectCol] = 0;
					break;
				}
			}
		}
		bw.write(bomb+"");
		bw.close();
		scan.close();
	}
}