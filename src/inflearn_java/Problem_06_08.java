package inflearn_java;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * @title 8. 이분검색
 * @desc 임의의 N개의 숫자가 입력으로 주어집니다.<br>
 * N개의 수를 오름차순으로 정렬한 다음 N개의 수 중 한 개의 수인 M이 주어지면<br>
 * 이분검색으로 M이 정렬된 상태에서 몇 번째에 있는지 구하는 프로그램을 작성하세요.<br>
 * 단 중복값은 존재하지 않습니다.
 * @input 첫 줄에 한 줄에 자연수 N(3<=N<=1,000,000)과 M이 주어집니다.<br>
 * 두 번째 줄에 N개의 수가 공백을 사이에 두고 주어집니다.
 * @output 첫 줄에 정렬 후 M의 값의 위치 번호를 출력한다.
 * @studyStartDate 2024-02-03
 * @studyEndDate 2024-02-03
 */
public class Problem_06_08 {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int size = scan.nextInt();
        int key = scan.nextInt();
        int[] arr = new int[size];
        
        // 값 입력받기
        for(int i=0; i<size; i++){
            arr[i] = scan.nextInt();
        }
        
        // 정렬 시작
        int temp = 0;
        int min = 0;
        for(int i=0; i<size; i++){
            min = i;
            for(int j=i+1; j<size; j++){
                if(arr[min] > arr[j]){
                    min = j;
                }
            }
            if(arr[min] == key){
                bw.write((i+1)+"");
                break;
            }
            temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        
        scan.close();
        bw.close();
    }
}