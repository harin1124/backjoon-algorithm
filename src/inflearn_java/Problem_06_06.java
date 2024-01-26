package inflearn_java;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @title 6. 장난꾸러기
 * @desc 새 학기가 시작되었습니다. 철수는 새 짝꿍을 만나 너무 신이 났습니다.<br>
 * 철수네 반에는 N명의 학생들이 있습니다.<br>
 * 선생님은 반 학생들에게 반 번호를 정해 주기 위해 운동장에 반 학생들을 키가 가장 작은 학생부터 일렬로 키순으로 세웠습니다.<br>
 * 제일 앞에 가장 작은 학생부터 반 번호를 1번부터 N번까지 부여합니다. 철수는 짝꿍보다 키가 큽니다.<br>
 * 그런데 철수가 앞 번호를 받고 싶어 짝꿍과 자리를 바꿨습니다.<br>
 * 선생님은 이 사실을 모르고 학생들에게 서있는 순서대로 번호를 부여했습니다.<br>
 * 철수와 짝꿍이 자리를 바꾼 반 학생들의 일렬로 서있는 키 정보가 주어질 때<br>
 * 철수가 받은 번호와 철수 짝꿍이 받은 번호를 차례로 출력하는 프로그램을 작성하세요.
 * @input 첫 번째 줄에 자연수 N(5<=N<=100)이 주어진다.<br>
 * 두 번째 줄에 제일 앞에부터 일렬로 서있는 학생들의 키가 주어진다.<br>
 * 키(높이) 값 H는 (120<=H<=180)의 자연수 입니다.
 * @output 첫 번째 줄에 철수의 반 번호와 짝꿍의 반 번호를 차례로 출력합니다.
 * @studyStartDate 2024-01-26
 * @studyEndDate 2024-01-26
 */
public class Problem_06_06 {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int size = scan.nextInt();
        int[] heightList = new int[size];
        int[] sortHeightList = new int[size];
        for(int i=0; i<size; i++){
            heightList[i] = scan.nextInt();
            sortHeightList[i] = heightList[i];
        }
        
        int chulsoo = -1;
        int mate = -1;
        
        // 정렬
        Arrays.sort(sortHeightList);
        
        // 정렬 후 대조 값이 다르면, 철수 또는 짝궁
        for(int i=0; i<size; i++){
            if(heightList[i] != sortHeightList[i]){
                // 철수가 -1 이면, 아직 철수는 할당되지 않은 것으로 철수에 값 할당
                // 항상 철수가 먼저 나온다.
                if(chulsoo == -1){
                    chulsoo = i+1;
                } else if(mate == -1){
                    mate = i+1;
                }
            }
        }
        
        bw.write(chulsoo+" "+mate);
        
        scan.close();
        bw.close();
    }
}