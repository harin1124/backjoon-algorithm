package inflearn_java;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @title 7. 교육과정 설계
 * @desc 현수는 1년 과정의 수업계획을 짜야 합니다.<br>
 * 수업중에는 필수과목이 있습니다. 이 필수과목은 반드시 이수해야 하며, 그 순서도 정해져 있습니다.<br>
 * 만약 총 과목이 A, B, C, D, E, F, G가 있고, 여기서 필수과목이 CBA로 주어지면 필수과목은 C, B, A과목이며 이 순서대로 꼭 수업계획을 짜야 합니다.<br>
 * 여기서 순서란 B과목은 C과목을 이수한 후에 들어야 하고, A과목은 C와 B를 이수한 후에 들어야 한다는 것입니다.<br>
 * 현수가 C, B, D, A, G, E로 수업계획을 짜면 제대로 된 설계이지만<br>
 * C, G, E, A, D, B 순서로 짰다면 잘 못 설계된 수업계획이 됩니다.<br>
 * 수업계획은 그 순서대로 앞에 수업이 이수되면 다음 수업을 시작하다는 것으로 해석합니다.<br>
 * 수업계획서상의 각 과목은 무조건 이수된다고 가정합니다.<br>
 * 필수과목순서가 주어지면 현수가 짠 N개의 수업설계가 잘된 것이면 “YES", 잘못된 것이면 ”NO“를 출력하는 프로그램을 작성하세요.<br>
 * @input 첫 줄에 한 줄에 필수과목의 순서가 주어집니다. 모든 과목은 영문 대문자입니다.<br>
 * 두 번 째 줄부터 현수가 짠 수업설계가 주어집니다.(수업설계의 길이는 30이하이다)
 * @output 첫 줄에 수업설계가 잘된 것이면 “YES", 잘못된 것이면 ”NO“를 출력합니다.
 * @studyStartDate 2024-01-21
 * @studyEndDate 2024 -01-21
 */
public class Problem_05_07 {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        Queue<Character> essentialCodeQueue = new LinkedList<>();
        for(char c : scan.nextLine().toCharArray()){
            essentialCodeQueue.add(c);
        }
        
        String codeList = scan.nextLine();
        
        int prefixIndex = 0;
        String result = "YES";
        while(!essentialCodeQueue.isEmpty()){
            Character c = essentialCodeQueue.poll();
            if(codeList.indexOf(c.toString()) < prefixIndex){
                result = "NO";
                break;
            } else {
                prefixIndex = codeList.indexOf(c.toString());
            }
        }
        bw.write(result);
        bw.close();
        scan.close();
    }
}