package inflearn_java;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @title 5. 중복 확인
 * @desc 현수네 반에는 N명의 학생들이 있습니다.<br>
 * 선생님은 반 학생들에게 1부터 10,000,000까지의 자연수 중에서 각자가 좋아하는 숫자 하나 적어 내라고 했습니다.<br>
 * 만약 N명의 학생들이 적어낸 숫자 중 중복된 숫자가 존재하면 D(duplication)를 출력하고,<br>
 * N명이 모두 각자 다른 숫자를 적어냈다면 U(unique)를 출력하는 프로그램을 작성하세요.
 * @input 첫 번째 줄에 자연수 N(5<=N<=100,000)이 주어진다.<br>
 * 두 번째 줄에 학생들이 적어 낸 N개의 자연수가 입력된다.
 * @output 첫 번째 줄에 D 또는 U를 출력한다.
 * @studyStartDate 2024-01-25
 * @studyEndDate 2024-01-25
 */
public class Problem_06_05 {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int size = scan.nextInt();
        String result = "U";
        
        ArrayList<Integer> list = new ArrayList<>(size);
        int num = 0;
        for(int i=0; i<size; i++){
            num = scan.nextInt();
            if(list.contains(num)){
                result = "D";
                break;
            } else {
                list.add(num);
            }
        }
        bw.write(result);
        
        scan.close();
        bw.close();
    }
}