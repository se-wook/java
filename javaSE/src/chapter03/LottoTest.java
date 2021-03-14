package chapter03;

import java.util.Arrays;
import java.util.Random;

public class LottoTest {
	
	public static void uniqueValue(int index, int[] datas) {
		int imsi;
		boolean isSame; 	// �ߺ� ���θ� ����  flag
		Random ran = new Random();
		do {
			imsi = ran.nextInt(45)+1;//1~45������ ���� ���� �߻� 
			isSame = false;
			for (int i = 0; i <index; i++) {
				if(imsi == datas[i]) {
					isSame = true;
					break;
				}
			}
		}while(isSame);
		datas[index] = imsi;
	}
	public static void main(String[] args) {
		int[] lotto = new int[6];
		for (int i = 0, size = lotto.length; i < size; i++) {
			uniqueValue(i, lotto);
		}
		System.out.println(Arrays.toString(lotto));
	}
}







