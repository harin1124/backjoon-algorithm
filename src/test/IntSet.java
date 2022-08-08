package test;

/* =================================================
2022-01-12
알고리즘 입문-자바 편 - 집합
================================================= */
public class IntSet {
	private int max;     //집합의 최대 개수
	private int num;     //집합의 요소 개수
	private int[] set;   //집합 본체
	
	//생성자
	public IntSet(int capacity){
		num=0;
		max=capacity;
		try {
			set=new int[max]; //집합 배열 생성
		}catch(OutOfMemoryError e){ //배열 생성 실패
			max=0;
		}
	}
	
	//집합의 최대 개수
	public int capacity(){
		return max;
	}
	
	//집합의 요소 개수
	public int size(){
		return num;
	}
	
	//집합에서 n 검색 (인덱스 반환)
	public int indexOf(int n){
		for(int i=0; i<max; i++){
			if(n==set[i]){
				return i;
			}
		}
		return -1;
	}
	
	//집합에 n 있는지 확인
	public boolean contains(int n){
		return this.indexOf(n) > -1;
	}
	
	//집합에 n 추가
	public boolean add(int n){
		if(num >= max || this.contains(n)){
			return false;
		}else{
			set[num++]=n;
			return true;
		}
	}
	
	//집합에 n 삭제 - 진행해야 함
	public boolean remove(int n){
		if(num==0 || n > max){
			return false;
		}else{
			num--;
		}
		return true;
	}
}