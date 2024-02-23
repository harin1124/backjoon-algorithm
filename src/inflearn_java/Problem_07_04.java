package inflearn_java;

import java.util.Scanner;

/**
 * @title 피보나치 수열
 * @desc 1) 피보나키 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.<br>
 * 2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.
 * @input 첫 줄에 총 항수 N(3<=N<=45)이 입력된다.
 * @output 첫 줄에 피보나치 수열을 출력합니다.
 * @studyStartDate 2024-02-23
 * @studyEndDate 2024-02-23
 */
public class Problem_07_04 {
    // 굉장히 느린 방식으로 추천하지 않는 방법
    public static int fibonacciNumber(int num){
        if(num == 1){
            return 1;
        } else if(num == 2){
            return 1;
        } else {
            return fibonacciNumber(num - 2) + fibonacciNumber(num - 1);
        }
    }

    // 피보나치 수열에 필요한 재귀 함수는
    // 이미 기존에 사용해서 알고 있는 경우가 있으므로
    // 배열을 만들어 저장해두고 사용하는 방식
    static int[] fiboArray;
    public static int fibonacciNumberFast(int num){
        // 메모리를 활용하여 시간복잡도를 줄이는 방법
        // 이미 배열에 값이 저장되어 있는 경우
        // 재귀를 하지 않고, 바로 배열에서 값을 꺼내 리턴한다.
        if(fiboArray[num] > 0){
            return fiboArray[num];
        }
        if(num == 1){
            fiboArray[num] = 1;
            return fiboArray[num];
        } else if(num == 2){
            fiboArray[num] = 1;
            return fiboArray[num];
        } else {
            // n번째인 경우를 구하면서, 배열에 저장해둔다.
            // 이는 나중에 꺼내쓰기 위하여 사용
            fiboArray[num] = fibonacciNumberFast(num - 2) + fibonacciNumberFast(num - 1);
            return fiboArray[num];
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        
        int num = scan.nextInt();

        fiboArray = new int[num+1];
        fibonacciNumberFast(num);

        // 피보나치 수열 출력
        for(int i=1; i<= num; i++){
            System.out.printf("%s ", fiboArray[i]);
        }

        scan.close();
    }
}