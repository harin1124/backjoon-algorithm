package inflearn_java;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @title 8. 응급실
 * @desc 메디컬 병원 응급실에는 의사가 한 명밖에 없습니다.<br>
 * 응급실은 환자가 도착한 순서대로 진료를 합니다. 하지만 위험도가 높은 환자는 빨리 응급조치를 의사가 해야 합니다.<br>
 * 이런 문제를 보완하기 위해 응급실은 다음과 같은 방법으로 환자의 진료순서를 정합니다.<br>
 * • 환자가 접수한 순서대로의 목록에서 제일 앞에 있는 환자목록을 꺼냅니다.<br>
 * • 나머지 대기 목록에서 꺼낸 환자 보다 위험도가 높은 환자가 존재하면 대기목록 제일 뒤로 다시 넣습니다. 그렇지 않으면 진료를 받습니다.<br>
 * 즉 대기목록에 자기 보다 위험도가 높은 환자가 없을 때 자신이 진료를 받는 구조입니다.<br>
 * 현재 N명의 환자가 대기목록에 있습니다.<br>
 * N명의 대기목록 순서의 환자 위험도가 주어지면, 대기목록상의 M번째 환자는 몇 번째로 진료를 받는지 출력하는 프로그램을 작성하세요.<br>
 * 대기목록상의 M번째는 대기목록의 제일 처음 환자를 0번째로 간주하여 표현한 것입니다.
 * @input 첫 줄에 자연수 N(5<=N<=100)과 M(0<=M<N) 주어집니다.<br>
 * 두 번째 줄에 접수한 순서대로 환자의 위험도(50<=위험도<=100)가 주어집니다.<br>
 * 위험도는 값이 높을 수록 더 위험하다는 뜻입니다. 같은 값의 위험도가 존재할 수 있습니다.
 * @output M번째 환자의 몇 번째로 진료받는지 출력하세요.
 * @studyStartDate 2024-01-22
 * @studyEndDate 2024-01-22
 */
public class Problem_05_08 {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int size = scan.nextInt();
        int targetPatientIdx = scan.nextInt();
        
        Queue<Integer> patientQueue = new LinkedList<>();
        for(int i=0; i<size; i++){
            patientQueue.offer(scan.nextInt());
        }
        
        int emergency = 0;
        boolean flag = true;
        boolean biggerEmergency = false;
        int cnt = 0;
        while(flag){
            emergency = patientQueue.poll();
            biggerEmergency = false;
            for(int i : patientQueue){
                // 본인 외에 더 응급도가 큰 환자가 있다면,
                // 뒤로 넣은 뒤, 찾으려는 환자의 인덱스(targetPatientIdx)를 하나 앞으로 당긴다.
                // 그 뒤 break 하여, 종료
                if(emergency < i){
                    patientQueue.offer(emergency);
                    // 현재 찾고자 하는 환자의 진료 순서를 뒤로 보낼 땐, index 조정 조건이 추가되어야 한다
                    targetPatientIdx = (targetPatientIdx == 0) ? patientQueue.size() - 1 : targetPatientIdx - 1;
                    biggerEmergency = true; // 더 큰 응급도를 찾으면 true로 바꾼다
                    break;
                }
            }
            // 더 큰 응급도를 찾지 못했다면 진료를 진행한다.
            if(!biggerEmergency){
                cnt++;
                // 진료를 받는 환자가 우리가 찾는 환자의 인덱스면, 종료
                if(targetPatientIdx == 0){
                    flag = false;
                }
                targetPatientIdx--;
            }
        }
        
        bw.write(cnt+"");
        bw.close();
        scan.close();
    }
}