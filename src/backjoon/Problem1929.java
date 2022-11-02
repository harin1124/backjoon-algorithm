package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @title 소수 구하기
 * @desc M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.
 * @input 첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다.<br>
           (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.
 * @output 한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.
 * @studyStartDate 2022-10-30
 * @studyEndDate 2022-11-02
 */
public class Problem1929 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer numbers = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(numbers.nextToken());
		int b = Integer.parseInt(numbers.nextToken());
		int[] list = new int[b+1];
		int temp = 0;
		int j = 0;

		// 초기화
		for(temp=0; temp<=b; temp++){
			list[temp] = temp;
		}
		list[1] = 0;

		// 값 하나씩 살펴보기
		for(temp=2; temp<=b; temp++){
			// 0보다 큰 수만 반복문 조회한다.
			// 0이면, 이전 값(temp)으로 반복문 돌 때 temp의 배수여서 지워진 것 => 다시 확인할 필요 없다.
			if(list[temp] > 0){
				// temp=2일 경우, 2부터 4, 6, 8로 늘어나기 위해 j+temp로 값을 증가시킨다.
				for(j=temp; j<=b; j=j+temp){
					// j와 temp가 같지않다면, 즉 temp=2일때 2가 아닌 4, 6, 8을 0으로 만들기 위함이다.
					if(j != temp){
						list[j] = 0;
					}
				}
			}
		}

		// 최종 배열 확인 및 0이 아닌 수는 소수이므로 넣기
		for(temp=a; temp<=b; temp++){
			if(list[temp] > 0){
				bw.write(list[temp]+"\n");
			}
		}

		br.close();
		bw.close();
	}
}