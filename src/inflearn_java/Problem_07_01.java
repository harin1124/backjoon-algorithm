package inflearn_java;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * @title 재귀함수 (강의보고 풀이)
 * @desc 자연수 N이 입력되면 재귀함수를 이용하여 1부터 N까지를 출력하는 프로그램을 작성하세요.
 * @input 첫 번째 줄은 정수 N(3<=N<=10)이 입력된다.
 * @output 첫째 줄에 출력한다.
 * @studyStartDate 2024-02-20
 * @studyEndDate 2024-02-20
 */
public class Problem_07_01 {
    public static void printNumber(int number){
        if(number > 0){
            // 여기서, 호출부와 출력부의 순서에 따라 정답과 오답이 구분된다.
            // => 재귀는 스택 프레임을 사용
            printNumber(number-1);
            System.out.printf("%s ", number);
        }
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int num = scan.nextInt();
        printNumber(num);
        
        scan.close();
        bw.close();
    }
}