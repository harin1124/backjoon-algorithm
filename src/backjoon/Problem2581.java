package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @title 소수
 * @desc 자연수 M과 N이 주어질 때 M이상 N이하의 자연수 중 소수인 것을<br>
         모두 골라 이들 소수의 합과 최솟값을 찾는 프로그램을 작성하시오.<br>
         예를 들어 M=60, N=100인 경우 60이상 100이하의 자연수 중 소수는 61, 67, 71, 73, 79, 83, 89, 97 총 8개가 있으므로,<br>
         이들 소수의 합은 620이고, 최솟값은 61이 된다.
 * @input 입력의 첫째 줄에 M이, 둘째 줄에 N이 주어진다.<br>
          M과 N은 10,000이하의 자연수이며, M은 N보다 작거나 같다.
 * @output M이상 N이하의 자연수 중 소수인 것을 모두 찾아 첫째 줄에 그 합을, 둘째 줄에 그 중 최솟값을 출력한다.
           단, M이상 N이하의 자연수 중 소수가 없을 경우는 첫째 줄에 -1을 출력한다.
 * @studyStartDate 2022-10-19
 * @studyEndDate 2022-10-19
 */
public class Problem2581 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int m = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		boolean isPrimeNumber = true;
		int sum = 0;
		int min = n;

		if(m == n){
			for(int i=1; i<=n; i++){
				if(n % i == 0 && i != 1 && n != i){
					isPrimeNumber = false;
					break;
				}
			}
			if(isPrimeNumber && n != 1){ // 1은 소수가 아니므로 예외처리
				min = n;
				sum = n;
			}
		} else {
			for(int i=m; i<=n; i++){
				isPrimeNumber = true;
				System.out.println("i = "+i);
				for(int j=1; j<=i; j++){
					System.out.println("\tj = "+j);
					if(i % j == 0 && j != 1 && i != j){
						System.out.println("\tj"+"로 나누었을 때, 나머지가 없으므로 소수가 아닙니다.");
						isPrimeNumber = false;
						break;
					}
				}
				if(isPrimeNumber && i != 1){ // 1은 소수가 아니므로 예외처리
					if(min >= i){
						min = i;
					}
					System.out.println("소수로 더해지는 수 : "+i);
					sum += i;
				}
			}
		}

		// sum이 0일경우 어떤 소수도 발견하지 못했으므로, -1을 리턴
		if(sum == 0){
			bw.write(-1+"");
		} else {
			bw.write(sum+"\n");
			bw.write(min+"");
		}

		br.close();
		bw.close();
	}
}
