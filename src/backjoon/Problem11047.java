package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @title 동전 0
 * @desc 준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.<br>
         동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다.<br>
         이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.
 * @input 첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000)<br>
          둘째 줄부터 N개의 줄에 동전의 가치 Ai가 오름차순으로 주어진다.<br>
          (1 ≤ Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수)
 * @output 첫째 줄에 K원을 만드는데 필요한 동전 개수의 최솟값을 출력한다.
 * @studyStartDate 2022-11-03
 * @studyEndDate 2022-11-03
 */
public class Problem11047 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer n = new StringTokenizer(br.readLine());

		int[] coinUnits = new int[Integer.parseInt(n.nextToken())];
		int useCoins = 0;
		int amount = Integer.parseInt(n.nextToken());

		int i = 0;
		// 코인 단위 받아내기
		for(i=0; i<coinUnits.length; i++){
			coinUnits[i] = Integer.parseInt(br.readLine());
		}
		
		// 코인 단위 배열 역순으로 순회하여, 하기
		for(i=coinUnits.length-1; i>=0; i--){
			System.out.println("coinUnits[i] = "+coinUnits[i]);
			if(amount >= coinUnits[i]){
				useCoins += amount / coinUnits[i];
				amount = amount - ( amount / coinUnits[i] * coinUnits[i] );
				if(amount == 0){
					break;
				}
				System.out.println("\tamount = "+amount);
				System.out.println("\tuseCoins = "+useCoins);
			}
		}
		System.out.println("===============================");
		bw.write(useCoins+"");

		br.close();
		bw.close();
	}
}
