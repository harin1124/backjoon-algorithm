package backjoon;

public class Main {
	public static void main(String[] args)throws Exception{
		// Garbage Collection으로 메모리 초기화
		Runtime.getRuntime().gc();
		
		long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		System.out.println("used memory is " + used + " bytes");

		//used memory is 651400 bytes
	}
}