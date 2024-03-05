package inflearn_java;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @title 송아지 찾기(BFS : 상태트리탐색)
 * @desc 현수는 송아지를 잃어버렸다. 다행히 송아지에는 위치추적기가 달려 있다.<br>
 * 현수의 위치와 송아지의 위치가 수직선상의 좌표 점으로 주어지면<br>
 * 현수는 현재 위치에서 송아지의 위치까지 다음과 같은 방법으로 이동한다.<br>
 * 송아지는 움직이지 않고 제자리에 있다.<br>
 * 현수는 스카이 콩콩을 타고 가는데 한 번의 점프로 앞으로 1, 뒤로 1, 앞으로 5를 이동할 수 있다.<br>
 * 최소 몇 번의 점프로 현수가 송아지의 위치까지 갈 수 있는지 구하는 프로그램을 작성하세요.
 * @input 첫 번째 줄에 현수의 위치 S와 송아지의 위치 E가 주어진다.<br>
 * 직선의 좌표 점은 1부터 10,000까지이다.
 * @output 점프의 최소횟수를 구한다. 답은 1이상이며 반드시 존재합니다
 * @studyStartDate 2024-03-05
 * @studyEndDate 2024-03-05
 */
public class Problem_07_08 {
    static int[] chkList;
    static int[] dis = {1, -1, 5};
    static int BFS(int myPos, int cowPos){
        Queue<Integer> q = new LinkedList<>();
        
        chkList[myPos] = 1;
        q.offer(myPos);
        
        int level = 0;
        
        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0; i<len; i++){
                int current = q.poll();
                for(int j=0; j<3; j++){
                    int nextValue = current + dis[j];
                    
                    if(nextValue == cowPos){
                        return level;
                    }
                    
                    // 다음 값이 1 이상이고, (계산상 -1이 나올 수 있지만, 굳이 해당 값을 볼 필요가 없다)
                    // 다음 값이 1만보다 작거나 같아야 하고, (좌표의 최대값은 1만이기 때문에 그 이상은 필요 없다)
                    // 이미 나온 값을 확인하는 배열에서 다음 값이 0일 때
                    // (0은 현재 나온적이 없으므로, 체크해야하고 큐에 넣어도 된다는 것)
                    if(nextValue >= 1 && nextValue <= 10000 && chkList[nextValue] == 0){
                        // 사용 처리
                        chkList[nextValue] = 1;
                        // 큐에 추가
                        q.offer(nextValue);
                    }
                }
            }
            level++;
        }
        return 0;
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        chkList = new int[10001];
        
        int myPos = scan.nextInt();
        int cowPos = scan.nextInt();
        
        int result = BFS(myPos, cowPos);
        bw.write(result+"");
        
        bw.close();
        scan.close();
    }
}