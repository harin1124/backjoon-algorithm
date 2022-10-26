package backjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @title 새싹
 * @desc 아래 예제와 같이 새싹을 출력하시오.
 * @input 없음
 * @output 
 * @studyStartDate 2022-07-12
 * @studyEndDate 2022-07-12
 */
public class Problem25083 {
	/* ====================================
	예제 입력
	
	예제 출력
     	         ,r'"7
    r`-_   ,'  ,/
    \. ". L_r'
    `~\/
       |
       |
	==================================== */ 
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write("         ,r'\"7");
		bw.newLine();
		bw.write("r`-_   ,'  ,/");
		bw.newLine();
		bw.write(" \\. \". L_r'");
		bw.newLine();
		bw.write("   `~\\/");
		bw.newLine();
		bw.write("      |");
		bw.newLine();
		bw.write("      |");
		bw.close();
	}
}