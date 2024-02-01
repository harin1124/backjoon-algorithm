package inflearn_java;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @title 7. 좌표 정렬 (강의 보고 풀이)
 * @desc N개의 평면상의 좌표(x, y)가 주어지면 모든 좌표를 오름차순으로 정렬하는 프로그램을 작성하세요.<br>
 * 정렬기준은 먼저 x값의 의해서 정렬하고, x값이 같을 경우 y값에 의해 정렬합니다.
 * @input 첫째 줄에 좌표의 개수인 N(3<=N<=100,000)이 주어집니다.<br>
 * 두 번째 줄부터 N개의 좌표가 x, y 순으로 주어집니다. x, y값은 양수만 입력됩니다.
 * @output N개의 좌표를 정렬하여 출력하세요.
 * @studyStartDate 2024-02-01
 * @studyEndDate 2024-02-01
 */
public class Problem_06_07 {
    static class Point implements Comparable<Point> {
        public int x;
        public int y;
        
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        @Override
        public int compareTo(Point o){
            if(this.x == o.x){
                return this.y - o.y;
            } else {
                return this.x - o.x;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int size = scan.nextInt();
        ArrayList<Point> array = new ArrayList<>();
        
        for(int i=0; i<size; i++){
            array.add(new Point(scan.nextInt(), scan.nextInt()));
        }
        
        Collections.sort(array);
        
        for(Point o : array){
            bw.write(o.x+" "+o.y+"\n");
        }
        
        scan.close();
        bw.close();
    }
}