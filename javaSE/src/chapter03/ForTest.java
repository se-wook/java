package chapter03;

public class ForTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		for(int i=1;i<=10;i++) {
			sum += i;
		}
		System.out.println(sum);
		
		int[] a = new int[10];
//		for(int i=0, size=a.length;i<size;i++) {
//			System.out.println(a[i]);
//		}
		
		/*
		 * foreach : �迭 or �÷����� ������ �ݺ��ؼ� ������ �����͸� ������ ����.
		 * for(������Ÿ�� ������ : �迭 or �÷���){
		 * 		//code
		 * } 
		 */
		for (int i : a) {
			System.out.println(i);
		}
		
		
		
		
		
	}

}
