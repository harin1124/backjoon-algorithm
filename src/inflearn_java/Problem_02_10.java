package inflearn_java;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * @title 10. 봉우리
 * @desc 지도 정보가 N*N 격자판에 주어집니다. 각 격자에는 그 지역의 높이가 쓰여있습니다.<br>
 *        각 격자판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역입니다. 봉우리 지역이 몇 개 있는 지 알아내는 프로그램을 작성하세요.<br>
 *        격자의 가장자리는 0으로 초기화 되었다고 가정한다.<br>
 *        만약 N=5 이고, 격자판의 숫자가 다음과 같다면 봉우리의 개수는 10개입니다.
 * @input 첫 줄에 자연수 N이 주어진다.(2<=N<=50)<br>
 *         두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.
 * @output 봉우리의 개수를 출력하세요.
 * @studyStartDate 2023-01-21
 * @studyEndDate 2023-01-21
 */
public class Problem_02_10 {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int size = Integer.parseInt(scan.nextLine());
		int[][] panel = new int[size][size];

		int x=0;
		int y=0;
		for(x=0; x<size; x++){
			for(y=0; y<size; y++){
				panel[x][y] = scan.nextInt();
			}
		}
		int num = 0;
		boolean chk = true;
		int cnt = 0;
		for(x=0; x<size; x++){
			for(y=0; y<size; y++){
				chk = true;
				num = panel[x][y];
				if(x == 0){
					if(y == 0){
						// 오른쪽 && 아래 확인
						if(panel[x][y+1] >= num || panel[x+1][y] >= num){
							chk = false;
						}
					} else if(y == size-1){
						// 왼쪽 && 아래 확인
						if(panel[x][y-1] >= num || panel[x+1][y] >= num){
							chk = false;
						}
					} else {
						// 왼쪽 && 오른쪽 && 아래 확인
						if(panel[x][y-1] >= num || panel[x][y+1] >= num || panel[x+1][y] >= num){
							chk = false;
						}
					}
				} else if(x == size-1){
					if(y == 0){
						// 오른쪽 && 위 확인
						if(panel[x][y+1] >= num || panel[x-1][y] >= num){
							chk = false;
						}
					} else if(y == size-1){
						// 왼쪽 && 위 확인
						if(panel[x][y-1] >= num || panel[x-1][y] >= num){
							chk = false;
						}
					} else {
						// 왼쪽 && 오른쪽 && 위 확인
						if(panel[x][y-1] >= num || panel[x][y+1] >= num || panel[x-1][y] >= num){
							chk = false;
						}
					}
				} else {
					if(y == 0){
						// 오른쪽 && 위 && 아래 확인
						if(panel[x][y+1] >= num || panel[x-1][y] >= num || panel[x+1][y] >= num){
							chk = false;
						}
					} else if(y == size-1){
						// 왼쪽 && 위 && 아래 확인
						if(panel[x][y-1] >= num || panel[x-1][y] >= num || panel[x+1][y] >= num){
							chk = false;
						}
					} else {
						// 왼쪽 && 오른쪽 && 위 && 아래 확인
						if(panel[x][y-1] >= num || panel[x][y+1] >= num || panel[x-1][y] >= num || panel[x+1][y] >= num){
							chk = false;
						}
					}
				}
				if(chk){
					cnt++;
				}
			}
		}
		bw.write(cnt+"");
		bw.close();
		scan.close();
	}
}