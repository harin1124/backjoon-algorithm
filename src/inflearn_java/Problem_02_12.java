package inflearn_java;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.*;

/**
 * @title 12. 멘토링
 * @desc 현수네 반 선생님은 반 학생들의 수학점수를 향상시키기 위해 멘토링 시스템을 만들려고 합니다.<br>
 *       멘토링은 멘토(도와주는 학생)와 멘티(도움을 받는 학생)가 한 짝이 되어 멘토가 멘티의 수학공부를 도와주는 것입니다.<br>
 *       선생님은 M번의 수학테스트 등수를 가지고 멘토와 멘티를 정합니다.<br>
 *       만약 A학생이 멘토이고, B학생이 멘티가 되는 짝이 되었다면, A학생은 M번의 수학테스트에서 모두 B학생보다 등수가 앞서야 합니다.<br>
 *       M번의 수학성적이 주어지면 멘토와 멘티가 되는 짝을 만들 수 있는 경우가 총 몇 가지 인지 출력하는 프로그램을 작성하세요.
 * @input 첫 번째 줄에 반 학생 수 N(1<=N<=20)과 M(1<=M<=10)이 주어진다.<br>
 *        두 번째 줄부터 M개의 줄에 걸쳐 수학테스트 결과가 학생번호로 주어진다. 학생번호가 제일 앞에서부터 1등, 2등, ...N등 순으로 표현된다.<br>
 *        만약 한 줄에 N=4이고, 테스트 결과가 3 4 1 2로 입력되었다면 3번 학생이 1등, 4번 학생이 2등, 1번 학생이 3등, 2번 학생이 4등을 의미합니다.
 * @output 첫 번째 줄에 짝을 만들 수 있는 총 경우를 출력합니다.
 * @studyStartDate 2024-01-18
 * @studyEndDate 2024-01-19
 */
public class Problem_02_12 {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 학생의 수 (열)
        int userCnt = scan.nextInt();
        // 시험의 횟수 (행)
        int testCnt = scan.nextInt();
        
        int[][] scoreList = new int[testCnt][userCnt];
        
        // 값 입력받기
        for(int i=0; i<testCnt; i++){
            for(int j=0; j<userCnt; j++){
                scoreList[i][j] = scan.nextInt();
            }
        }
        
        int successCnt = 0;
        int usrIndex = 0;
        int menteeIndex = 0;
        boolean success = true;
        // 4중 for문을 돌면서 확인
        for(int usrNo=1; usrNo<userCnt+1; usrNo++){
            //System.out.println("usrNo(학생 번호) :"+usrNo);
            for(int menteeNo=1; menteeNo<userCnt+1; menteeNo++){
                if(usrNo != menteeNo){
                    //System.out.println("menteeNo(멘티 학생 번호) :"+menteeNo);
                    //System.out.println("가능 여부 확인 ("+usrNo+","+menteeNo+")");
                    success = true;
                    for(int x=0; x<testCnt; x++){
                        usrIndex = 0;
                        menteeIndex = 0;
                        for(int y=0; y<userCnt; y++){
                            if(scoreList[x][y] == usrNo){
                                usrIndex = y;
                            } else if(scoreList[x][y] == menteeNo){
                                menteeIndex = y;
                            }
                        }
                        if(menteeIndex > usrIndex){
                            success = false;
                            break;
                        }
                    }
                    if(success){
                        successCnt++;
                    }
                }
            }
        }
        bw.write(successCnt+"");
        bw.flush();
        bw.close();
        scan.close();
	}
}