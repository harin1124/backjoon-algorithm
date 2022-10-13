package backjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

/**
 * @title 큰 수 A+B
 * @desc 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
 * @input 첫째 줄에 A와 B가 주어진다. (0 < A,B < 1010000)
 * @output 첫째 줄에 A+B를 출력한다.
 * @studyStartDate 2022-10-13
 * @studyEndDate 2022-10-
 */
public class problem10757 {
	public static void main(String[] args) throws Exception {
		// 메모리 절약을 위해 BufferedReader와 StringTokenizer 사용
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer numbers = new StringTokenizer(br.readLine());

		String maxStr = numbers.nextToken();
		int max = Integer.parseInt(maxStr);
		String minStr = numbers.nextToken();
		int min = Integer.parseInt(minStr);

		if(max < min){
			int temp = max;
			String tempStr = maxStr;
			max = min;
			min = temp;
			maxStr = minStr;
			minStr = tempStr;
		}


		int[] maxDigit = Stream.of(Integer.toString(max).split("")).mapToInt(Integer::parseInt).toArray();
		max = maxStr.length()-1;
		int[] minDigit = Stream.of(Integer.toString(min).split("")).mapToInt(Integer::parseInt).toArray();
		min = minStr.length()-1;

		System.out.println(Arrays.toString(maxDigit));
		System.out.println(Arrays.toString(minDigit));

		// 올림수
		int nextPlus = 0;
		String result = "";
		for(int i=max, j=min; i>=0; i--, j--){
			System.out.println("max["+i+"] = "+maxDigit[i]);
			if(j >= 0){
				System.out.println("min["+j+"] = "+minDigit[j]);
				if(nextPlus > 0){ // 올림수가 있으면
					if((maxDigit[i] + minDigit[j] + 1) > 10){
						result = ((maxDigit[i] + minDigit[j] + 1) - 10) + result;
						System.out.println("1. "+result);
						nextPlus = 1;
					} else {
						result = ((maxDigit[i] + minDigit[j] + 1)) + result;
						System.out.println("2. "+result);
						nextPlus = 0;
					}
				} else { // 올림수가 없으면
					if((maxDigit[i] + minDigit[j]) > 10){
						result = ((maxDigit[i] + minDigit[j]) - 10) + result;
						System.out.println("3. "+result);
						nextPlus = 1;
					} else {
						result = (maxDigit[i] + minDigit[j]) + result;
						System.out.println("4. "+result);
						nextPlus = 0;
					}
				}
			} else {
				// maxDigit 혼자 더하기
				if(nextPlus > 0){ // 올림수가 있으면
					if((maxDigit[i] + 1) > 10){
						result = ((maxDigit[i] + 1) - 10) + result;
						System.out.println("5. "+result);
						nextPlus = 1;
					} else {
						result = ((maxDigit[i] + 1)) + result;
						System.out.println("6. "+result);
						nextPlus = 0;
					}
				} else { // 올림수가 없으면
					result = maxDigit[i] + result;
					System.out.println("7. "+result);
					nextPlus = 0;
				}
			}
			System.out.println("====================");
		}
		System.out.println();
		System.out.println(result);

		br.close();
		bw.close();
	}
}