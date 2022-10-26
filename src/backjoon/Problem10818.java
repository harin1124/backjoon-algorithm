package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @title 최소, 최대
 * @desc N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.
 * @input 첫째 줄에 정수의 개수 N (1 ≤ N ≤ 1,000,000)이 주어진다.<br>
		  둘째 줄에는 N개의 정수를 공백으로 구분해서 주어진다.<br>
		  모든 정수는 -1,000,000보다 크거나 같고, 1,000,000보다 작거나 같은 정수이다.
 * @output 첫째 줄에 주어진 정수 N개의 최솟값과 최댓값을 공백으로 구분해 출력한다.
 * @studyStartDate 2022-07-21
 * @studyEndDate 2022-07-21
 */
public class Problem10818 {
	/* ====================================
	예제 입력
	5
	20 10 35 30 7
	
	예제 출력
    7 35
	==================================== */ 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 문자열 배열을 숫자 배열로 변환
		String[] sList = new String[Integer.valueOf(br.readLine())];
		sList = br.readLine().split(" ");
		br.close();
		
		Integer [] resultNum = new Integer[2];
		resultNum[0] = 1000000; //최솟값
		resultNum[1] = -1000000; //최댓값
		
		Integer n = 0;
		for(int i=0; i<sList.length; i++){
			n = Integer.valueOf(sList[i]);
			if(resultNum[0] >= n){
				resultNum[0] = n;
			}
			if(resultNum[1] <= n){
				resultNum[1] = n;
			}
		}
		
		bw.write(resultNum[0]+" "+resultNum[1]);
		
		bw.close();
	}
}
