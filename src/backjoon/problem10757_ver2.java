package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
public class problem10757_ver2 {
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

		int nextPlus = 0;
		StringBuilder result = new StringBuilder();
		int maxNum = 0;
		int minNum = 0;
		for(int i=maxStr.length()-1, j=minStr.length()-1; i>=0; i--, j--){
			maxNum = maxStr.charAt(i)-48;
			System.out.println("max["+i+"] = "+maxNum);
			if(j >= 0){
				minNum = minStr.charAt(j)-48;
				System.out.println("min["+j+"] = "+minNum);
				if(nextPlus > 0){ // 올림수가 있으면
					if(maxNum + minNum + 1 >= 10){
						result.insert(0, maxNum+minNum+1-10);
						System.out.println("1. "+result);
						nextPlus = 1;
					} else {
						result.insert(0, maxNum+minNum+1);
						System.out.println("2. "+result);
						nextPlus = 0;
					}
				} else { // 올림수가 없으면
					if(maxNum + minNum >= 10){
						result.insert(0, maxNum+minNum-10);
						System.out.println("3. "+result);
						nextPlus = 1;
					} else {
						result.insert(0, maxNum+minNum);
						System.out.println("4. "+result);
						nextPlus = 0;
					}
				}
			} else {
				// maxDigit 혼자 더하기
				if(nextPlus > 0){ // 올림수가 있으면
					if(maxNum + 1 >= 10){
						result.insert(0, maxNum+1-10);
						System.out.println("5. "+result);
						nextPlus = 1;
					} else {
						result.insert(0, maxNum+1);
						System.out.println("6. "+result);
						nextPlus = 0;
					}
				} else { // 올림수가 없으면
					result.insert(0, maxNum);
					System.out.println("7. "+result);
					nextPlus = 0;
				}
			}
			if(i == 0 && nextPlus > 0){
				result.insert(0, "1");
			}
		}
		bw.write(result.toString());
		br.close();
		bw.close();
	}
}