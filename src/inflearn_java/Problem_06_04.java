package inflearn_java;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * @title 4. Least Recently Used
 * @desc 캐시메모리는 CPU와 주기억장치(DRAM) 사이의 고속의 임시 메모리로서 CPU가 처리할 작업을 저장해 놓았다가<br>
 * 필요할 바로 사용해서 처리속도를 높이는 장치이다. 워낙 비싸고 용량이 작아 효율적으로 사용해야 한다.<br>
 * 철수의 컴퓨터는 캐시메모리 사용 규칙이 LRU 알고리즘을 따른다.<br>
 * LRU 알고리즘은 Least Recently Used 의 약자로 직역하자면 가장 최근에 사용되지 않은 것 정도의 의미를 가지고 있습니다.<br>
 * 캐시에서 작업을 제거할 때 가장 오랫동안 사용하지 않은 것을 제거하겠다는 알고리즘입니다.<br>
 * 캐시의 크기가 주어지고, 캐시가 비어있는 상태에서 N개의 작업을 CPU가 차례로 처리한다면 N개의 작업을 처리한 후<br>
 * 캐시메모리의 상태를 가장 최근 사용된 작업부터 차례대로 출력하는 프로그램을 작성하세요.
 * @input 첫 번째 줄에 캐시의 크기인 S(3<=S<=10)와 작업의 개수 N(5<=N<=1,000)이 입력된다.<br>
 * 두 번째 줄에 N개의 작업번호가 처리순으로 주어진다. 작업번호는 1 ~100 이다.
 * @output 마지막 작업 후 캐시메모리의 상태를 가장 최근 사용된 작업부터 차례로 출력합니다.
 * @studyStartDate 2024-01-25
 * @studyEndDate 2024-01-25
 */
public class Problem_06_04 {
    public static class LRU {
        int[] cache;
        int cacheSize;
        public int jobSize;
        
        public LRU(int cacheSize, int jobSize){
            cache = new int[cacheSize];
            this.cacheSize = cacheSize;
            this.jobSize = jobSize;
        }
        
        /**
         * 캐시에 add 하는 것으로, 내부적으로 hit인지, miss인지 구분
         * @param jobCd 작업코드
         */
        public void add(int jobCd){
            // 할당전, 기존에 작업이 존재 여부 확인
            int idx = jobCdExists(jobCd);
            if(idx > -1){
                hit(idx);
            } else {
                miss(jobCd);
            }
        }
        
        /**
         * Cache Hit 로, 캐시 메모리에 작업이 존재하는 경우
         * @param jobCdIdx 작업코드의 인덱스
         */
        private void hit(int jobCdIdx){
            // HIT 로 인해 맨 앞으로 놓을 값 미리 저장
            int tmp = cache[jobCdIdx];
            
            // HIT 된 작업 코드의 인덱스부터 시작해서 하나씩 뒤로 밀어준다
            for(int i=jobCdIdx; i>0; i--){
                cache[i] = cache[i-1];
            }
            
            // 맨 앞에 놓을 값 할당
            cache[0] = tmp;
        }
        
        /**
         * Cache Miss 로, 캐시 메모리에 작업이 존재하지 않는 경우
         * @param newJobCd 추가될 새로운 작업 코드
         */
        private void miss(int newJobCd){
            // 맨 앞에 작업 코드가 추가되므로, 뒤에서부터 하나씩 밀어버린다
            for(int i=cacheSize-1; i>0; i--){
                cache[i] = cache[i-1];
            }
            cache[0] = newJobCd;
        }
        
        /**
         * 작업코드가 존재하는지 확인
         * @param jobCd 작업 코드
         * @return 존재 : 작업코드의 인덱스, 미존재 : -1
         */
        private int jobCdExists(int jobCd){
            for(int i=0; i<cacheSize; i++){
                if(cache[i] == jobCd){
                    return i;
                }
            }
            return -1;
        }
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 캐시 사이즈와, 작업의 갯수
        LRU lru = new LRU(scan.nextInt(), scan.nextInt());
        
        // 작업을 하나씩 add 처리
        for(int i=0, jobSize=lru.jobSize; i<jobSize; i++){
            lru.add(scan.nextInt());
        }
        
        // 정답 출력
        for(int i : lru.cache){
            bw.write(i+" ");
        }
        
        scan.close();
        bw.close();
    }
}