package test;

/* =================================================
2022-01-12
�˰��� �Թ�-�ڹ� �� - ����
================================================= */
public class IntSet {
	private int max;     //������ �ִ� ����
	private int num;     //������ ��� ����
	private int[] set;   //���� ��ü
	
	//������
	public IntSet(int capacity){
		num=0;
		max=capacity;
		try {
			set=new int[max]; //���� �迭 ����
		}catch(OutOfMemoryError e){ //�迭 ���� ����
			max=0;
		}
	}
	
	//������ �ִ� ����
	public int capacity(){
		return max;
	}
	
	//������ ��� ����
	public int size(){
		return num;
	}
	
	//���տ��� n �˻� (�ε��� ��ȯ)
	public int indexOf(int n){
		for(int i=0; i<max; i++){
			if(n==set[i]){
				return i;
			}
		}
		return -1;
	}
	
	//���տ� n �ִ��� Ȯ��
	public boolean contains(int n){
		return this.indexOf(n) > -1;
	}
	
	//���տ� n �߰�
	public boolean add(int n){
		if(num >= max || this.contains(n)){
			return false;
		}else{
			set[num++]=n;
			return true;
		}
	}
	
	//���տ� n ���� - �����ؾ� ��
	public boolean remove(int n){
		if(num==0 || n > max){
			return false;
		}else{
			num--;
		}
		return true;
	}
}