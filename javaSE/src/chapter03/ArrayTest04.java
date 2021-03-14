package chapter03;

import java.util.Arrays;

public class ArrayTest04 {
	public static void main(String[] args) {
		/* - �迭 ũ��� ���� �Ұ� �̹Ƿ� ũ�� ������ �ϰ� �ʹٸ� 
		 *   ���� �����ؼ� �����ؾ� �Ѵ�. 
		 *	System.arraycopy(src, srcPos, dest, destPos, length);  
		 *  src: ������ ���� 
		 *  srcPos: ������ ��ġ 
		 *  dest: �κ�(ī�Ǻ�)
		 *  destPos: �κ��� ����� ��ġ
		 *  length : ������ ����Ÿ ���� 
		 *  
		 */
		int[] src = {0,1,2,3,4,5,6,7};
		int[] copy1 = new int [15];			//��ü ī��
		int[] copy2 = new int [3];			//�κ� ī��
		
		System.arraycopy(src, 0, copy1, 0, src.length);  //��ü ī��
		System.out.println(Arrays.toString(copy1));
		
		System.arraycopy(src, 2, copy2, 0, copy2.length);  //�κ� ī��
		System.out.println(Arrays.toString(copy2));
		
		/*
		 * Arrays.copyOf(original, newLength)
		 * original : ������ ����
		 * newLength: �迭�� ���ο� ũ�� 
		 *  - �迭�� ���ο� ũ��� �����ؼ� ������ �����ؼ� ���� 
		 */
		System.out.println(Arrays.toString(Arrays.copyOf(src, src.length+5)));
		
		/*
		 *  Arrays.copyOfRange(original, from, to)
		 *  original : ������ ����
		 *  from :������ ���� ��ġ 
		 *  to : ������ ������ ��ġ
		 *  from��ġ ���� to��ġ���� �����ؼ� ����(�κк���)
		 */
		System.out.println(Arrays.toString(Arrays.copyOfRange(src, 1, 3)));
		
	}
}





