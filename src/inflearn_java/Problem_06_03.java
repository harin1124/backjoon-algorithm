package inflearn_java;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * @title 3. 삽입 정렬
 * @desc N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.<br>
 * 정렬하는 방법은 삽입정렬입니다.
 * @input 첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.<br>
 * 두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다.<br>
 * 각 자연수는 정수형 범위 안에 있습니다.
 * @output 오름차순으로 정렬된 수열을 출력합니다.
 * @studyStartDate 2024-01-24
 * @studyEndDate 2024-01-24
 */
public class Problem_06_03 {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int size = scan.nextInt();
        int[] array = new int[size];
        for(int i=0; i<size; i++){
            array[i] = scan.nextInt();
        }

        int tmp = 0;
        int j = 0;
        for(int i=1; i<size; i++){
            tmp = array[i];
            j = 0; // 아래에서 for문을 벗어난 뒤의 j 값이 필요하므로, 우선 선언
            for(j=i-1; j>=0; j--){
                // 현재 바라보고 있는 값의 이전 값이 더 크면 값 교환
                if(array[j] > tmp){
                    // 값의 교환은 j 기준에서 바라보는 곳보다 앞에다가 값을 넣어준다 => 값 밀어주기
                    array[j+1] = array[j];
                } else {
                    // 더 작으면 교환할 일이 없으므로, 종료
                    break;
                }
            }
            // 종료 시점의 인덱스(j)의 앞의 값에 미리 저장해둔 tmp 할당
            array[j+1] = tmp;
        }
        
        // 정답 출력
        for(int i : array){
            bw.write(i+" ");
        }
        bw.close();
        scan.close();
    }
}