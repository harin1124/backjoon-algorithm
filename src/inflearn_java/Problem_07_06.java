package inflearn_java;

import java.util.Scanner;

/**
 * @title 부분집합 구하기(DFS)
 * @desc 자연수 N이 주어지면 1부터 N까지의 원소를 갖는 집합의<br>
 * 부분집합을 모두 출력하는 프로그램을 작성하세요.
 * @input 첫 번째 줄에 자연수 N(1<=N<=10)이 주어집니다.
 * @output 첫 번째 줄부터 각 줄에 하나씩 부분집합을 아래와 출력예제와 같은 순서로 출력한다.<br>
 * 단 공집합은 출력하지 않습니다.
 * @studyStartDate 2024-03-03
 * @studyEndDate 2024-03-03
 */
public class Problem_07_06 {
    static int n;
    // 체크 배열
    static int[] ch;
    static void DFS(int level){
        if(level == n+1){
            // 배열 내 1로 체크된 값을 출력
            // 1은 사용한다는 의미이므로
            StringBuilder temp = new StringBuilder();
            for(int i=1; i<=n; i++){
                if(ch[i] == 1){
                    temp.append(i).append(" ");
                }
            }
            if(temp.length() > 0){
                System.out.println(temp);
            }
        } else {
            // 여기서 두 갈래로 뻗어야 함
            ch[level] = 1; // 사용한다 체크
            DFS(level+1); // 왼쪽
            
            ch[level] = 0; // 사용안한다 체크
            DFS(level+1); // 오른쪽
        }
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        scan.close();
        
        // 선언 시, 모든 배열 내 값은 0으로 초기화 상태
        ch = new int[n+1];
        
        DFS(1);
    }
}