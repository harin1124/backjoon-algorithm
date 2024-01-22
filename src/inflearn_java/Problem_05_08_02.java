package inflearn_java;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @title 8. 응급실 (강의 풀이)
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
public class Problem_05_08_02 {
    // 클래스를 생성하여 고유의 인덱스를 관리
    static class Person {
        private int id;
        private int priority;
        public Person (int id, int priority){
            this.id = id;
            this.priority = priority;
        }
        
        public String toString() {
            return "id="+id+"/priority="+priority;
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int size = scan.nextInt();
        int findIdx = scan.nextInt();
        
        // 두 개의 값을 모두 가질 수 있는 특정 객체의 Queue로 만들어서
        // 이전 풀이법의 targetPatientIdx 가 필요하지 않음
        Queue<Person> q = new LinkedList<>();
        for(int i=0; i<size; i++){
            q.offer(new Person(i, scan.nextInt()));
        }
        
        Person tmp = null;
        int cnt = 0;
        while(!q.isEmpty()){
            tmp = q.poll();
            for(Person person : q){
                if(person.priority > tmp.priority){
                    q.offer(tmp);
                    tmp = null;
                    break;
                }
            }
            if(tmp != null){
                cnt++;
                if(tmp.id == findIdx){
                    break;
                }
            }
        }
        
        bw.write(cnt+"");
        bw.close();
        scan.close();
    }
}