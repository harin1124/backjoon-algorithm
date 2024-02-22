package inflearn_java;

import java.util.Scanner;

/**
 * @title 팩토리얼
 * @desc 자연수 N이 입력되면 N!를 구하는 프로그램을 작성하세요.<br>
 * 예를 들어 5! = 5*4*3*2*1=120입니다
 * @input 첫 번째 줄에 자연수 N(1<=N<=10)이 주어집니다.
 * @output 첫 번째 줄에 N팩토리얼 값을 출력합니다.
 * @studyStartDate 2024-02-22
 * @studyEndDate 2024-02-22
 */
public class Problem_07_03 {
    /**
     * 팩토리얼 함수
     * 
     * 만약 factorial(5) 인 경우 실행 형태가 아래와 같다.
     * f(5)
     *   5 * f(4)
     *     4 * f(3)
     *       3 * f(2)
     *         2 * f(1)
     * @param number
     * @return
     */
    public static int factorial(int number){
        if(number == 1){
            return 1;
        }
        return number * factorial(number - 1);
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        
        int num = scan.nextInt();
        System.out.println(factorial(num));

        scan.close();
    }
}