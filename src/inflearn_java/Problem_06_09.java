package inflearn_java;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @title 9. 뮤직비디오(결정알고리즘) (강의 보고 풀이)
 * @desc 지니레코드에서는 불세출의 가수 조영필의 라이브 동영상을 DVD로 만들어 판매하려 한다.<br>
 * DVD에는 총 N개의 곡이 들어가는데, DVD에 녹화할 때에는 라이브에서의 순서가 그대로 유지되어야 한다.<br>
 * 순서가 바뀌는 것을 우리의 가수 조영필씨가 매우 싫어한다.<br>
 * 즉, 1번 노래와 5번 노래를 같은 DVD에 녹화하기 위해서는 1번과 5번 사이의 모든 노래도 같은 DVD에 녹화해야 한다.<br>
 * 또한 한 노래를 쪼개서 두 개의 DVD에 녹화하면 안된다.<br>
 * 지니레코드 입장에서는 이 DVD가 팔릴 것인지 확신할 수 없기 때문에 이 사업에 낭비되는 DVD를 가급적 줄이려고 한다.<br>
 * 고민 끝에 지니레코드는 M개의 DVD에 모든 동영상을 녹화하기로 하였다.<br>
 * 이 때 DVD의 크기(녹화 가능한 길이)를 최소로 하려고 한다.<br>
 * 그리고 M개의 DVD는 모두 같은 크기여야 제조원가가 적게 들기 때문에 꼭 같은 크기로 해야 한다.
 * @input 첫째 줄에 자연수 N(1≤N≤1,000), M(1≤M≤N)이 주어진다.<br>
 * 다음 줄에는 조영필이 라이브에서 부른 순서대로 부른 곡의 길이가 분 단위로(자연수) 주어진다.<br>
 * 부른 곡의 길이는 10,000분을 넘지 않는다고 가정하자.
 * @output 첫 번째 줄부터 DVD의 최소 용량 크기를 출력하세요.
 * @studyStartDate 2024-02-05
 * @studyEndDate 2024-02-05
 */
public class Problem_06_09 {
    // DVD 장 수 구하는 메소드
    public static int dvdCount(int[] arr, int capacity){
        // DVD 장 수
        int cnt = 1;
        int sum = 0;
        
        for(int x : arr){
            // sum 은 현재 녹음되고 있는 용량
            if(sum + x > capacity){
                // 새로운 dvd 추가
                cnt++;
                sum = x;
            } else {
                sum += x;
            }
        }
        return cnt;
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int songSize = scan.nextInt();
        int dvdSize = scan.nextInt();
        
        int[] songArr = new int[songSize];
        
        // 값 입력받기
        for(int i=0; i<songSize; i++){
            songArr[i] = scan.nextInt();
        }
        
        int result = 0;
        
        int lt = Arrays.stream(songArr).max().getAsInt();
        int rt = Arrays.stream(songArr).sum();
        int mid = 0;
        
        while(lt <= rt){
            // dvd 한장의 용량 값 우선 산정
            mid = (lt + rt) / 2;
            // 해당 용량 가능한지 확인
            if(dvdCount(songArr, mid) <= dvdSize){
                // 담을 수 있음
                result = mid;
                // 값을 더 좁혀나가기
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        
        bw.write(result+"");
        
        scan.close();
        bw.close();
    }
}