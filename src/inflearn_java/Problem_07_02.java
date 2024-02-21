package inflearn_java;

import java.util.Scanner;

/**
 * @title 재귀함수를 이용한 이진수 출력
 * @desc 10진수 N이 입력되면 2진수로 변환하여 출력하는 프로그램을 작성하세요.<br>
 * 단, 재귀함수를 이용해서 출력해야 합니다. 
 * @input 첫 번째 줄에 10진수 N(1<=N<=1,000)이 주어집니다.
 * @output 첫 번째 줄에 이진수를 출력하세요.
 * @studyStartDate 2024-02-21
 * @studyEndDate 2024-02-21
 */
public class Problem_07_02 {
    public static void binaryNumber(int number){
        if(number == 0){
            return;
        } else {
            binaryNumber(number / 2);
            System.out.printf("%s", number % 2);
        }
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        
        int num = scan.nextInt();
        binaryNumber(num);
        
        scan.close();
    }
}