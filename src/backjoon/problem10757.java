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
 * @studyEndDate 2022-10-14
 */
public class problem10757 {
	public static void main(String[] args) throws Exception {
		// 메모리 절약을 위해 BufferedReader와 StringTokenizer 사용
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer numbers = new StringTokenizer(br.readLine());

		String maxStr = numbers.nextToken();
		String minStr = numbers.nextToken();

		if(maxStr.length() < minStr.length()){
			String temp = maxStr;
			maxStr = minStr;
			minStr = temp;
		}

		int[] maxDigit = Stream.of(maxStr.split("")).mapToInt(Integer::parseInt).toArray();
		int[] minDigit = Stream.of(minStr.split("")).mapToInt(Integer::parseInt).toArray();

		System.out.println(Arrays.toString(maxDigit));
		System.out.println(Arrays.toString(minDigit));

		// 올림수
		int nextPlus = 0;
		StringBuilder result = new StringBuilder();
		for(int i=maxDigit.length-1, j=minDigit.length-1; i>=0; i--, j--){
			System.out.println("max["+i+"] = "+maxDigit[i]);
			if(j >= 0){
				System.out.println("min["+j+"] = "+minDigit[j]);
				if(nextPlus > 0){ // 올림수가 있으면
					if((maxDigit[i] + minDigit[j] + 1) >= 10){
						result.insert(0, maxDigit[i] + minDigit[j] + 1 - 10);
						System.out.println("1. "+result);
						nextPlus = 1;
					} else {
						result.insert(0, maxDigit[i] + minDigit[j] + 1);
						System.out.println("2. "+result);
						nextPlus = 0;
					}
				} else { // 올림수가 없으면
					if((maxDigit[i] + minDigit[j]) >= 10){
						result.insert(0, maxDigit[i] + minDigit[j] - 10);
						System.out.println("3. "+result);
						nextPlus = 1;
					} else {
						result.insert(0, maxDigit[i] + minDigit[j]);
						System.out.println("4. "+result);
						nextPlus = 0;
					}
				}
			} else {
				// maxDigit 혼자 더하기
				if(nextPlus > 0){ // 올림수가 있으면
					if((maxDigit[i] + 1) >= 10){
						result.insert(0, maxDigit[i] + 1 - 10);
						System.out.println("5. "+result);
						nextPlus = 1;
					} else {
						result.insert(0, maxDigit[i] + 1);
						System.out.println("6. "+result);
						nextPlus = 0;
					}
				} else { // 올림수가 없으면
					result.insert(0, maxDigit[i]);
					System.out.println("7. "+result);
					nextPlus = 0;
				}
			}
			if(i == 0 && nextPlus > 0){
				result.insert(0, "1");
			}
			System.out.println("====================");
		}
		bw.write(result.toString());

		br.close();
		bw.close();
	}
}