package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @title 소인수분해
 * @desc 정수 N이 주어졌을 때, 소인수분해하는 프로그램을 작성하시오.
 * @input 첫째 줄에 정수 N (1 ≤ N ≤ 10,000,000)이 주어진다.
 * @output N의 소인수분해 결과를 한 줄에 하나씩 오름차순으로 출력한다. N이 1인 경우 아무것도 출력하지 않는다.
 * @studyStartDate 2022-10-26
 * @studyEndDate 2022-10-26
 */
public class Problem11653 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int num = Integer.parseInt(br.readLine());
		int mog = 0;
		int nmg = 0;

		if(num != 1){
			int i = 2;
			boolean init = true;
			while(true){
				System.out.println("==========================");
				System.out.println("i = "+i+"\tmog = "+mog+"\tnmg = "+nmg);
				// 2를 제외한 짝수 제외 필요함
				if(init){
					if(num % i > 0){
						i++;
						continue;
					}
					nmg = num % i;
					mog = num / i;

					System.out.println("mog = "+mog);
					System.out.println("nmg = "+nmg);
					init = false;
				} else {
					if(mog % i > 0){
						i++;
						continue;
					}
					nmg = mog % i;
					mog = mog / i;
					System.out.println("mog = "+mog);
					System.out.println("nmg = "+nmg);
				}

				if(i == num || mog == 1){
					System.out.println("\ti == num || mog == 1");
					bw.write(i+"\n");
					break;
				} else if(nmg == 0){
					System.out.println("\tnmg == 0");
					bw.write(i+"\n");
				} else {
					i++;
				}
			}

		}

		br.close();
		bw.close();
	}
}